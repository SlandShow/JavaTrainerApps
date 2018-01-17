package DeutscheTelekomTasks.second;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/*
 * Created by SlandShow on 07.01.2018.
 */
public class DuplicateFinderImpl implements DuplicateFinder {

    private Map<String, Integer> map = new HashMap<>();

    private boolean createInputFile(File file) {
        try {
            if (!file.exists())
                file.createNewFile();
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    private boolean read(File input) {
        BufferedReader reader = null;
        
        try {
            String currentElement;
            reader = new BufferedReader(new FileReader(input));

            while ((currentElement = reader.readLine()) != null) {
                if (map.containsKey(currentElement)) {
                    map.put(currentElement, map.get(currentElement) + 1);
                } else
                    map.put(currentElement, 1);
            }
        } catch (IOException e) {
            return false;
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
            }
        }

        return true;
    }

    private boolean write(File output) {
        BufferedWriter writer = null;
        
        try {
            writer = new BufferedWriter(new FileWriter(output));
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                writer.write(entry.getKey().toString() + "[" + entry.getValue().toString() + "]\n");
            }
        } catch (IOException e) {
            return false;
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
            }
        }

        return true;
    }

    @Override
    public boolean process(File sourceFile, File targetFile) {
        if (createInputFile(sourceFile) && createInputFile(targetFile)) {
            // Read data from first file
            if (!read(sourceFile))
                return false; // If smth go wrong
            
            // Sort Map using Binary Tree (tmp variable)
            Map<String, Integer> tree = new TreeMap<String, Integer>(map);
            map = tree;

            // Write data to second file
            if (!write(targetFile))
                return false;
        } else
            return false;

        return true;
    }
}
