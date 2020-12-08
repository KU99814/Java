//位數相加

import java.util.Scanner;

public class EX5_2
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //宣告輸入
   
   System.out.print("Enter a number: ");
   long number = input.nextLong();//輸入數字

   System.out.println("The sum of number's digital is: "+sumDigitals(number));//顯示結果
  }

 //加總method 
 public static int sumDigitals(long n)
  {
   int sum = 0;

   while(true)//運算
    {
     sum += (int)(n%10);//加最後一位
     n /= 10;//位數右移

     if(n == 0)
      break; 
    }
   return sum; //回傳
  }
}    