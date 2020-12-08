//calculating the future investment value

import java.util.Scanner;

public class EX2_13
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //��J�ŧi
   
   System.out.print("Enter an investment amount: ");
   double investmentAmount = input.nextDouble(); //��J�����B EX:1000

   System.out.print("Enter the annual interest rate: ");
   double annualInterestRate = input.nextDouble(); //��J�~�Q�v EX:0.0325

   System.out.print("Enter number of years: ");
   double year = input.nextDouble(); //��J�~��

   //�p��
   double a = 1 + (annualInterestRate/12);
 
   double b = year*12;
 
   a = Math.pow(a,b);

   double futureInvestmentValue = investmentAmount*a;//�o�X���Ӫ�������

   System.out.print("The future investment value is: "+futureInvestmentValue);//��X���G
  }
}
