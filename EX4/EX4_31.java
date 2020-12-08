//computing CD value

import java.util.Scanner;

public class EX4_31
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //宣告輸入
   
   System.out.print("Enter an amount into CD every month: ");
   double amount = input.nextDouble(); //輸入金額

   System.out.print("Enter the annual percentage yield: ");
   double rate = input.nextDouble(); //輸入利率

   System.out.print("Enter the number of months: ");
   int month = input.nextInt(); //輸入月份

   System.out.println("Month\t\t\tCD Value");

   double value = amount;
  
   //顯示每月金額
   for(int i = 1;i<=month;i++)
    {
     value +=  value*(rate/1200);
    
     System.out.printf("%d\t\t\t%.2f\n",i,value);
     
    }
  }
}