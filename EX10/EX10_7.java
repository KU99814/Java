//The QueueOfIntergers class

import java.util.Scanner;

public class EX10_7
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//宣告輸入

   MyQueue q = new MyQueue(); //佇列

   while(true)
    {
     int num = input.nextInt();
     if(num==-1) //輸入-1跳出
      break;
     else if(num == 0) //輸入0 dequeue
      System.out.println(q.dequeue());
     else //輸入其他數 enqueue
      q.enqueue(num);     
     q.inside();//顯示內容
    }
  }
}
   
//自作Queue
class MyQueue extends java.util.ArrayList
{
 //建構子
 public MyQueue()
  {}

 //放入
 public void enqueue(Object o)
  {
   super.add(o);
  }

 //放出
 public Object dequeue()
  {
   Object o = super.get(0);
   super.remove(0);
   
   return o; //回傳
  }

 public void inside() //顯示內容
  {
   System.out.println(super.toString());
  }  
}