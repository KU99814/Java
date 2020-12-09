//Fibonacci without recursion

import java.util.Scanner;

public class EX20_2
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//宣告輸入

   System.out.print("Enter an index for the Fibonacci number: ");
   int index = input.nextInt();//輸入要顯示第幾個數

   System.out.println("Fibonacci number at index "+index+" is "+fib(index));//輸出
  }

 //以非遞迴處理費波納契數列 f(n) = f(n-1)+ f(n-2)
 public static long fib(long index)
  {
   long f0 = 0;//n=0
   long f1 = 1;//n=1

   for(int i=1;i<=index;i++)
    {
     long currentFib = f0+f1;
     f0=f1;
     f1=currentFib;
    }
   return f0;
  }
}
