package simple_task;

import java.util.Scanner;

/**
 * Created by Admin on 22.04.2017.
 */
public class Consistency {
    /* Опишите алгоритм подсчёта максимального количества подряд идущих элементов,
       каж­дый из которых больше предыдущего, в целочисленном массиве длины 30 */


    private static int N; // size of consistency
    private static int[] array;
    private static int count1, count2;
    private static Scanner input;

    public static int calculate() {
        input = new Scanner(System.in);
        N = input.nextInt();
        array = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = input.nextInt();
        }

        for (int i = 0; i < N - 1; i++) {
            if (array[i] < array[i + 1]) count1++;
            else if (array[i] > array[i + 1]) {
                count2 = count1;
                count1 = 0;
            }
        }
        return Math.max(count1, count2);
    }

}
