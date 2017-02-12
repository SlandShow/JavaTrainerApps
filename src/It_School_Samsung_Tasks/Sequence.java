package It_School_Samsung_Tasks;

import java.util.Scanner;

/**
 * Created by Admin on 29.12.2016.
 */
public class Sequence {

    /*С клавиатуры вводится натуральное число N (N<1000).
      После этого вводится еще N-1 различных натуральных чисел, каждое из которых ≤N.
      Вывести на экран такое натуральное число ≤N, которого нет среди введенных.*/

    public static void init() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите N");
        int N = in.nextInt();

        int[] array = new int[N - 1];

        System.out.println("Заполнение...");

        for (int i = 0; i < N - 1; i++) {
            int tmp = in.nextInt();
            if (tmp > N) System.exit(-1);
            array[i] = tmp;
        }

        System.out.println(calculate(array, N));
    }


    private static int calculate(int[] a, int N) {
        boolean flag = false;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < a.length; j++) {
                if (i == a[j]) {
                    flag = true;
                    break;
                } else flag = false;
            }
            if (flag == false) return i;
        }
        return -1;
    }

}
