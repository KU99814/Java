//Performing set operations on hash sets

import java.util.*;

public class EX22_1
{
 public static void main(String srgs[])
  {
   Set<String> set1 = new HashSet<String>();//�ŧihash set

   //�[�Jelement
   set1.add("George");
   set1.add("Jim");
   set1.add("John");
   set1.add("Blake");
   set1.add("Kevin");
   set1.add("Micheal");
   
   Set<String> set2 = new HashSet<String>();//�ŧi�ĤG��hash set
 
   //�[�J element
   set2.add("George");
   set2.add("Katie");
   set2.add("Kevin");
   set2.add("Micheal");
   set2.add("Ryan");

   Set<String> union = new HashSet<String>();//�x�s��set�p��
   Set<String> difference = new HashSet<String>();//�t��
   Set<String> intersection = new HashSet<String>();//�涰

   //�гy�p��
   union.addAll(set1);//���[�Jset1
   
   for(Object element: set2)
    {
     String e = String.valueOf(element);

     union.add(e);//�]��set���|�����x�s �����t�~�h������
     if(!set1.contains(e))//�x�s�t��
      difference.add(e);
     else//�x�s�涰
      intersection.add(e);
    }

   for(Object element: set1)//�t���x�sset1
    {
     String e = String.valueOf(element);
     if(!set2.contains(e)) 
      difference.add(e);
    }

   //���
   System.out.println("Set1:"+set1);
   System.out.println("Set2: "+set2);
   System.out.println("union:"+union);
   System.out.println("difference:"+difference);
   System.out.println("intersection:"+intersection);
  }
}
   

   