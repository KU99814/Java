//loan amortization schedule

import java.util.Scanner;

public class EX4_22
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //�ŧi��J

   System.out.print("Loan Amount: ");
   double loanAmount = input.nextDouble(); //��J�ɪ�
  
   System.out.print("Number of Years: ");
   int year = input.nextInt(); //��J�~��

   System.out.print("Annual Interest Rate: ");
   double rate = input.nextDouble(); //��J�Q�v

   double w = Math.pow((1+(rate/12/100)),(12*year)); //����ƼW�[���Q�v
   double month = ((rate/12/100)*loanAmount*w)/(w - 1); //�H�Q�v�p��C���`�B
   double total = month*12*year; //�`���

   System.out.println("Monthly Payment: "+month);//��ܤ��~
   System.out.println("Total Payment: "+total); //����`�~

   System.out.println("Payment#\tInterest\tPrincipal\tBalance\n"); //������

   double monthlyInterestRate = rate/12; 

   double balance = loanAmount;

   //�p��
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