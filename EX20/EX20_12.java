//Printing the characters in a string reversely

import java.util.Scanner;

public class EX20_12
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//宣告輸入

   System.out.print("Enter a String: ");
   String s = input.nextLine();//輸入字串

   System.out.print("The reverse string is ");
   reverseDisplay(s);//顯示顛倒字串
  }

 //以遞迴顛倒字串
 public static void reverseDisplay(String value)
  {
   reverseDisplay(value,value.length()-1);
  }

 //recursive Helper Methods
 public static void reverseDisplay(String value,int high)
  {
   if(high==0)
    System.out.print(value.charAt(high));//base case 顯示字元
   else///遞迴字串和顯示index
    {
     System.out.print(value.charAt(high));
     reverseDisplay(value,high-1);
    }
  }
}