//Account synchronization with object's wait and notifyAll0

import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class EX29_8
{
 private static Account account = new Account();//account����

 public static void main(String args[])
  {
   //thread pool
   ExecutorService executor = Executors.newFixedThreadPool(2);

   executor.execute(new DepositTask());//��JDepositTask
   executor.execute(new WithdrawTask());//��JWithdrawTask
   executor.shutdown();//�������������������

   System.out.println("Thread 1\t\tThread 2\t\tBalance");         
  }

 //�s��task
 public static class DepositTask implements Runnable
  {
   public void run()
    {
     try{
      while(true)
      {
       account.deposit((int)(Math.random()*10)+1);//�s���H�����B
       Thread.sleep(1000);
      }
     }
     catch(InterruptedException ex)
      {
       ex.printStackTrace();
      }
    }
  }

 //����task
 public static class WithdrawTask implements Runnable
  {
   public void run()
    {
     while(true)
      {
       account.withdraw((int)(Math.random()*10)+1);//�����H�����B
      }
    }
  }

 //account class
 private static class Account
  {
   private int balance = 0;//���B
   
   //�^�Ǫ��B
   public int getBalance()
    {
     return balance;
    }

   //�P�B
   //����
   public synchronized void withdraw(int amount)
    {
     try{
      //������B�����e����
      while(balance < amount)
       wait();

      //��h���ڪ��B      
      balance -= amount;
      //���
      System.out.println("\t\t\tWithdraw "+amount+"\t\t"+getBalance());
     }
     catch(InterruptedException ex){
      ex.printStackTrace();
     }
     finally{
      notifyAll();//�I�s��L���������
     }
    }
   
   //�P�B
   //����
   public synchronized void deposit(int amount)
    {
     try{
      balance += amount;//�[�J���B
      //���
      System.out.println("Deposit "+amount+"\t\t\t\t\t"+getBalance());
     }
     finally{
     notifyAll();
     }
    }
  }
}