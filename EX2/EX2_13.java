//calculating the future investment value

import java.util.Scanner;

public class EX2_13
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //輸入宣告
   
   System.out.print("Enter an investment amount: ");
   double investmentAmount = input.nextDouble(); //輸入投資金額 EX:1000

   System.out.print("Enter the annual interest rate: ");
   double annualInterestRate = input.nextDouble(); //輸入年利率 EX:0.0325

   System.out.print("Enter number of years: ");
   double year = input.nextDouble(); //輸入年數

   //計算
   double a = 1 + (annualInterestRate/12);
 
   double b = year*12;
 
   a = Math.pow(a,b);

   double futureInvestmentValue = investmentAmount*a;//得出未來的投資價值

   System.out.print("The future investment value is: "+futureInvestmentValue);//輸出結果
  }
}
