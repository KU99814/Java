//Account synchronization with object's wait and notifyAll0

import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class EX29_8
{
 private static Account account = new Account();//account物件

 public static void main(String args[])
  {
   //thread pool
   ExecutorService executor = Executors.newFixedThreadPool(2);

   executor.execute(new DepositTask());//放入DepositTask
   executor.execute(new WithdrawTask());//放入WithdrawTask
   executor.shutdown();//全部執行緒結束後關閉

   System.out.println("Thread 1\t\tThread 2\t\tBalance");         
  }

 //存款task
 public static class DepositTask implements Runnable
  {
   public void run()
    {
     try{
      while(true)
      {
       account.deposit((int)(Math.random()*10)+1);//存款隨機金額
       Thread.sleep(1000);
      }
     }
     catch(InterruptedException ex)
      {
       ex.printStackTrace();
      }
    }
  }

 //提款task
 public static class WithdrawTask implements Runnable
  {
   public void run()
    {
     while(true)
      {
       account.withdraw((int)(Math.random()*10)+1);//提款隨機金額
      }
    }
  }

 //account class
 private static class Account
  {
   private int balance = 0;//金額
   
   //回傳金額
   public int getBalance()
    {
     return balance;
    }

   //同步
   //提款
   public synchronized void withdraw(int amount)
    {
     try{
      //直到金額足夠前等待
      while(balance < amount)
       wait();

      //減去提款金額      
      balance -= amount;
      //顯示
      System.out.println("\t\t\tWithdraw "+amount+"\t\t"+getBalance());
     }
     catch(InterruptedException ex){
      ex.printStackTrace();
     }
     finally{
      notifyAll();//呼叫其他執行緒執行
     }
    }
   
   //同步
   //提款
   public synchronized void deposit(int amount)
    {
     try{
      balance += amount;//加入金額
      //顯示
      System.out.println("Deposit "+amount+"\t\t\t\t\t"+getBalance());
     }
     finally{
     notifyAll();
     }
    }
  }
}