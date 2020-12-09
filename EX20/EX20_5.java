//Summing series m(i) = 1/3+2/5+3/7+4/9+5/11+6/13....+i/2i+1

import java.util.Scanner;

public class EX20_5
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//宣告輸入

   System.out.println("m(i) = 1/3+2/5+3/7+4/9+5/11+6/13....+i/2i+1");
   System.out.print("Enter i: ");
   int i = input.nextInt();//輸入i 決定計算到哪

   System.out.print("m("+i+") is "+m(i));//顯示結果
  }

 //遞迴計算
 public static double m(double i)
  {
   //遞迴直到base case
   double num = i/(2*i+1);
   if(i == 1)//base case
    return (double)num;
   else
    return (double)num+m(i-1);
  }
}