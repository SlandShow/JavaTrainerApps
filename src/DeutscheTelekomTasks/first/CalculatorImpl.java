package DeutscheTelekomTasks.first;

import java.util.Stack;

class CalculaterImpl implements Calculator {

    private Stack<String> stack = new Stack<>();
    private String postfix = "";

    private boolean check(String[] v, int s, String input, boolean emptyBracket) {
        int stackSize = s; // Определение размера стека
        Stack<String> theStack = new Stack(); // Создание стека
        String[] a = v;
        for (int j = 0; j < input.length(); j++) // Последовательное чтение
        {
            String ch = a[j];// Чтение символа

            if (ch.equals("(")) theStack.push(ch);


            if (ch.equals(")")) {

                emptyBracket = false;

                if (theStack.size() > 0) {
                    String chx = theStack.pop();
                    if (ch.equals(")") && !chx.equals("("))
                        return false;
                    else System.out.println();
                }
            }
        }

        //если не закрывается скобка
        if (emptyBracket) return false;


        return true;
    }


    private static boolean isNumber(String element) {
        try {
            Double.parseDouble(element);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean form(String input) {
        Stack<String> s1 = new Stack<String>();
        Stack<String> s2 = new Stack<String>();
        boolean emptyBracket = false;

        String[] a = input.split("");

        String[] reserve = input.split("");

        //разбиение скобок в разные стеки
        for (int j = 0; j < input.length(); j++) {

            String ch = a[j];// Чтение символа

            if (ch.equals("(")) s1.push(ch);

            if (ch.equals(")")) {
                s2.push(ch);
                emptyBracket = false;
            }

        }

        // если не хватает n скобок
        if (s1.size() != s2.size()) return false;

        return check(reserve, reserve.length, input, emptyBracket);
    }


    @Override
    public String evaluate(String statement) {
        /*
        * 1-st step: Convert string via spaces between operators and operands
        * 2-nd step: Convert infix to postfix
        * 3-d step: Calculate postfix statement and return result
        */


        // 1-st step
        String[] tmp = convertWithSpaces(statement);
        String infix = "";
        for (String element : tmp) {
            infix += element + " ";
        }

        infix = convertInfix(infix);

        if (!form(infix) && (infix.contains("(") || infix.contains(")"))) return null;

        // 2-nd step
        postfix = getPostfix(infix);

        // 3-d step
        String result = String.valueOf(calculate(postfix));

        return result;
    }

    /*
     * Make space between operators and operands
     * For example:
     * input <- 1+20*5
     * Result of calculations: 1 + 20 * 5
     */
    private String[] convertWithSpaces(String statement) {
        return statement.replaceAll(" ", "").split("(?<=[\\-+*/=()])|(?=[()\\-+*/=])");
    }

    private String convertInfix(String old) {
        if (!String.valueOf(old.charAt(0)).equals(" ") && !String.valueOf(old.charAt(0)).equals("-")) {
            old = " " + old;
        }
        String[] array = old.split(" ");
        String tmp = "";
        int tmpIndex = 0;
        boolean start = true;
        boolean check = false;
        for (int i = 0; i < array.length; i++) {
            if ((!array[i].equals("(") || !array.equals(")")) && start) {
                tmp = array[i];
                start = false;
                tmpIndex = i;
            }

            if (!isNumber(tmp) && tmpIndex != -1 && isNumber(array[i])) {
                array[i] = tmp + array[i];
                tmp = "";
                array[tmpIndex] = "";
                tmpIndex = -1;
            }


            if (check) {
                tmp = array[i];
                if (isNumber(array[i + 1])) {
                    array[i + 1] = tmp + array[i + 1];
                    tmp = "";
                    array[i] = "";
                }
                check = false;
            }

            if (array[i].equals("("))
                check = true;
        }

        tmp = "";
        for (String element : array) {
            tmp += element + " ";
        }
        return tmp;
    }

    // Return postfix variation of infix statement
    private String getPostfix(String infix) {
        String[] elements = infix.split(" ");

        for (String element : elements) {
            if (element.equals("+") || element.equals("-"))
                gotOperator(element, 1);
            else if (element.equals("*") || element.equals("/"))
                gotOperator(element, 2);
            else if (element.equals("("))
                stack.push(element);
            else if (element.equals(")"))
                gotParen(element);
            else postfix += element + " ";
        }

        while (!stack.isEmpty())
            postfix += stack.pop() + " ";

        return postfix;
    }


    private void gotParen(String el) {
        while (!stack.isEmpty()) {
            String elx = stack.pop();
            if (elx.equals("(")) break;
            else postfix += elx + " ";
        }
    }


    private void gotOperator(String element, int priority) {
        while (!stack.isEmpty()) {
            String opTop = stack.pop();

            if (opTop.equals("(")) {
                stack.push(opTop);
                break;
            } else {
                int oldPriority = -1;

                if (opTop.equals("+") || opTop.equals("-"))
                    oldPriority = 1;
                else oldPriority = 2;

                if (oldPriority < priority) {
                    stack.push(opTop + " ");
                    break;
                } else postfix += opTop + " ";
            }
        }
        stack.push(element);
    }

    private boolean isOperator(String operator) {
        return operator.equals("+") ||
                operator.equals("-") ||
                operator.equals("*") ||
                operator.equals("/");
    }


    private Double calculate(String postfix) {
        String currentElement = "";
        String[] elements = postfix.split(" ");
        double number1, number2, interAns;

        for (int i = 0; i < elements.length; i++) {
            currentElement = elements[i];

            // Check if current element is operator
            if (isOperator(currentElement)) {
                if (stack.size() > 1 && !currentElement.equals("")) {
                    number2 = Double.parseDouble(stack.pop());
                    number1 = Double.parseDouble(stack.pop());

                    // Make calculations
                    if (currentElement.equals("+"))
                        interAns = number1 + number2;
                    else if (currentElement.equals("-"))
                        interAns = number1 - number2;
                    else if (currentElement.equals("*"))
                        interAns = number1 * number2;
                    else if (currentElement.equals("/"))
                        interAns = number1 / number2;
                    else interAns = 0;

                    stack.push(String.valueOf(interAns));
                } else return null;
            } else {
                // If current element is number
                try {
                    double element = Double.parseDouble(currentElement);
                    stack.push(String.valueOf(element));
                } catch (NumberFormatException e) {
                    //return null;
                }
            }
        }

        return Math.round(Double.parseDouble(stack.pop()) * 10000) / 10000.0000;
    }
}