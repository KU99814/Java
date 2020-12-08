//輸入年份和月份算出天數

import java.util.Scanner;

public class EX5_7
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//宣告輸入
   
   System.out.print("Enter the month: ");//輸入月份
   int month = input.nextInt();

   System.out.print("Enter the year: ");//輸入年份
   int year = input.nextInt();

   //顯示該月天數
   System.out.print("The days of the month are: "+getNumberOfDays(month,year));
  }

 //顯示天數的method
 public static int getNumberOfDays(int month,int year)
  {
   boolean Leapyear = (year %4 == 0 && year % 100 != 0) || (year % 400 == 0); //判斷是否閏年

   if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 ||
      month == 10 || month == 12) //如果是1 3 5 7 8 10 12月份 回傳31
    return 31;
   else if(month == 2)    //如果是二月 判斷是否閏年 回傳28或29
    {
     if(Leapyear)
      return 29;
     else
      return 28;
    }
   else   //其他月份回傳30
    return 30;
  }
}