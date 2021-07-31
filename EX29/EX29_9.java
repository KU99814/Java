//Controlling threads using locks

import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class EX29_9
{
 public static void main(String args[])
  {
   //thread pool
   ExecutorService executor = Executors.newFixedThreadPool(4);
   
   //執行緒
   for(int i=0;i<4;i++)
    executor.execute(new PrintTwice(i+1));
   
   executor.shutdown();//結束後關閉
  }

 //task class 印出連續兩個數字
 static class PrintTwice implements Runnable
  {
   private static Lock lock = new ReentrantLock();//lock
   private int num;//印出的數字

   //constructor   
   public PrintTwice(int num)
    {
     this.num = num;
    }

   //執行
   public void run()
    {
     lock.lock();//執行緒設lock
     
     try{
      //印出數字
      for(int i=0;i<2;i++)
       System.out.print(num);
      System.out.println();
     }
     finally{
      lock.unlock();//結束後解除lock
     }
    }
  }
}