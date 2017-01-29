package problem22;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Admin on 29.01.2017.
 */
public class Varience {


    public static int F = 0;
    public static int D = 23;
    public static List<String> list = new ArrayList<>();


    public static void start() {
        Scanner in = new Scanner(System.in);
        Random r = new Random();

        while (F < 25) {
            String commands = "";

            D = 23;
            while (D < 48) {
                int f=0;
                int N = r.nextInt(2) + 1;
                if (N==2)
                    f++;
                if (f==3)
                    N=1;

                commands += N;
                calculate(N);
                /*System.out.println(D);*/
            }
            if (D == 48) {
                boolean flag=false;
                for (String element : list) {


                    if (element.equals(commands)) {

                        flag=true;
                    }

                }
                if (flag==false){
                    F++;
                    list.add(commands);
                    /*System.out.println("No");*/
                }
            }
            System.out.println(F);
        }

        for (String element: list) {
            System.out.println(element);
        }
    }

    
    public static void calculate(int n) {

        if (n == 1)
            D++;
        else {
            if (n % 10 != 9 && (n / 10) % 10 != 9) D += 11;
            else
                D += 10;
        }

    }


}
