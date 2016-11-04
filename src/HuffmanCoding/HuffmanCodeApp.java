package HuffmanCoding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;



public class HuffmanCodeApp {



  //самая главная часть структуры - основа дерева
  // Comparable нужен для того, что можно было использовать коллекции и класть туда наши объекты
  public class Node implements Comparable<Node> {

  String code = "";
  final int count; //частота элемента

  Node(int v) { count = v;  }

    @Override
    public int compareTo(Node node) {
      return Integer.compare(count,node.count);
    }


   public void setCode(String codeVal) {
     this.code = codeVal; //склеивание строк (определяем двоичное представление каждого элемента)
   }

   public String getCode() { return code; }

  }



  //элемент древа - лист
  public class Leaf extends Node {

  char symbol;

  Leaf(int v, char symVal) {
  super(v); //определяем частоту элемента в суперклассе
  symbol = symVal;
  }

  @Override
  public void setCode(String codeVal) {
  super.setCode(codeVal);
  System.out.println(symbol + " : " + code );
  }

  }


  //связка листьев (пара листьев)
  public class Couple extends Node {

  //раз это связка, то мы имеем левый и правый элемент в нашей паре
  Node left, right;

  Couple(Node first, Node second) {
  //действуем по плану алгоритма Хаффмена - суммируем частоты соседних листьев
  super(first.count + second.count);
  left = first; right = second;
  }

  @Override
  public void setCode(String codeVal) {
  super.setCode(codeVal);
  left.setCode(code + "0");
  right.setCode(code + "1");
  }

  }




   public static void start() {

   //1-ый этап: разделить строку на ее частоту и символ (например, a b b a a c -> a:3 b:2 c:1)

     BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
     System.out.println("Add line");
     String stroke = "";
     try {
       stroke = reader.readLine();
     } catch (IOException e) { e.printStackTrace(); }

     char[] array = stroke.toCharArray();


     SymbolObj[] sOb = new SymbolObj[array.length];
     for(int i = 0; i < array.length ; i++) sOb[i] = new SymbolObj(); //заполняем элементы
     ArrayList<SymbolObj> list = new ArrayList<SymbolObj>();
     for(SymbolObj el : sOb) list.add(el);

     for(int i = 0; i < array.length ; i++){
       sOb[i].setSym(array[i]);
       sOb[i].setCount(1);
     }

     //каждому элементу добовляем частоту.
     /* input <- aaabbc
     * 3 - a
       3 - a
       3 - a
       2 - b
       2 - b
       1 - c*/

     for(int i1 = 0; i1 < array.length ; i1++){
       for (int i2 = 0; i2 < array.length ; i2++){
            if(i1 != i2)
               if(sOb[i1].getSym() == sOb[i2].getSym()) sOb[i1].setCount(sOb[i1].getCount() + 1);
       }
     }



     ArrayList<SymbolObj> elements = new ArrayList<SymbolObj>();

   //если в массиве нет элемента - то добавляем его, если же он там присутствует - то нет
   for(int i = 0; i < list.size(); i++) {
       if(!ifThereIs(list.get(i),elements)) elements.add(list.get(i));
   }

  //вывод: символ и частота
  for(int i = 0; i < elements.size() ; i++) System.out.println(elements.get(i).getSym() + " : " + elements.get(i).getCount());


  //2-ой этап: Нужно построить бинарное древо с учетом частоты каждого символа
int sum = 0;
     PriorityQueue<Node> priorityQueue = new PriorityQueue<Node>();
     for(int i = 0; i < elements.size(); i++)
     priorityQueue.add(new HuffmanCodeApp().new Leaf(elements.get(i).getCount(),elements.get(i).getSym()));
     ArrayList<Node> nodeList = new ArrayList<Node>();
       while (priorityQueue.size() > 1){

         Node first = priorityQueue.poll();
         Node second = priorityQueue.poll();
         Couple coupleNode = new HuffmanCodeApp().new Couple(first, second);
         priorityQueue.add(coupleNode);
         nodeList.add(first);
         nodeList.add(second);

         sum += coupleNode.count ;

     }
     System.out.println(sum + "- sum of all elements count in a tree"); //проверка

     //3-ий этап: задаем бинарный код каждому элементу древа
     Node root = priorityQueue.poll();
     Node rootCopy = root;
     root.setCode(""); //начинаем с корня древа
     String encidedResult = "";
    for(SymbolObj e : sOb) System.out.println(e.getSym() + " " + e.getCount());




   }


  public static boolean ifThereIs(SymbolObj el, ArrayList<SymbolObj> list) {

    for(int i = 0; i < list.size(); i++) {
       if(list.get(i).getSym() == el.getSym()) return true;
    }

    return false;
  }


}
