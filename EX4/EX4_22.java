//loan amortization schedule

import java.util.Scanner;

public class EX4_22
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //宣告輸入

   System.out.print("Loan Amount: ");
   double loanAmount = input.nextDouble(); //輸入借金
  
   System.out.print("Number of Years: ");
   int year = input.nextInt(); //輸入年數

   System.out.print("Annual Interest Rate: ");
   double rate = input.nextDouble(); //輸入利率

   double w = Math.pow((1+(rate/12/100)),(12*year)); //按月數增加的利率
   double month = ((rate/12/100)*loanAmount*w)/(w - 1); //以利率計算每月總額
   double total = month*12*year; //總月數

   System.out.println("Monthly Payment: "+month);//顯示月薪
   System.out.println("Total Payment: "+total); //顯示總薪

   System.out.println("Payment#\tInterest\tPrincipal\tBalance\n"); //顯示欄位

   double monthlyInterestRate = rate/12; 

   double balance = loanAmount;

   //計算
   for(int pay = 1;pay <= year*12;pay++)
    {
     double Interest = (monthlyInterestRate*balance*100)/100/100;
     balance -= (month-Interest);
     double principal = (month-Interest);


     System.out.printf("%d\t\t%.2f\t\t%.2f\t\t%.2f",pay,Interest,principal,balance);
     System.out.println();
    }
  }
}