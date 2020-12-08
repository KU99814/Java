//Financial application: payroll

import java.util.Scanner;

public class EX2_11b
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //�ŧi��J
   
   System.out.print("Enter employee's name: ");
   String name = input.next(); //��J�m�W

   System.out.print("Enter number of hours worked in a week: ");
   double hour = input.nextDouble(); //��J�u��
  
   System.out.print("Enter hourly pay rate: ");
   double rate = input.nextDouble(); //��J�Q�v

   System.out.print("Enter federal tax withholding rate: ");
   double federalTax = input.nextDouble(); //��J�p���|

   System.out.print("Enter state tax withholding rate: ");
   double stateTax = input.nextDouble(); //��J�{�|

   double grossRate = rate*hour;//�`�O�v
   double deductionFederal = grossRate*federalTax; //�����p���|
   double deductionState = grossRate*stateTax; //�����{�|
   double totalDeduction = deductionFederal+deductionState; //�����`�B
   double netPay = grossRate-totalDeduction; //��o�~��
   
   //��X�򥻸��
   System.out.print("Employee Name: "+name);
   System.out.println("Hours worked: $"+hour);
   System.out.println("Pay Rate: $"+rate);
   System.out.println("Gross Rate: $"+(rate*hour));
   
   //��X�~����
   System.out.println("Deductions: ");
   System.out.println("\tFederal Withholding("+(federalTax*100)+"%): $"+deductionFederal);
   System.out.println("\tState Withholding("+(stateTax*100)+"%): $"+deductionState);
   System.out.println("\tTotal Deduction: $"+totalDeduction);
   System.out.println("Net Pay: $"+netPay);
  }
}
 