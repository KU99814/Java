//Fibonacci count

import java.util.Scanner;

public class EX20_7
{
 static int count = 0;//�I�s�p��
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J

   System.out.print("Enter an index for the Fibonacci number: ");
   int index = input.nextInt();//��J��ܪ�index

   System.out.println("Fibonacci number at index "+index+" is "+fib(index));//��ܼƦC����
   System.out.println("Fibonacci number has been use :"+count);//���method�I�s����
  }

 public static long fib(long index)
  {
   count++;//����+1
   if(index == 0)//base case
    return 0;
   else if(index==1)//base case
    return 1;
   else //���j
    return fib(index-1)+fib(index-2);
  }
}
