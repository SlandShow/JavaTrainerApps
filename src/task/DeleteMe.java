package task;

import java.util.ArrayList;

/**
 * Created by Admin on 13.08.2016.
 */
public class DeleteMe {

    public int f(int a,int b) {
        return a>b?a:b;

        /*if(a>b) return a;
          return b;
        */
    }




















    /*
    long[] tmpMinus; long[] tmpPlus;
 boolean checkPlus = false; boolean checkMinus = false;
 long[] array = val; long tmp = 0;
 ArrayList<Long> plusArray = new ArrayList<Long>();
 ArrayList<Long> minusArray = new ArrayList<Long>();
 int count = 0;




 //1 этап: подсчет кол-ва отрицательных чисел
 for(long iterator : val) {
     if(count > 1) break; //чтобы не тратить много времени на весь подсчет
     if(iterator < 0) count++;
 }

 //1 тап 2-ой пункт: распределяем массивы на отриц. и положительные
 for(int i = 0 ; i < array.length ; i++){
     if(array[i] < 0) minusArray.add(array[i]); //отриц. числа
     else if(array[i] > 0) plusArray.add(array[i]); //положит. числа
 }

     long tmpPlusVal = 0; long tmpMinusVal = 0;


     long max1 = findmaxValueOfPlusArray(array);
     for(int i = 0 ; i < plusArray.size() ; i++){

        if(checkPlus) break;
         long element = plusArray.get(i);
         for(int j = 0 ; j < plusArray.size() ; j++){
             if(i != j){
                 if(element == plusArray.get(j) && element == max1 ) { checkPlus = true; tmpPlusVal = element; System.out.println("найден полож " + tmpPlusVal);}
             }
             if(checkPlus) break;
         }
     }

     //берем элементы отриц. массива по модулю (для корректного сравнения)
     tmpMinus = new long[minusArray.size()];
     for(int i = 0; i < minusArray.size(); i++){
         tmpMinus[i] = -1 * minusArray.get(i);
     }

     long max2 = findmaxValueOfPlusArray(tmpMinus);

     for(int i = 0 ; i < minusArray.size() ; i++){
         if(checkMinus) break;
         long element = minusArray.get(i);

         for(int j = 0 ; j < minusArray.size() ; j++){
             if(i != j){
                 if(element == minusArray.get(j) && element == -1*max2) {
                     checkMinus = true; tmpMinusVal = element;
                     System.out.println("найден отриц element" + element); break;  }
                 if(checkMinus) break;
             }

         }

     }

     if(!checkPlus && checkMinus)


     if(checkPlus || checkMinus){
         System.out.println("Проверка");

     if(count > 1){

          long res1 = tmpMinusVal * tmpMinusVal; long res2 = tmpPlusVal * tmpPlusVal;

         System.out.println(tmpMinusVal + " " + tmpPlusVal);

         if(res1 < res2){
            tmp = tmpPlusVal * findTwoMaxMultiplication(array);

         }else{
             tmp = tmpMinusVal * findmaxValueOfPlusArray(array); System.out.println("первый пункт ");
         }

      }

     }


else

 //2-ой этап: если отриц. чисел в массиве больше одного, то ...
 if(count > 1){



  //считаем произведение 2х макс. отриц чисел и двух положительных
  long res1 = findTwoMaxMultiplication(tmpMinus); long res2 = findTwoMaxMultiplication(array);


 //если произведение отриц. чисел меньше положительных,
// то тогда максимальным произведением будет 3 самых больших полож. числа
 if(res1 < res2) {
     tmp = findThreeMaxValuesMultiplication(array);
 }
 else {
    //иначе, умножаем произведение самых больших отриц. чисел на самое большое положительное
    tmp = res1 * findmaxValueOfPlusArray(array);
 }


 } else{
     //2-ой этап 2 пункт:
     // если отриц. чисел в массиве нет или же только одно, то считаем максимальное произведение трех положительных чисел
    tmp = findThreeMaxValuesMultiplication(array);
 }

     System.out.println("Return tmp, wich equals " + tmp);
     return tmp;
     */





