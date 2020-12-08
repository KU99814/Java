//finding the sales amount

import java.util.Scanner;

public class EX4_17
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //宣告輸入

   System.out.print("Enter the commission sought: ");
   double commissionSought = input.nextDouble();    //輸入佣金求購

   final double INITIAL_SALES_AMOUNT = 0.01; //初始銷售額
   double salesAmount = INITIAL_SALES_AMOUNT; //銷售額

   boolean first = true;//第一次一定要有
   //計算傭金
   for(double commission = 0;commission < commissionSought || first;)
    {
     salesAmount += 0.01;
     if(salesAmount >= 10000.01)
      commission = 5000*0.08 + 5000 *0.1 +(salesAmount - 10000)*0.12;
     else if(salesAmount >= 5000.01)
      commission = 5000*0.08 +(salesAmount - 10000)*0.10;
     else
      commission = salesAmount*0.08;

     first = false;
    }
   
   //輸出結果
   System.out.println("The sales amount $"+(int)(salesAmount * 100)/100.0
                +"\nis needed to make a commission of $"+commissionSought);
  }
}