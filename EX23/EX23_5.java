//Bogosort

import java.util.Random;

public class EX23_5
{
 static Random random = new Random();//隨機
 public static void main(String args[])
  {
   long[] count = new long[10];//list排序次數
   int[] num = new int[10];//同長度list出現次數

   for(int i=0;i<10;i++)
    {
     count[i]=0;
     num[i] = 0;
    }

   //測試25次
   for(int i=0;i<25;i++)
    {
     int length = random.nextInt(10)+1;//隨機list長度

     int[] a = new int[length];//測試陣列

     for(int j=0;j<length;j++)
      a[j] = random.nextInt(100)+1;//加入隨機數

     count[length-1] += bogosort(a);//排序
     num[length - 1]++;//出現+1次
    }

   //顯示到排序成功為止的平均數
   for(int i=0;i<10;i++)
    {
     if(count[i]!=0)
      System.out.println((i+1)+"'s average is "+(count[i]/num[i]));
    }
  }

 //bogosort
 public static long bogosort(int[] n)
  {
   long c = 0;//回傳的排序次數

   while(!inOrder(n))//迴圈直到排序完
    {
     for (int i = 0; i < n.length; i++)
      {
       int swapPosition = random.nextInt(i + 1);//隨機決定index
       //跟目前index交換
       int temp = n[i];
       n[i] = n[swapPosition];
       n[swapPosition] = temp;
      }
     c++;//次數加1
    }
   
   return c;//回傳
  }

 //檢查是否排序
 public static boolean inOrder(int[] n)
  {
   for (int i = 0; i < n.length-1; i++)
    {
     if (n[i] > n[i+1])
      return false;
    }
   return true;
  }
}