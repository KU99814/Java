//counting the occurences of numbers entered

import java.util.*;

public class EX22_7
{
 public static void main(String args[])
  {
   Map<Integer,Integer> m = new HashMap<Integer,Integer>(); //創map<K,V>

   Scanner input = new Scanner(System.in);//宣告輸入

   System.out.print("Enter number, 0 is exit: "); //輸入數字

   while(true)
    {  
     int num = input.nextInt();

     if(num ==0) //輸入0跳出
      break;

     //儲存&計數
     else if(m.containsKey(num))
      {
       int v = m.get(num).intValue();
       m.put(num,v+1);
      }
     else
      m.put(num,1);
    } 
   System.out.print("The max occurence number is ");//顯示

   Set<Map.Entry<Integer,Integer>> entrySet = m.entrySet();

   //找最多次
   int max = 0;
   for(Map.Entry<Integer,Integer> entry: entrySet)
    {
     if(entry.getValue()>max)
      max = entry.getValue();
    }
     
   //顯示
   for(Map.Entry<Integer,Integer> entry: entrySet)
    {
     if(entry.getValue()==max)
      System.out.print(entry.getKey()+" ");
    }
   System.out.println();  
  }
}
     