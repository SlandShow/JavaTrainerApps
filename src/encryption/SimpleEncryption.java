package encryption;


import java.util.Scanner;

public class SimpleEncryption {

    /*Необходимо написать алгоритм, который позволяет кодировать сообщение следующим образом:
* В каждой строке ищутся отдельные слова, и все символы сдвигаются по алфавиту циклически впрал га длину слова.
*
* Словом считается любая последовательность подряд идущих символов латинского алфавита.
*
* Пример:
* Input: Day, mice. Year - a mistake.
* Output: Gdb, qmgi. Ciev - b tpzahrl.
* */


    static String decodeMessage = "";
    static char[] decM;

    public static void start() {
        Scanner in = new Scanner(System.in);
        String message = in.nextLine();
        String word = "";
        char el = ' ';
        int currentElement = 0;
        int tmp_position = 0;

        decM = new char[message.length()];

        for (int i = 0; i < message.length(); i++) {

            for (int j = currentElement; j < message.length(); j++) {
                currentElement++;
                char tmp = message.charAt(j);
                if (tmp != ',' && tmp != '-' && tmp != ' ' && tmp != '(' && tmp != ')' && tmp != '.') {
                    word += tmp;

                } else {
                    decodeMessage += decode(word);
                    decodeMessage += tmp;
                    break;
                }
            }

            word = "";
        }

        System.out.println(decodeMessage.toString());
    }


    public static String decode(String val) {
        String newString = "";
        char element = ' ';
        for (int i = 0; i < val.length(); i++) {
            element = val.charAt(i);
            newString += (char) (element + val.length());
        }

        return newString;
    }


}
