//Synchronizing threads
//without synchronized

import java.util.concurrent.*;

public class EX29_4_NoSyn
{
 static int sum = 0;//�[�`����

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
   System.out.print("what is sum? :"+sum);
  }

 //�[�`task
 private static class NumberPlus implements Runnable
  {
   public void run()
    {
     sum++;
    }
  }
}     
   