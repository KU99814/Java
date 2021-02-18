//Iimplement iterator on MyAbstractList

public class EX25_7
{
 public static void main(String args[])
  {
   MyArrayList<String> list = new MyArrayList<String>();///宣告arrayList

   //加入字串
   list.add("Red");
   list.add("Yellow");
   list.add("Green");
   list.add("Blue");
   list.add("Pink");

   java.util.Iterator iterator = list.iterator();//宣告iterator

   //顯示
   while (iterator.hasNext())
    {
      System.out.println(iterator.next());
    }
  }
}