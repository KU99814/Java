//Using the input dialog box

import javax.swing.JOptionPane;

public class EX3_6
{
 public static void main(String args[])
  {
   //顯示訊息欄
   String year = JOptionPane.showInputDialog("Enter a year: ");
   int yearNumber = Integer.parseInt(year);//在訊息欄中輸入年數

   //判斷是否閏年
   boolean isLeapYear = (yearNumber % 4 == 0 && yearNumber % 100 != 0) || (yearNumber % 400 == 0);

   //以訊息欄輸出結果
   String result = (year + " is a leap year? "+isLeapYear);
   JOptionPane.showMessageDialog(null,result);
  }
}

   