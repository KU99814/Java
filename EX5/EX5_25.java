//轉換毫秒為時:分:秒

import java.util.Scanner;

public class EX5_25
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //宣告輸入
   
   System.out.print("Enter a milliseconds: "); //輸入
   long millis = input.nextLong();
   
   System.out.print("The time is "+convertMillis(millis)); //顯示
  }

 //將毫秒轉換為時分秒的method
 public static String convertMillis(long millis)
  {
   String time = null;

   int totalseconds = (int)(millis/1000); //毫秒轉換成秒

   int second = totalseconds%60; //轉換秒
   
   totalseconds/=60;
   int minute = totalseconds%60; //轉換分

   int hours = totalseconds/=60; //轉換小時
 
   time = hours+":"+minute+":"+second;

   return time;
  }
}