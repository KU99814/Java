//Compare sorting performance

import java.util.*;

public class EX22_5
{
 public static void main(String args[])
  {
   ArrayList<Integer> list1 = new ArrayList<Integer>();//宣告list

   //加入element
   for(int i = 0;i<100000;i++)
    list1.add(i);

   Collections.shuffle(list1,new Random(10000));//打亂

   //顯示各個計算時間   
   System.out.println("Time for Collection.Sort is "+getCollectionTime(list1));//Arraylist

   System.out.println("Time for Tree set is "+getTreeSetTime());//TreeSet

   System.out.println("Time for Priority Queue is "+getPriorityQueueTime());//Priority Queue
  }

 //arrayList排序發揮時間
 public static long getCollectionTime(ArrayList<Integer> l)
  {
   long starttime = System.currentTimeMillis();//開始時間
   
   Collections.sort(l);//排序
   
   long endtime = System.currentTimeMillis();//結束時間
   
   return endtime - starttime;//回傳花費時間
  }

 //Treeset花費時間
 public static long getTreeSetTime()
  {
   ArrayList<Integer> list = new ArrayList<Integer>();//宣告陣列

   for(int i = 0;i<100000;i++)//輸入element
    list.add(i);

   Collections.shuffle(list,new Random(10000));//打亂

   Collection<Integer> set = new TreeSet<Integer>();//宣告treeset

   long starttime = System.currentTimeMillis();//開始時間
   
   for(int element: list)//加入element
    set.add(element);

   for(int element: list)//移除element
    set.remove(element);
   
   long endtime = System.currentTimeMillis();//結束時間
   
   return endtime - starttime;//回傳花費時間
  }

 //PriorityQueue時間
 public static long getPriorityQueueTime()
  {
   ArrayList<Integer> list = new ArrayList<Integer>();//宣告陣列

   //加入element
   for(int i = 0;i<100000;i++)
    list.add(i);

   Collections.shuffle(list,new Random(10000));//打亂

   PriorityQueue<Integer> pq = new PriorityQueue<Integer>();//宣告PriorityQueue

   long starttime = System.currentTimeMillis();//開始時間
   
   for(int element: list)//輸入
    pq.offer(element);

   for(int element: list)//移除
    pq.remove();
   
   long endtime = System.currentTimeMillis();//結束時間
   
   return endtime - starttime;//回傳花費時間
  }
}