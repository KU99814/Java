//Summing series m(i) = 1+1/2+1/3+....+1/i

import java.util.Scanner;

public class EX20_4
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//宣告輸入

   System.out.println("m(i) = 1+1/2+1/3+....+1/i");
   System.out.print("Enter i: ");
   int i = input.nextInt();//輸入i 決定要運算到哪裡

   System.out.print("m("+i+") is "+m(i));//顯示結果
  }

 //運算method
 public static double m(double i)
  {
   //直到i=1為止遞迴計算
   double num = 1/i; 
   if(i == 1)//base case
    return num;
   else
    return (double)num+m(i-1);
  }
}