//calculating interest

import java.util.Scanner;
import javax.swing.JOptionPane;

public class EX2_12
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //�ŧi��J

   System.out.print("Enter balance: ");
   int balance = input.nextInt(); //��J�~�� EX:100000

   System.out.print("Enter annual interest rate: ");
   double annualInterestRate = input.nextDouble(); //��J�Q�v EX:4.625

   double interest = balance*(annualInterestRate/1200); //�Q���p��

   System.out.print("The interest is  "+interest); //��X���G

   //�H�T���歫�ƤW�z�ʧ@
   String balanceString = JOptionPane.showInputDialog("Enter balance: "); 
   double balanceDialog = Double.parseDouble(balanceString);

   String annualInterestRateString = JOptionPane.showInputDialog(
    "Enter annual interest rate: ");
   double annualInterestRateDialog = Double.parseDouble(annualInterestRateString);
 
   interest = balanceDialog*(annualInterestRateDialog/1200);
   JOptionPane.showMessageDialog(null,"The interest is  "+interest);
  }
} 
