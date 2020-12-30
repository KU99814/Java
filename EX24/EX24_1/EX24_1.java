//Adding set operations in MyAbstractList

import java.util.*;

public class EX24_1
{
 public static void main(String args[])
  {
   //字串陣列
   String[] l1 = {"Tom","George","Peter","Jean","Jane"};
   String[] l2 = {"Tom","George","Michael","Michelle","Daniel"};

   //測試list 加入陣列
   MyList<String> list1 = new MyArrayList<String>(l1);
   MyList<String> list2 = new MyArrayList<String>(l2);

   list1.addAll(list2);//list1加入list2的element

   System.out.println(list1.toString());//顯示

   list1.removeAll(list2);//移除list1中與list2相同內容

   System.out.println(list1.toString());//顯示

   //初始化list   
   list1 = new MyArrayList<String>(l1);
   list2 = new MyArrayList<String>(l2);

   list1.retainAll(list2);//刪去list1中list2不存在內容

   System.out.println(list1.toString());//顯示
  }
}