//Iimplement iterator on MyAbstractList

public class EX25_7
{
 public static void main(String args[])
  {
   MyArrayList<String> list = new MyArrayList<String>();///�ŧiarrayList

   //�[�J�r��
   list.add("Red");
   list.add("Yellow");
   list.add("Green");
   list.add("Blue");
   list.add("Pink");

   java.util.Iterator iterator = list.iterator();//�ŧiiterator

   //���
   while (iterator.hasNext())
    {
      System.out.println(iterator.next());
    }
  }
}