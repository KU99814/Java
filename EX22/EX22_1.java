//Performing set operations on hash sets

import java.util.*;

public class EX22_1
{
 public static void main(String srgs[])
  {
   Set<String> set1 = new HashSet<String>();//宣告hash set

   //加入element
   set1.add("George");
   set1.add("Jim");
   set1.add("John");
   set1.add("Blake");
   set1.add("Kevin");
   set1.add("Micheal");
   
   Set<String> set2 = new HashSet<String>();//宣告第二個hash set
 
   //加入 element
   set2.add("George");
   set2.add("Katie");
   set2.add("Kevin");
   set2.add("Micheal");
   set2.add("Ryan");

   Set<String> union = new HashSet<String>();//儲存兩set聯集
   Set<String> difference = new HashSet<String>();//差集
   Set<String> intersection = new HashSet<String>();//交集

   //創造聯集
   union.addAll(set1);//先加入set1
   
   for(Object element: set2)
    {
     String e = String.valueOf(element);

     union.add(e);//因為set不會重複儲存 不須另外去除重複
     if(!set1.contains(e))//儲存差集
      difference.add(e);
     else//儲存交集
      intersection.add(e);
    }

   for(Object element: set1)//差集儲存set1
    {
     String e = String.valueOf(element);
     if(!set2.contains(e)) 
      difference.add(e);
    }

   //顯示
   System.out.println("Set1:"+set1);
   System.out.println("Set2: "+set2);
   System.out.println("union:"+union);
   System.out.println("difference:"+difference);
   System.out.println("intersection:"+intersection);
  }
}
   

   