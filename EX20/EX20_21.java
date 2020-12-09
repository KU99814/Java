//Decimal to binary

import java.util.Scanner;

public class EX20_21
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//宣告輸入

   System.out.print("Enter a Decimal number: ");
   int num = input.nextInt();//輸入數字

   System.out.print("The Binary number is "+convertDecimalToBinary(num));//轉為二進位
  }

 //遞迴轉為二進位
 public static String convertDecimalToBinary(int value)
  {
   if(value<2)//base case
    return value+"";
   else//遞迴 遞迴方法放前
    {
     return convertDecimalToBinary(value/2) + value%2;
    }
  }
}