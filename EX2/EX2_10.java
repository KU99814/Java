//using the GUI input to find monetary units

import javax.swing.JOptionPane;

public class EX2_10
{
 public static void main(String args[])
  {
   String annualInterestRateString = JOptionPane.showInputDialog(
     "Enter an amount in double, for example 11.56: ");//顯示訊息欄 輸入amount
   
   double amount = Double.parseDouble(annualInterestRateString); //將string 轉為 double
   
   //將amount分為整數的各單位
   int remainingAmount = (int)(amount * 100);
 
   int numberOfOneDollars = remainingAmount/100;
   remainingAmount %= 100;

   int numberOfQuarters = remainingAmount / 25;
   remainingAmount %= 25;
  
   int numberOfDimes = remainingAmount/10;
   remainingAmount %= 10;

   int numberOfNickels = remainingAmount/5;
   remainingAmount %= 5;

   int numberOfPennies = remainingAmount;

   String output = "Your amount " + amount + " consists of \n" +
   "\t" + numberOfOneDollars + " dollars\n" +
   "\t" + numberOfQuarters + " quarters\n" +
   "\t" + numberOfDimes + " dimes\n" +
   "\t" + numberOfNickels + " nickels\n" + 
   "\t" + numberOfPennies + " pennies";

   JOptionPane.showMessageDialog(null,output); //以訊息欄輸出結果
  }
}

   