package words_combinatorics;


import java.util.ArrayList;

public class Combinator {

    private String strk;
    private String[] strk_array;
    private ArrayList<String> list;
    private int N;

    public Combinator(String v) {
        strk = v;
        strk_array = strk.split("");
        N = strk.length();
        list = new ArrayList<>();
    }


    public void startCombine() {
        for (int i = 0; i < N; i++) {
            String tmp = strk_array[i];
            agglutinate(tmp);
        }
    }

    private void agglutinate(String v) {

        if (v.length() == N) {
           // list.add(v);
            System.out.println(v);
            return;
        }

        for (int j = 0; j < N; j++)
            agglutinate(v + strk_array[j]);
        
    }

    // print sequence of symbols
    public void printSequence() {
        for (String elem : list) System.out.println(elem);
    }


}
