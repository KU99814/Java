//Summing the digits in an integer using recursion

import java.util.Scanner;

public class EX20_11
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//宣告輸入

   System.out.print("Enter a number: ");
   long num = input.nextLong();//輸入數字

   System.out.print("The sum of digits is "+sumDigits(num));//顯示結果
  }

 //遞迴計算位數加總
 public static int sumDigits(long n)
  {
   if(n/10==0)//base case
    return (int)(n%10);
   else //遞迴除以十後的數
    return (int)(n%10+sumDigits(n/10));
  }
}