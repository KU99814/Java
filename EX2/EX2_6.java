//Summing the digits in an integers

import java.util.Scanner;

public class EX2_6
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //宣告輸入

   System.out.print("Enter a number betweem 0 and 1000:");
   int num = input.nextInt(); //輸入數字
   
   int sum = (num%10)+(num/10%10)+(num/100); //將各個位數加總
   
   System.out.print("The sum of all its digits is "+sum); //輸出結果
  }
}
