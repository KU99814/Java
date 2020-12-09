//Summing series m(i) = 1/2+2/3+...+i/i+1

import java.util.Scanner;

public class EX20_6
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//宣告輸入

   System.out.println("m(i) = 1/2+2/3+...+i/i+1");
   System.out.print("Enter i: ");
   int i = input.nextInt();//輸入i 決定運算到哪

   System.out.print("m("+i+") is "+m(i));//顯示結果
  }

 //遞迴計算
 public static double m(double i)
  {
   //遞迴相加 直到base case
   double num = i/(i+1);
   if(i == 1)//base case
    return (double)num;
   else
    return (double)num+m(i-1);
  }
}