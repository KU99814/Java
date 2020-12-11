//Performing set operations on array lists

import java.util.*;

public class EX22_4
{
 public static void main(String args[])
  {
   //�ŧilist
   List<String> list1 = new ArrayList<String>();
   List<String> list2 = new ArrayList<String>();

   //��Jelement
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

   //�p��
   List<String> union = new ArrayList<String>(list1);

   //�[�Jset2 �h���Pset1�ۦP���a��
   for(int i = 0;i<list2.size();i++)
    {
     String s = list2.get(i);
     if(union.indexOf(s)<0)
      union.add(s);
    }

   //�涰�P�t��list
   List<String> intersection = new ArrayList<String>();
   List<String> difference = new ArrayList<String>();
   
   //�Nset1�Pset2�ۦP���[�J
   for(int i = 0;i<list2.size();i++)
    {
     String s = list2.get(i);

     if(list1.indexOf(s)>=0)
      intersection.add(s);
    }

   //�Nset1�Pset2�S���涰���[�J
   for(int i = 0;i<union.size();i++)
    {
     String s = union.get(i);
     if(intersection.indexOf(s)<0)
      difference.add(s);
    }

   //���
   System.out.println("List1: "+list1.toString());
   System.out.println("List2: "+list2.toString());
   System.out.println("Union: "+union.toString());
   System.out.println("Difference: "+difference.toString());
   System.out.println("Intersection: "+intersection.toString());
  }
}