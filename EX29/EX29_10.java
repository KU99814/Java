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
   //�������
   ExecutorService executor = Executors.newFixedThreadPool(2);
   executor.execute(new Thread1());
   executor.execute(new Thread2());

   executor.shutdown();
  }

 //task1 class gj ��J�Ʀr��set�� 
 static class Thread1 implements Runnable
  {
   //constructor   
   public Thread1()
    {}

   //����
   public void run()
    {
     //�P�B��wset
     synchronized(set)
      {
       //��ܥثe������P����u�@
       System.out.print("Thread1: ");
       for(int i=0;i<10;i++)
        {
         //�[�J�Ʀr��set
         System.out.print("add "+i);
         if(i<9)
          System.out.print(", ");
         set.add(i);
        }
       System.out.println();
      }     
    }
  }

 //task2 class ���set���e
 static class Thread2 implements Runnable
  {
   //constructor   
   public Thread2()
    {}

   //����
   public void run()
    {
     synchronized(set)
      {
       Iterator iterator = set.iterator();//iterator�M�X

       //��ܥثe������P�u�@
       System.out.print("Thread2: ");
       while(iterator.hasNext())
        {
         //���set���e
         System.out.print(iterator.next()+" ");
        }
        System.out.println();
      }  
    }
  }
}