//Adding set operations in MyAbstractList

import java.util.*;

public class EX24_1
{
 public static void main(String args[])
  {
   //�r��}�C
   String[] l1 = {"Tom","George","Peter","Jean","Jane"};
   String[] l2 = {"Tom","George","Michael","Michelle","Daniel"};

   //����list �[�J�}�C
   MyList<String> list1 = new MyArrayList<String>(l1);
   MyList<String> list2 = new MyArrayList<String>(l2);

   list1.addAll(list2);//list1�[�Jlist2��element

   System.out.println(list1.toString());//���

   list1.removeAll(list2);//����list1���Plist2�ۦP���e

   System.out.println(list1.toString());//���

   //��l��list   
   list1 = new MyArrayList<String>(l1);
   list2 = new MyArrayList<String>(l2);

   list1.retainAll(list2);//�R�hlist1��list2���s�b���e

   System.out.println(list1.toString());//���
  }
}