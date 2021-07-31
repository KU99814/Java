//Synchronizing threads
//with synchronized

import java.util.concurrent.*;

public class EX29_4_Syn
{
 //用incSum是為讓synchronized判斷是否同時存取
 static Inc incSum = new Inc(0);//包含加總的數的object

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
   System.out.print("what is sum? :"+incSum.sum);
  }

 //加總task
 private static class NumberPlus implements Runnable
  {
   public void run()
    {
     //用synchronized避免同時存取
     synchronized(incSum){  
       incSum.sum++;
      }
    }
  }
 
 //包含sum的class
 static class Inc 
  {
   int sum;//加總數
   
   //constructor
   public Inc(int sum)
    {
     this.sum = sum;
    }
  }
}     
   