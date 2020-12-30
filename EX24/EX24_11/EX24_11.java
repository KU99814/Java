//MyArrayList extend java.util.AbstractList

public class EX24_11
{
 public static void main(String args[])
  {
   //��J���
   String[] l1 = {"Tom","George","Peter","Jean","Jane"};
   String[] l2 = {"Tom","George","Michael","Michelle","Daniel"};

   //����list
   MyArrayList<String> list1 = new MyArrayList<String>(l1);
   MyArrayList<String> list2 = new MyArrayList<String>(l2);

   //add����
   list1.addAll(list2);
   list1.add("123");

   System.out.println(list1.toString());

   //remove����
   list1.removeAll(list2);

   System.out.println(list1.toString());

   //���m
   list1 = new MyArrayList<String>(l1);
   list2 = new MyArrayList<String>(l2);

   //retainAll ����
   list1.retainAll(list2);

   System.out.println(list1.toString());
  }
}