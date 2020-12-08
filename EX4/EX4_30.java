//compound value

import java.util.Scanner;

public class EX4_30
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //宣告輸入

   System.out.print("Enter the amount: ");
   double amount = input.nextDouble(); //輸入金額

   System.out.print("Enter the rate: ");
   double rate = input.nextDouble(); //輸入利率

   System.out.print("Enter the month: ");
   int month = input.nextInt(); //輸入月數
  
   double account = 0; //總金額

   //計算總金額
   for(int i = 1;i<=month;i++)
    {
     account += amount;
     account *= (1+(rate/100/12));
    }
   account = (int)(account*1000);
   account /= 1000;
   System.out.print("The saving account after the given month is "+account);
  }
}