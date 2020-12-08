//Computing the greatest common divisor

import java.util.Scanner;

public class EX4_15
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //宣告輸入
  
   System.out.print("Enter first integer: ");
   int n1 = input.nextInt(); //輸入第一個數
   System.out.print("Enter second integer: ");
   int n2 = input.nextInt(); //輸入第二個數
   
   int min = 0;

   //找出兩數中小的
   if(n1 > n2)
    {
     min = n2;
    }
   else
    {
     min = n1;
    }

   //以迴圈慢慢減小直到能同時整除兩數
   while(true)
    {
     if(n2 % min == 0 && n1 % min == 0)
      {
       break;
      }
     min--;
    }

   //輸出結果
   System.out.println("The greatest common divisor for "+ n1 + " and "+n2+" is "+min);
  }
}
