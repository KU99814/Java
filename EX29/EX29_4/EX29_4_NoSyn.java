//Synchronizing threads
//without synchronized

import java.util.concurrent.*;

public class EX29_4_NoSyn
{
 static int sum = 0;//加總的數

 public static void main(String args[])
  {
   ExecutorService executor = Executors.newCachedThreadPool();//thread pool
   
   //放入執行緒
   for(int i=0;i<1000;i++)
    executor.execute(new NumberPlus());
   
   executor.shutdown();//設定當所有執行緒結束時關閉executors

   //設定迴圈 當所有執行緒結束時在繼續
   while(!executor.isTerminated()){}

   //顯示加總
   System.out.print("what is sum? :"+sum);
  }

 //加總task
 private static class NumberPlus implements Runnable
  {
   public void run()
    {
     sum++;
    }
  }
}     
   