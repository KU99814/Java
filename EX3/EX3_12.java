//Check a number divisible by 5 or 6

import java.util.Scanner;

public class EX3_12
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//宣告輸入
  
   System.out.print("Enter the number to divisible: ");
   int number = input.nextInt(); //輸入數字

   boolean isOr = (number%5==0 || number%6 == 0 );//是否被任一整除
   boolean isAnd = (number%5==0 && number%6 == 0 ); //是否被同時整除

   //判斷被5和6整除得情況
   if(isOr)
    {
     if(isAnd)//同時整除情況
      {
       System.out.print(number + " divisible by 5 and 6");
      }
     else //非同時
      {
       System.out.print(number + " divisible by 5 or 6,but not both");
      }
    }
   else //不被任一整除
    System.out.print(number + " not divisible by either 5 or 6");
  }
}