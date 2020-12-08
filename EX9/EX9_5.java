//The QueueOfIntergers class

import java.util.Scanner;

public class EX9_5
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//宣告輸入

   QueueOfIntergers q = new QueueOfIntergers(); //佇列

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
class QueueOfIntergers
{
 private int[] queue = new int[16];//存放陣列
 private int size = 0;//目前所存資料數

 //建構子
 public QueueOfIntergers()
  {}

 //放入
 public void enqueue(int num)
  {
   if(size==queue.length)
    {
     int[] newQue = new int[queue.length*2+1]; //設新陣列儲存內容

     for(int i=0;i<queue.length;i++)
      newQue[i] = queue[i];

     queue = newQue;//將陣列指向新陣列
    }

   queue[size] = num; //儲存輸入值
 
   size++;   
  }

 //放出
 public int dequeue()
  {
   if(size==0) //如果沒東西
    {
     System.out.println("The queue is empty");
     return -1;
    }

   int num = queue[0]; //回傳數 第一個先

   //將陣列中後面的數往前推
   for(int i=0;i<size-1;i++)
    queue[i] = queue[i+1];

   size--;//容量減1
   return num; //回傳
  }

 public void inside() //顯示內容
  {
   for(int i=0;i<size;i++)
    {
     if(queue[i]!=0)
      System.out.print(queue[i] + " ");
    }
   System.out.println();
  }  
}