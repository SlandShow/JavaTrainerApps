package mainLine;


import HuffmanCoding.HuffmanCodeApp;
import It_School_Samsung_Tasks.Sequence;
import ProjectEulerTasks.mult_3_5.Problem1Task;
import ProjectEulerTasks.mult_3_5.Problem2Task;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import dynamic_programming_tasks.Counter;
import reversePolishNotation.Calculate;
import reversePolishNotation.ReversePolishNotationApp;
import simple_task.Consistency;
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
        //HuffmanCodeApp.start();


        // Обратная польская запись
        // Считает выражения с разным кол-вом операторов и операнд
        /*PostfixConverter converter = new PostfixConverter(new Scanner(System.in).nextLine());
          System.out.println("Postfix notation of current regular: " + converter.getPostfix());

          PostfixCalculator calculator = new PostfixCalculator(converter.getPostfix());
          System.out.println("Result is " + calculator.getResult());*/

        // Последовательности
        //Sequence.init();

        // Динамическое программирование
        //Counter.start(1, 29, 1, 4);

        // Подсчёт максимального количества подряд идущих элементов
        Consistency.calculate();

    }

}


