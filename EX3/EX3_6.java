//Using the input dialog box

import javax.swing.JOptionPane;

public class EX3_6
{
 public static void main(String args[])
  {
   //��ܰT����
   String year = JOptionPane.showInputDialog("Enter a year: ");
   int yearNumber = Integer.parseInt(year);//�b�T���椤��J�~��

   //�P�_�O�_�|�~
   boolean isLeapYear = (yearNumber % 4 == 0 && yearNumber % 100 != 0) || (yearNumber % 400 == 0);

   //�H�T�����X���G
   String result = (year + " is a leap year? "+isLeapYear);
   JOptionPane.showMessageDialog(null,result);
  }
}

   