//IllegalArgumentException

import java.util.Scanner;

public class EX18_4
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J

   System.out.print("Enter yearly interest rate, for example, 8.25: ");
   double annualInterestRate = input.nextDouble();//��J�~�Q�v

   System.out.print("Enter number of years as an integer: ");
   int numberOfYears = input.nextInt();//��J�~��

   System.out.print("Enter loan amount, for example, 120000.95: ");
   double loanAmount = input.nextDouble();//��J�ɶU���B

   Loan loan = new Loan(annualInterestRate,numberOfYears,loanAmount);//�]�w�ɶU
 
   double monthlyPayment = (int)(loan.getMonthlyPayment()*100)/100.0;//���o��Q��
   double totalPayment = (int)(loan.getTotalPayment()*100)/100.0;//���o�`�Q��

   //��ܵ��G
   System.out.println("The loan was created on "+loan.getLoanDate().toString() +
                      "\nThe monthly payment is "+monthlyPayment+"\nThe total payment is "+totalPayment);
  }
}   
   
   