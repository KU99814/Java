//Sorting three integers

import javax.swing.JOptionPane;

public class EX3_8
{
 public static void main(String args[])
  {
   //�H�T�����J�T�ӼƦr
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
   
   //��j�p�ñƧ�
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
   
   //��X���G
   String output = "The sort is "+num1+" "+num2+" "+num3;

   JOptionPane.showMessageDialog(null,output);
  }
}