//The QueueOfIntergers class

import java.util.Scanner;

public class EX9_5
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J

   QueueOfIntergers q = new QueueOfIntergers(); //��C

   while(true)
    {
     int num = input.nextInt();
     if(num==-1) //��J-1���X
      break;
     else if(num == 0) //��J0 dequeue
      System.out.println(q.dequeue());
     else //��J��L�� enqueue
      q.enqueue(num);     
     q.inside();//��ܤ��e
    }
  }
}
   
//�ۧ@Queue
class QueueOfIntergers
{
 private int[] queue = new int[16];//�s��}�C
 private int size = 0;//�ثe�Ҧs��Ƽ�

 //�غc�l
 public QueueOfIntergers()
  {}

 //��J
 public void enqueue(int num)
  {
   if(size==queue.length)
    {
     int[] newQue = new int[queue.length*2+1]; //�]�s�}�C�x�s���e

     for(int i=0;i<queue.length;i++)
      newQue[i] = queue[i];

     queue = newQue;//�N�}�C���V�s�}�C
    }

   queue[size] = num; //�x�s��J��
 
   size++;   
  }

 //��X
 public int dequeue()
  {
   if(size==0) //�p�G�S�F��
    {
     System.out.println("The queue is empty");
     return -1;
    }

   int num = queue[0]; //�^�Ǽ� �Ĥ@�ӥ�

   //�N�}�C���᭱���Ʃ��e��
   for(int i=0;i<size-1;i++)
    queue[i] = queue[i+1];

   size--;//�e�q��1
   return num; //�^��
  }

 public void inside() //��ܤ��e
  {
   for(int i=0;i<size;i++)
    {
     if(queue[i]!=0)
      System.out.print(queue[i] + " ");
    }
   System.out.println();
  }  
}