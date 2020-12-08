//The QueueOfIntergers class

import java.util.Scanner;

public class EX10_7
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J

   MyQueue q = new MyQueue(); //��C

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
class MyQueue extends java.util.ArrayList
{
 //�غc�l
 public MyQueue()
  {}

 //��J
 public void enqueue(Object o)
  {
   super.add(o);
  }

 //��X
 public Object dequeue()
  {
   Object o = super.get(0);
   super.remove(0);
   
   return o; //�^��
  }

 public void inside() //��ܤ��e
  {
   System.out.println(super.toString());
  }  
}