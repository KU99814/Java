//Factorial use BigInteger and recursion

import java.util.Scanner;
import java.math.*;

public class EX20_1
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J

   System.out.print("Enter a nonnegative integer: ");
   int n = input.nextInt();//��J�@�D�t���

   System.out.println("Factorial of "+n+" is "+factorial(n));//��X�ƦC
  }
 
 //�H���j�覡�B�z�ƦCn!
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