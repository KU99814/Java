//Printing the digits in an integer reversely

import java.util.Scanner;

public class EX20_8
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//宣告輸入

   System.out.print("Enter a number: ");
   int num = input.nextInt();//輸入數字

   System.out.print("The reverse number is ");
   reverseDisplay(num);//顯示顛倒數
  }

 //顯示顛倒數method
 public static void reverseDisplay(int value)
  {
   if(value/10==0)//base case
    System.out.print(value%10);
   else//顯示尾數 每次遞迴前用十除
    {
     System.out.print(value%10);
     value/=10;
     reverseDisplay(value);
    }
  }
}