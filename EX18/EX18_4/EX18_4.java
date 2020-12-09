//IllegalArgumentException

import java.util.Scanner;

public class EX18_4
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//宣告輸入

   System.out.print("Enter yearly interest rate, for example, 8.25: ");
   double annualInterestRate = input.nextDouble();//輸入年利率

   System.out.print("Enter number of years as an integer: ");
   int numberOfYears = input.nextInt();//輸入年數

   System.out.print("Enter loan amount, for example, 120000.95: ");
   double loanAmount = input.nextDouble();//輸入借貸金額

   Loan loan = new Loan(annualInterestRate,numberOfYears,loanAmount);//設定借貸
 
   double monthlyPayment = (int)(loan.getMonthlyPayment()*100)/100.0;//取得月利息
   double totalPayment = (int)(loan.getTotalPayment()*100)/100.0;//取得總利息

   //顯示結果
   System.out.println("The loan was created on "+loan.getLoanDate().toString() +
                      "\nThe monthly payment is "+monthlyPayment+"\nThe total payment is "+totalPayment);
  }
}   
   
   