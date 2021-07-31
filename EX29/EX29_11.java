//Synchronizing threads using conditions

import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class EX29_11
{
 static int number = 4;//輸出的數字

 public static void main(String args[])
  {
   //thread pool
   ExecutorService executor = Executors.newFixedThreadPool(4);
   
   //執行緒
   for(int i=0;i<number;i++)
    executor.execute(new PrintTwice(i+1));
   
   executor.shutdown();//結束後關閉
  }

 //task class 印出連續兩個數字
 static class PrintTwice implements Runnable
  {
   private static Lock lock = new ReentrantLock();//lock
   private static Condition condition = lock.newCondition();//condition

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
      //若執行緒的數字小於最大數字 等待
      while(num<number)
       condition.await();
      //印出數字
      for(int i=0;i<2;i++)
       System.out.print(num);
      System.out.println();

      number--;//最大數減一
      condition.signalAll();//呼叫其他執行緒
     }
     catch(InterruptedException ex){}
     finally{
      lock.unlock();//結束後解除lock
     }
    }
  }
}