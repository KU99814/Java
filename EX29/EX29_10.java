//Using synchronized sets

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class EX29_10
{
 //synchronize set
 static Set<Integer> set = Collections.synchronizedSet(new HashSet<Integer>());

 public static void main(String args[])
  {
   //執行緒池
   ExecutorService executor = Executors.newFixedThreadPool(2);
   executor.execute(new Thread1());
   executor.execute(new Thread2());

   executor.shutdown();
  }

 //task1 class gj 輸入數字到set中 
 static class Thread1 implements Runnable
  {
   //constructor   
   public Thread1()
    {}

   //執行
   public void run()
    {
     //同步鎖定set
     synchronized(set)
      {
       //顯示目前執行緒與執行工作
       System.out.print("Thread1: ");
       for(int i=0;i<10;i++)
        {
         //加入數字到set
         System.out.print("add "+i);
         if(i<9)
          System.out.print(", ");
         set.add(i);
        }
       System.out.println();
      }     
    }
  }

 //task2 class 顯示set內容
 static class Thread2 implements Runnable
  {
   //constructor   
   public Thread2()
    {}

   //執行
   public void run()
    {
     synchronized(set)
      {
       Iterator iterator = set.iterator();//iterator尋訪

       //顯示目前執行緒與工作
       System.out.print("Thread2: ");
       while(iterator.hasNext())
        {
         //顯示set內容
         System.out.print(iterator.next()+" ");
        }
        System.out.println();
      }  
    }
  }
}