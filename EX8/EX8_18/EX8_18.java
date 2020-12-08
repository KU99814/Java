//processing scores in a text file

import java.util.Scanner;

public class EX8_18
{
 public static void main(String args[]) throws Exception
  {
   java.io.File file = new java.io.File(args[0]); //在cmd輸入檔名

   Scanner input = new Scanner(file); //宣告輸入
  
   int total = 0; //總分
   int count = 0; //計算個數

   while(input.hasNext())//從檔案輸出
    {
     int num = input.nextInt();

     total += num;
     count++;
    }     
   
   double average;
   if(count>0)
    average = total/count;//平均
   else
    average = 0;
   
   System.out.println("The total score is "+total);
   System.out.print("The average is "+average);
  }
}