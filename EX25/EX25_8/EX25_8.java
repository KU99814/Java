//implementation iterator on MyLinkedList

public class EX25_8
{
 public static void main(String args[])
  {
   MyLinkedList<String> list = new MyLinkedList<String>();//linked list

   //�[�Jnode
   list.add("Red");
   list.add("Yellow");
   list.add("Green");
   list.add("Blue");
   list.add("Pink");

   java.util.Iterator iterator = list.iterator();//�ŧiiterator

   //���
   while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }
}