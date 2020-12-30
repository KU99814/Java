//MyArrayList extend java.util.AbstractList

public class EX24_11
{
 public static void main(String args[])
  {
   //輸入資料
   String[] l1 = {"Tom","George","Peter","Jean","Jane"};
   String[] l2 = {"Tom","George","Michael","Michelle","Daniel"};

   //測試list
   MyArrayList<String> list1 = new MyArrayList<String>(l1);
   MyArrayList<String> list2 = new MyArrayList<String>(l2);

   //add測試
   list1.addAll(list2);
   list1.add("123");

   System.out.println(list1.toString());

   //remove測試
   list1.removeAll(list2);

   System.out.println(list1.toString());

   //重置
   list1 = new MyArrayList<String>(l1);
   list2 = new MyArrayList<String>(l2);

   //retainAll 測試
   list1.retainAll(list2);

   System.out.println(list1.toString());
  }
}