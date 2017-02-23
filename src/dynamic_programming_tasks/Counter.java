package dynamic_programming_tasks;

import java.util.ArrayList;
import java.util.List;

/**
 * У исполнителя Counter есть две команды, которым присвоены номера.
 * 1. прибавь x
 * 2. умножь на y
 * Сколько всего таких комбинаций команд, которые преобразуют число N в число R?
 */
public class Counter {

    private static int N, R;
    private static List<Integer> list;
    private static int sum;
    private static int operator1, operator2; // x и y

    public static void start(int N, int R, int op1, int op2) {
        operator1 = op1;
        operator2 = op2;
        Counter.N = N;
        Counter.R = R;
        list = new ArrayList<>();

        find(N);

        for (Integer el : list)
            sum += el;

        System.out.println(sum);
    }

    public static void find(int n) {
        if (n > R) return;
        if (n == R) list.add(1);

        find(n + operator1);
        find(n * operator2);

    }


}
