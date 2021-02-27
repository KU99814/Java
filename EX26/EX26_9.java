//radix sort

import java.util.*;

public class EX26_9
{
 public static void main(String args[])
  {
   int[] list = new int[1000000];//排序用sort

   //隨機變數
   for(int i=0;i<list.length;i++)
    list[i] = (int)(Math.random()*10000000);
   
   long startTime = System.currentTimeMillis();//開始時間
   
   radixSort(list);//排序

   long endTime = System.currentTimeMillis();//結束時間
   long exTime = endTime - startTime;//執行時間

   System.out.print("exe time: "+exTime);//顯示
  }

 //radix sort
 public static void radixSort(int[] list)
  {
   ArrayList[] bucket = new ArrayList[10];//放置int的bulk

   //創建arraylist object
   for(int i=0;i<bucket.length;i++)
    bucket[i] = new ArrayList();
   
   int blukCount = 0;//放置數字的bulk數
  
   int count = 0;//位數

   //排序迴圈
   while(true)
    {
     blukCount = 0;//歸零
     int divide = (int)(Math.pow(10,count));//除數

     for(int i=0;i<list.length;i++)
      {
       int num = list[i]/divide%10;//取得位數
       bucket[num].add(list[i]);//加到相應bulk
      }
    
     int k=0;//list index
     for(int i=0;i<bucket.length;i++)
      {
       //若有bulk有放element blukCount+1
       if(bucket[i].size()>0)
        blukCount++;

       //將element按照位數0~9和arraylist內順序放入list
       for(int j=0;j<bucket[i].size();j++)
        {
         list[k] = (Integer)(bucket[i].get(j));
         k++;
        }
       bucket[i].clear();//清空
      }

     count++;//位數+1
     //若只有一個bulk有element 排序完成
     if(blukCount==1)
      break;
    }
  }
}     
           