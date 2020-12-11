//counting the occurences of numbers entered

import java.util.*;

public class EX22_7
{
 public static void main(String args[])
  {
   Map<Integer,Integer> m = new HashMap<Integer,Integer>(); //��map<K,V>

   Scanner input = new Scanner(System.in);//�ŧi��J

   System.out.print("Enter number, 0 is exit: "); //��J�Ʀr

   while(true)
    {  
     int num = input.nextInt();

     if(num ==0) //��J0���X
      break;

     //�x�s&�p��
     else if(m.containsKey(num))
      {
       int v = m.get(num).intValue();
       m.put(num,v+1);
      }
     else
      m.put(num,1);
    } 
   System.out.print("The max occurence number is ");//���

   Set<Map.Entry<Integer,Integer>> entrySet = m.entrySet();

   //��̦h��
   int max = 0;
   for(Map.Entry<Integer,Integer> entry: entrySet)
    {
     if(entry.getValue()>max)
      max = entry.getValue();
    }
     
   //���
   for(Map.Entry<Integer,Integer> entry: entrySet)
    {
     if(entry.getValue()==max)
      System.out.print(entry.getKey()+" ");
    }
   System.out.println();  
  }
}
     