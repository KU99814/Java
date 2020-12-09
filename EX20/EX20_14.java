//Finding the number of uppercase letter in a string

import java.util.Scanner;

public class EX20_14
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//宣告輸入

   System.out.print("Enter a string: ");
   String s = input.nextLine();//輸入字串

   System.out.print("The uppercase number of string is: " + numberOfUpp(s));//顯示結果
  }

 //遞迴找出大寫數量
 public static int numberOfUpp(String s)
  {
   return numberOfUpp(s,s.length()-1,0);
  }

 //recursive helper method
 public static int numberOfUpp(String s,int high,int count)
  {
   if(Character.isUpperCase(s.charAt(high)))
    count++;
   if(high==0)
    return count;
   else//遞迴從最後到最初
    return numberOfUpp(s,high-1,count);
  }
}