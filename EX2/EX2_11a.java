//Financial application: payroll
//usine dialog

import javax.swing.JOptionPane;

public class EX2_11a
{
 public static void main(String args[])
  {
   //��ܰT����ÿ�J�����T��

   //��J���q�W
   String employeeName = JOptionPane.showInputDialog(
     "Enter employee's name: ");

   //��J�u��
   String hoursWorked = JOptionPane.showInputDialog(
     "Enter number of hours worked in a week: ");
   
   double hour = Double.parseDouble(hoursWorked);//string �ରdouble
  
   //��J�Q�v
   String payRate = JOptionPane.showInputDialog(
     "Enter hourly pay rate: ");
   
   double rate = Double.parseDouble(payRate); //�ରdouble
 
   //��J�p���|
   String federalTaxS = JOptionPane.showInputDialog(
     "Enter federal tax withholding rate: ");
   
   double federalTax = Double.parseDouble(federalTaxS);//�ରdouble

   //��J�{�|
   String stateTaxS = JOptionPane.showInputDialog(
     "Enter state tax withholding rate: ");
   
   double stateTax = Double.parseDouble(stateTaxS); //�ରdouble

   double grossRate = rate*hour;//�`�O�v
   double deductionFederal = grossRate*federalTax; //�����p���|
   double deductionState = grossRate*stateTax; //�����{�|
   double totalDeduction = deductionFederal+deductionState; //�����`�B
   double netPay = grossRate-totalDeduction; //��o�~��
   
   //��X�򥻸��
   String output1 = "Employee Name: "+employeeName+
                    "\nHours worked: $"+hour+
                    "\nPay Rate: $"+rate+
                    "\nGross Rate: $"+(rate*hour);

   JOptionPane.showMessageDialog(null,output1); //�H�T�����X���G
   
   //��X�~����
   String output2 = "Deductions: "+
                    "\nFederal Withholding("+(federalTax*100)+"%): $"+deductionFederal+
                    "\nState Withholding("+(stateTax*100)+"%): $"+deductionState+
                    "\nTotal Deduction: $"+totalDeduction+
                    "\nNet Pay: $"+netPay;

   JOptionPane.showMessageDialog(null,output2); //�H�T�����X���G
  }
}
 