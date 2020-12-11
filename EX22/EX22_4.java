//Performing set operations on array lists

import java.util.*;

public class EX22_4
{
 public static void main(String args[])
  {
   //宣告list
   List<String> list1 = new ArrayList<String>();
   List<String> list2 = new ArrayList<String>();

   //輸入element
   list1.add("George");
   list1.add("Jim");
   list1.add("John");
   list1.add("Blake");
   list1.add("Kevin");
   list1.add("Michael");

   list2.add("George");
   list2.add("Katie");
   list2.add("Kevin");
   list2.add("Michelle");
   list2.add("Ryan");

   //聯集
   List<String> union = new ArrayList<String>(list1);

   //加入set2 去除與set1相同的地方
   for(int i = 0;i<list2.size();i++)
    {
     String s = list2.get(i);
     if(union.indexOf(s)<0)
      union.add(s);
    }

   //交集與差集list
   List<String> intersection = new ArrayList<String>();
   List<String> difference = new ArrayList<String>();
   
   //將set1與set2相同的加入
   for(int i = 0;i<list2.size();i++)
    {
     String s = list2.get(i);

     if(list1.indexOf(s)>=0)
      intersection.add(s);
    }

   //將set1與set2沒有交集的加入
   for(int i = 0;i<union.size();i++)
    {
     String s = union.get(i);
     if(intersection.indexOf(s)<0)
      difference.add(s);
    }

   //顯示
   System.out.println("List1: "+list1.toString());
   System.out.println("List2: "+list2.toString());
   System.out.println("Union: "+union.toString());
   System.out.println("Difference: "+difference.toString());
   System.out.println("Intersection: "+intersection.toString());
  }
}