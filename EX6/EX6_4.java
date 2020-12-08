//比較陣列的數大或小於平均

import java.util.Scanner;

public class EX6_4
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //宣告輸入

   int[] score = new int[10]; //設定分數陣列 最多10個
   int i = 0; //學生數量
   double average = 0; //平均

   while(true)
    {
     System.out.print("Enter a score: "); //輸入數字
     score[i] = input.nextInt();
     average += score[i];

     if(score[i]<0) //輸入負數跳出
      break;
     i++;
     if(i==score.length) //到達陣列長度跳出
      break;
    }
   average /= (i); //平均

   int above = 0;//比平均大或等於
   int below = 0;//比平均小

   for(int j=0;j<i;j++) //比較
    {
     if(score[j] >= average)
      above++;
     else
      below++;
    }

   System.out.println("There has "+above+" scores above or equal to average"); //輸出
   System.out.println(below+" scores below to average");
  }
}   