package task;




/*
Условие задачи:
У вас есть массив с целыми числами, в том числе и отрицательными, вам нужно найти самое большое произведение 3 чисел из этого массива.

Например: массив состоит из чисел -10, -10, 1, 3, 2
Нужный результат - это  -10 * -10 * 3  (т.е 300)
 */


import java.util.ArrayList;
import java.util.PriorityQueue;

public class TaskApp {


    public static void start(long...array) {
        System.out.println("Максимальное произведение равно " + new TaskApp().findMaxMultiplication(array));
    }



    public long findMaxMultiplication(long...val) {

        long[] array = val; long tmp = 0;
        ArrayList<Long> plusArray = new ArrayList<Long>();
        ArrayList<Long> minusArray = new ArrayList<Long>();
        int count = 0;
        PriorityQueue<Long> minusPQ = new PriorityQueue<Long>();
        PriorityQueue<Long> plusPQ = new PriorityQueue<Long>();


        //1 этап: подсчет кол-ва отрицательных чисел
        for(long iterator : val) {
            if(count > 1) break; //чтобы не тратить много времени на весь подсчет
            if(iterator < 0) count++;
        }


        //1 тап 2-ой пункт: распределяем массивы на отриц. и положительные
        for(int i = 0 ; i < array.length ; i++){
            if(array[i] < 0) { minusArray.add(array[i]); minusPQ.add(array[i]); }//отриц. числа
            else if(array[i] > 0) { plusArray.add(array[i]); plusPQ.add(array[i]); }//положит. числа
        }

        //проверка:
        if(plusArray.size() < 3) {
            System.out.println("Входные данные должны состоять как минимум из 3 положительных чисел");
            System.exit(0);
        }


        //1 этап 3-ий пункт: добавляем элементы в приоритетную очередь 
        long resxPlus; long resxMinus = 0;

        //берем 2 самых больших отриц. и самое большое полож. число
        if(count > 1) resxMinus = minusPQ.poll() * minusPQ.poll() * findmaxValueOfPlusArray(array);
        while (plusPQ.size() > 3) plusPQ.poll();
        resxPlus = plusPQ.poll() * plusPQ.poll() * plusPQ.poll();


        //2-ой этап: если отриц. чисел в массиве больше одного, то ...
        if(count > 1){

            //если произведение 2х самых больших по модулю отриц. чисел и одного положительного больше
            // чем произведение трех самых больших положительных, то нужный результат - это
            //произведение 2х самых больших по модулю отриц. чисел и одного положительного
            if(resxMinus > resxPlus)tmp = resxMinus;
            else tmp = resxPlus;
        // если отриц. чисел в массиве нет или же только одно, то считаем максимальное произведение трех положительных чисел
        }else tmp = resxPlus;



        return tmp;
    }



    public long findmaxValueOfPlusArray(long...val) {

        long[] array = val;
        long max = 0;

        for(long el : val) if(max < el) max = el;

        return max;
    }




}
