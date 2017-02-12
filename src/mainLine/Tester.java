package mainLine;


import HuffmanCoding.HuffmanCodeApp;
import It_School_Samsung_Tasks.Sequence;
import ProjectEulerTasks.mult_3_5.Problem1Task;
import ProjectEulerTasks.mult_3_5.Problem2Task;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import reversePolishNotation.Calculate;
import reversePolishNotation.ReversePolishNotationApp;
import task.TaskApp;
import words_combinatorics.Combinator;

import java.util.Objects;

public class Tester {

    /* Сборник интересных задачек, которые мне удалось найти на просторе интернета */

    public static final void main(String[] args) {


        // Комбинаторика в словах
        // Combinator comb = new Combinator("abcd");
        //comb.startCombine();
        //comb.printSequence();


        // Считаем максимальтное произведение в массиве из 3-х чисел
        //TaskApp.start(-10,-10,2,1,3,999);


        // Алгоритм хаффмена для сжатия данных
        HuffmanCodeApp.start();


        // Обратная польская запись
        // Считает выражения с разным кол-вом операторов и операнд
        /*ReversePolishNotationApp o = new ReversePolishNotationApp();
        Calculate calc;
        String testString = "((3+4)*3)*2";

        o.transform(testString);
        o.show();
        String oneOfresult = o.getNewNotation();
        calc = new Calculate(oneOfresult);
        String result = "" + calc.doParse();
        System.out.println(result);*/

        // Последовательности
        //Sequence.init();
    }

}


