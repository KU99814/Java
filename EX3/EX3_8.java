//Sorting three integers

import javax.swing.JOptionPane;

public class EX3_8
{
 public static void main(String args[])
  {
   //以訊息欄輸入三個數字
   String message1 = JOptionPane.showInputDialog(
             "Enter the first number: ");
   int num1 = Integer.parseInt(message1);

   String message2 = JOptionPane.showInputDialog(
             "Enter the second number: ");
   int num2 = Integer.parseInt(message2);

   String message3 = JOptionPane.showInputDialog(
             "Enter the third number: ");
   int num3 = Integer.parseInt(message3);
   
   int temp;
   
   //比大小並排序
   if(num1 >num2)
    {
     temp = num1;
     num1 = num2;
     num2 = temp;
    }
   
   if(num2 > num3)
    {
     temp = num2;
     num2 = num3;
     num3 = temp;

   if(num1 > num2)
    {
     temp = num1;
     num1 = num2;
     num2 = temp;
    }
   }
   
   //輸出結果
   String output = "The sort is "+num1+" "+num2+" "+num3;

   JOptionPane.showMessageDialog(null,output);
  }
}