  //new version - BAD APP
    /*package task;



    import java.util.ArrayList;

    public class TaskApp {

        public static void main(String[] args) {
            System.out.println(new TaskApp().findMaxMultiplication(-4,-3,1,2,3,9,9,9));
            // System.out.println(new TaskApp().findThreeMaxEqualsValuesMultiplication(-10,-10,1,2,4,4));


        }



        public long findMaxMultiplication(long...val) {

            long[] tmpMinus; long[] tmpPlus;
            boolean checkPlus = false; boolean checkMinus = false;
            long[] array = val; long tmp = 0;
            ArrayList<Long> plusArray = new ArrayList<Long>();
            ArrayList<Long> minusArray = new ArrayList<Long>();
            int count = 0;




            //1 этап: подсчет кол-ва отрицательных чисел
            for(long iterator : val) {
                if(count > 1) break; //чтобы не тратить много времени на весь подсчет
                if(iterator < 0) count++;
            }

            //1 тап 2-ой пункт: распределяем массивы на отриц. и положительные
            for(int i = 0 ; i < array.length ; i++){
                if(array[i] < 0) minusArray.add(array[i]); //отриц. числа
                else if(array[i] > 0) plusArray.add(array[i]); //положит. числа
            }


            long tmpPlusVal = 0; long tmpMinusVal = 0;
            int countPlus = 0;

            long max1 = findmaxValueOfPlusArray(array);
            for(int i = 0 ; i < plusArray.size() ; i++){

                if(checkPlus){ countPlus++;  break; }
                long element = plusArray.get(i);
                for(int j = 0 ; j < plusArray.size() ; j++){
                    if(i != j){
                        if(element == plusArray.get(j) && element == max1 ) { checkPlus = true; countPlus++; tmpPlusVal = element; }
                    }
                }
            }
            System.out.println("найден полож " + tmpPlusVal + " " + countPlus);


            //берем элементы отриц. массива по модулю (для корректного сравнения)
            tmpMinus = new long[minusArray.size()];
            for(int i = 0; i < minusArray.size(); i++){
                tmpMinus[i] = -1 * minusArray.get(i);
            }

            long max2 = findmaxValueOfPlusArray(tmpMinus);

            for(int i = 0 ; i < minusArray.size() ; i++){
                if(checkMinus) break;
                long element = minusArray.get(i);

                for(int j = 0 ; j < minusArray.size() ; j++){
                    if(i != j){
                        if(element == minusArray.get(j) && element == -1*max2) {
                            checkMinus = true; tmpMinusVal = element;
                            System.out.println("найден отриц element" + element); break;  }
                        if(checkMinus) break;
                    }

                }

            }




            //2-ой этап: если отриц. чисел в массиве больше одного, то ...
            if(count > 1){



                //считаем произведение 2х макс. отриц чисел и двух положительных
                long res1 = findTwoMaxMultiplication(tmpMinus); long res2 = findTwoMaxMultiplication(array);


                //если произведение отриц. чисел меньше положительных,
// то тогда максимальным произведением будет 3 самых больших полож. числа
                if(res1 < res2) {
                    if(checkMinus || checkPlus){
                        if(checkPlus) {
                            if (countPlus == 2) tmp = tmpPlusVal * findTwoMaxMultiplication(array);
                            if (countPlus >= 3) tmp = tmpPlusVal * tmpPlusVal * tmpPlusVal;
                            System.out.println(tmp + " что то тут не так...");
                        }
                    } else tmp = findThreeMaxValuesMultiplication(array);

                }
                else {
                    if(checkMinus){

                    }else
                        //иначе, умножаем произведение самых больших отриц. чисел на самое большое положительное
                        tmp = res1 * findmaxValueOfPlusArray(array);
                }


            } else{
                //2-ой этап 2 пункт:
                // если отриц. чисел в массиве нет или же только одно, то считаем максимальное произведение трех положительных чисел
                tmp = findThreeMaxValuesMultiplication(array);
            }


            return tmp;
        }




        public long findTwoEqualsMultiplication(long...val){

            long[] array = val;
            long max1 = 0; long max2 = 0;

            for(int i1 = 0 ; i1 < array.length ; i1++) if(max1 < array[i1]) max1 = array[i1];
            for(int i2 = 0 ; i2 < array.length ; i2++) if(max2 < array[i2] && max1 >= array[i2]) max2 = array[i2];

            System.out.println(max1 + " " + max2);
            return max1 * max2;
        }



        public long findTwoMaxMultiplication(long...val){

            long[] array = val;
            long max1 = 0; long max2 = 0;

            for(int i1 = 0 ; i1 < array.length ; i1++) if(max1 < array[i1]) max1 = array[i1];
            for(int i2 = 0 ; i2 < array.length ; i2++) if(max2 < array[i2] && max1 > array[i2]) max2 = array[i2];

            System.out.println(max1 + " " + max2);
            return max1 * max2;
        }





        public long findmaxValueOfPlusArray(long...val) {

            long[] array = val;
            long max = array[0];

            for(long el : val) if(max < el) max = el;

            return max;
        }


        public long findThreeMaxEqualsValuesMultiplication(long...val){

            long[] array = val;
            long m1,m2,m3;

            m1 = 0; m2 = 0; m3 = 0;

            //поиск трех макс. чисел
            for(int i1 = 0 ; i1 < array.length ; i1++) if(m1 < array[i1]) m1 = array[i1];
            for(int i2 = 0 ; i2 < array.length ; i2++) if(m2 < array[i2] && m1 >= array[i2]) m2 = array[i2];
            for(int i3 = 0 ; i3 < array.length ; i3++) if(m3 < array[i3] && m2 > array[i3]) m3 = array[i3];


            return m1 * m2 * m3;
        }


        public long findThreeMaxValuesMultiplication(long...val) {

            long[] array = val;
            long m1,m2,m3;

            m1 = 0; m2 = 0; m3 = 0;

            //поиск трех макс. чисел
            for(int i1 = 0 ; i1 < array.length ; i1++) if(m1 < array[i1]) m1 = array[i1];
            for(int i2 = 0 ; i2 < array.length ; i2++) if(m2 < array[i2] && m1 > array[i2]) m2 = array[i2];
            for(int i3 = 0 ; i3 < array.length ; i3++) if(m3 < array[i3] && m2 > array[i3] && m1 > array[i3]) m3 = array[i3];


            return m1 * m2 * m3;
        }


    }



*/









}
