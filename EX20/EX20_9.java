//Printing the characters in a string reversely

import java.util.Scanner;

public class EX20_9
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//宣告輸入

   System.out.print("Enter a String: ");
   String s = input.nextLine();//輸入字串

   System.out.print("The reverse string is ");
   reverseDisplay(s);//顛倒字串顯示
  }

 //用遞迴顛倒字串
 public static void reverseDisplay(String value)
  {
   if(value.length()==1)//base case
    System.out.print(value.charAt(value.length()-1));
   else//顯示最後一個字 並遞迴除去最後一字的子字串
    {
     System.out.print(value.charAt(value.length()-1));
     reverseDisplay(value.substring(0,value.length()-1));
    }
  }
}