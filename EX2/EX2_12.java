//calculating interest

import java.util.Scanner;
import javax.swing.JOptionPane;

public class EX2_12
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //宣告輸入

   System.out.print("Enter balance: ");
   int balance = input.nextInt(); //輸入薪資 EX:100000

   System.out.print("Enter annual interest rate: ");
   double annualInterestRate = input.nextDouble(); //輸入利率 EX:4.625

   double interest = balance*(annualInterestRate/1200); //利息計算

   System.out.print("The interest is  "+interest); //輸出結果

   //以訊息欄重複上述動作
   String balanceString = JOptionPane.showInputDialog("Enter balance: "); 
   double balanceDialog = Double.parseDouble(balanceString);

   String annualInterestRateString = JOptionPane.showInputDialog(
    "Enter annual interest rate: ");
   double annualInterestRateDialog = Double.parseDouble(annualInterestRateString);
 
   interest = balanceDialog*(annualInterestRateDialog/1200);
   JOptionPane.showMessageDialog(null,"The interest is  "+interest);
  }
} 
