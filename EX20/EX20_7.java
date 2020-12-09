//Fibonacci count

import java.util.Scanner;

public class EX20_7
{
 static int count = 0;//呼叫計數
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//宣告輸入

   System.out.print("Enter an index for the Fibonacci number: ");
   int index = input.nextInt();//輸入顯示的index

   System.out.println("Fibonacci number at index "+index+" is "+fib(index));//顯示數列的數
   System.out.println("Fibonacci number has been use :"+count);//顯示method呼叫次數
  }

 public static long fib(long index)
  {
   count++;//次數+1
   if(index == 0)//base case
    return 0;
   else if(index==1)//base case
    return 1;
   else //遞迴
    return fib(index-1)+fib(index-2);
  }
}
