//Displaying nonduplicate words in ascending order
//�����:java EX22_2 sourceFile 

import java.util.*;
import java.io.*;

public class EX22_2
{
 public static void main(String args[]) throws Exception
  {
   File file = new File(args[0]); //�ŧi�ɮ�
  
   Set<String> set1 = new TreeSet<String>();//�ŧitree set �|���j�p�۰ʱƧ�

   Scanner input = new Scanner(file);//�ŧi��J

   while(input.hasNext())//�q�ɮ׿�J
    {
     set1.add(input.next());
    }

   System.out.print(set1);//���

   input.close();//�����ɮ�
  }
}
   

   