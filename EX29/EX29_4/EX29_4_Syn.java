//Synchronizing threads
//with synchronized

import java.util.concurrent.*;

public class EX29_4_Syn
{
 //��incSum�O����synchronized�P�_�O�_�P�ɦs��
 static Inc incSum = new Inc(0);//�]�t�[�`���ƪ�object

 public static void main(String args[])
  {
   ExecutorService executor = Executors.newCachedThreadPool();//thread pool
   
   //��J�����
   for(int i=0;i<1000;i++)
    executor.execute(new NumberPlus());
   
   executor.shutdown();//�]�w��Ҧ����������������executors

   //�]�w�j�� ��Ҧ�����������ɦb�~��
   while(!executor.isTerminated()){}

   //��ܥ[�`
   System.out.print("what is sum? :"+incSum.sum);
  }

 //�[�`task
 private static class NumberPlus implements Runnable
  {
   public void run()
    {
     //��synchronized�קK�P�ɦs��
     synchronized(incSum){  
       incSum.sum++;
      }
    }
  }
 
 //�]�tsum��class
 static class Inc 
  {
   int sum;//�[�`��
   
   //constructor
   public Inc(int sum)
    {
     this.sum = sum;
    }
  }
}     
   