//Controlling threads using locks

import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class EX29_9
{
 public static void main(String args[])
  {
   //thread pool
   ExecutorService executor = Executors.newFixedThreadPool(4);
   
   //�����
   for(int i=0;i<4;i++)
    executor.execute(new PrintTwice(i+1));
   
   executor.shutdown();//����������
  }

 //task class �L�X�s���ӼƦr
 static class PrintTwice implements Runnable
  {
   private static Lock lock = new ReentrantLock();//lock
   private int num;//�L�X���Ʀr

   //constructor   
   public PrintTwice(int num)
    {
     this.num = num;
    }

   //����
   public void run()
    {
     lock.lock();//������]lock
     
     try{
      //�L�X�Ʀr
      for(int i=0;i<2;i++)
       System.out.print(num);
      System.out.println();
     }
     finally{
      lock.unlock();//������Ѱ�lock
     }
    }
  }
}