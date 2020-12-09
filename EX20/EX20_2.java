//Fibonacci without recursion

import java.util.Scanner;

public class EX20_2
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J

   System.out.print("Enter an index for the Fibonacci number: ");
   int index = input.nextInt();//��J�n��ܲĴX�Ӽ�

   System.out.println("Fibonacci number at index "+index+" is "+fib(index));//��X
  }

 //�H�D���j�B�z�O�i�ǫ��ƦC f(n) = f(n-1)+ f(n-2)
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
