//finding the number of days in a year

import java.util.Scanner;

public class EX3_13
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //宣告輸入

   System.out.print("Enter a year: ");
   int year = input.nextInt(); //輸入年份

   int day = 365;//預設天數
   //從年份判斷天數
   if(year%4 == 0 && year % 100 !=0 || year%400 == 0)
    {
     day++;//若為閏年天數+1
    }
   System.out.print("The days of "+year+" year are "+day);
  }
}