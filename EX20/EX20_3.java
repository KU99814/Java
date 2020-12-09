//Computing greatest common divisor using recursion

import java.util.Scanner;

public class EX20_3
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//宣告輸入

   System.out.print("Enter first number: ");
   int m = input.nextInt();//輸入第一個數

   System.out.print("Enter second number(smaller than first): ");
   int n = input.nextInt();//輸入第二個數(小於第一個)

   System.out.println("The gcd is "+gcd(m,n));//顯示GCD
  }

 //最大公因數(遞迴)
 public static int gcd(int m,int n)
  {
   if(m%n==0)//如果餘數為零 回傳N
    return n;
   else //否則繼續遞迴
    return gcd(n,m%n);
  }
}