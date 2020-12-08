//Financial application: payroll
//usine dialog

import javax.swing.JOptionPane;

public class EX2_11a
{
 public static void main(String args[])
  {
   //顯示訊息欄並輸入相關訊息

   //輸入公司名
   String employeeName = JOptionPane.showInputDialog(
     "Enter employee's name: ");

   //輸入工時
   String hoursWorked = JOptionPane.showInputDialog(
     "Enter number of hours worked in a week: ");
   
   double hour = Double.parseDouble(hoursWorked);//string 轉為double
  
   //輸入利率
   String payRate = JOptionPane.showInputDialog(
     "Enter hourly pay rate: ");
   
   double rate = Double.parseDouble(payRate); //轉為double
 
   //輸入聯邦稅
   String federalTaxS = JOptionPane.showInputDialog(
     "Enter federal tax withholding rate: ");
   
   double federalTax = Double.parseDouble(federalTaxS);//轉為double

   //輸入州稅
   String stateTaxS = JOptionPane.showInputDialog(
     "Enter state tax withholding rate: ");
   
   double stateTax = Double.parseDouble(stateTaxS); //轉為double

   double grossRate = rate*hour;//總費率
   double deductionFederal = grossRate*federalTax; //扣除聯邦稅
   double deductionState = grossRate*stateTax; //扣除州稅
   double totalDeduction = deductionFederal+deductionState; //扣除總額
   double netPay = grossRate-totalDeduction; //實得薪水
   
   //輸出基本資料
   String output1 = "Employee Name: "+employeeName+
                    "\nHours worked: $"+hour+
                    "\nPay Rate: $"+rate+
                    "\nGross Rate: $"+(rate*hour);

   JOptionPane.showMessageDialog(null,output1); //以訊息欄輸出結果
   
   //輸出薪資資料
   String output2 = "Deductions: "+
                    "\nFederal Withholding("+(federalTax*100)+"%): $"+deductionFederal+
                    "\nState Withholding("+(stateTax*100)+"%): $"+deductionState+
                    "\nTotal Deduction: $"+totalDeduction+
                    "\nNet Pay: $"+netPay;

   JOptionPane.showMessageDialog(null,output2); //以訊息欄輸出結果
  }
}
 