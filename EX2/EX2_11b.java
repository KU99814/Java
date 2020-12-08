//Financial application: payroll

import java.util.Scanner;

public class EX2_11b
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //宣告輸入
   
   System.out.print("Enter employee's name: ");
   String name = input.next(); //輸入姓名

   System.out.print("Enter number of hours worked in a week: ");
   double hour = input.nextDouble(); //輸入工時
  
   System.out.print("Enter hourly pay rate: ");
   double rate = input.nextDouble(); //輸入利率

   System.out.print("Enter federal tax withholding rate: ");
   double federalTax = input.nextDouble(); //輸入聯邦稅

   System.out.print("Enter state tax withholding rate: ");
   double stateTax = input.nextDouble(); //輸入州稅

   double grossRate = rate*hour;//總費率
   double deductionFederal = grossRate*federalTax; //扣除聯邦稅
   double deductionState = grossRate*stateTax; //扣除州稅
   double totalDeduction = deductionFederal+deductionState; //扣除總額
   double netPay = grossRate-totalDeduction; //實得薪水
   
   //輸出基本資料
   System.out.print("Employee Name: "+name);
   System.out.println("Hours worked: $"+hour);
   System.out.println("Pay Rate: $"+rate);
   System.out.println("Gross Rate: $"+(rate*hour));
   
   //輸出薪資資料
   System.out.println("Deductions: ");
   System.out.println("\tFederal Withholding("+(federalTax*100)+"%): $"+deductionFederal);
   System.out.println("\tState Withholding("+(stateTax*100)+"%): $"+deductionState);
   System.out.println("\tTotal Deduction: $"+totalDeduction);
   System.out.println("Net Pay: $"+netPay);
  }
}
 