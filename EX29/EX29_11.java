//Synchronizing threads using conditions

import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class EX29_11
{
 static int number = 4;//��X���Ʀr

 public static void main(String args[])
  {
   //thread pool
   ExecutorService executor = Executors.newFixedThreadPool(4);
   
   //�����
   for(int i=0;i<number;i++)
    executor.execute(new PrintTwice(i+1));
   
   executor.shutdown();//����������
  }

 //task class �L�X�s���ӼƦr
 static class PrintTwice implements Runnable
  {
   private static Lock lock = new ReentrantLock();//lock
   private static Condition condition = lock.newCondition();//condition

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
      //�Y��������Ʀr�p��̤j�Ʀr ����
      while(num<number)
       condition.await();
      //�L�X�Ʀr
      for(int i=0;i<2;i++)
       System.out.print(num);
      System.out.println();

      number--;//�̤j�ƴ�@
      condition.signalAll();//�I�s��L�����
     }
     catch(InterruptedException ex){}
     finally{
      lock.unlock();//������Ѱ�lock
     }
    }
  }
}