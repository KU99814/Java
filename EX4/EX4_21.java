//comparing loans with various interestrates

import java.util.Scanner;

public class EX4_21
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //宣告輸入

   System.out.print("Enter the loan amount: ");
   double loanAmount = input.nextDouble(); //輸入借款

   System.out.print("Enter the loan period in number of years: ");
   double year = input.nextDouble(); //輸入年數

   //首兩年無利息
   year -= 2;
   if(year <=0)
    {
     year = 1;
    }

   String s = "%";

   System.out.println("Interest Rate\t\tMonthly Payment\t\tTotal Patment");
   
   //計算利息並顯示
   for(double rate = 3.5;rate <= 8;rate+=0.25)
    {
     double w = Math.pow((1+(rate/12/100)),(12*year));
     double monthlyPayment = ((rate/12/100)*loanAmount*w)/(w - 1);
     double totalPayment = monthlyPayment*12*year; 

      System.out.printf("%10.2f"+"%s"+"\t\t%10.2f\t\t\t%10.2f",rate,s,monthlyPayment,totalPayment);
      System.out.print("\n");
    }
  }
}