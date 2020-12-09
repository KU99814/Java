//Factorial use BigInteger and recursion

import java.util.Scanner;
import java.math.*;

public class EX20_1
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//宣告輸入

   System.out.print("Enter a nonnegative integer: ");
   int n = input.nextInt();//輸入一非負整數

   System.out.println("Factorial of "+n+" is "+factorial(n));//輸出數列
  }
 
 //以遞迴方式處理數列n!
 public static BigInteger factorial(int n)
  {
   if(n==0) //base case
    return new BigInteger("1");
   else
    {
     BigInteger m = new BigInteger(n+"");
     return m.multiply(factorial(n-1));
    }
  }
}