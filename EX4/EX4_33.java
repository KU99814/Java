//Game:lottery

import java.util.Scanner;

public class EX4_33
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //宣告輸入
   
   //隨機得出中獎號碼
   int lottery1 = (int)(Math.random()*10)+1;
   int lottery2 = (int)(Math.random()*10);

   //避免兩位數重複
   while(lottery2 == lottery1)
    {
     lottery2 = (int)(Math.random()*10);
    }

   int lottery = (lottery1*10) + lottery2;

   System.out.print("Enter your lottery pick (teo digitals): ");
   int guess = input.nextInt();//輸入猜測密碼

   if(guess == lottery)//如果全猜對的話
     System.out.println("Exact match: you win $10,000");
   else if(guess % 10 == lottery / 10 && guess / 10 == lottery % 10)//如果猜中但位數顛倒
     System.out.println("Match all: you win $3,000");
   else if(guess % 10 == lottery / 10 || guess / 10 == lottery % 10
           || guess / 10 == lottery / 10 || guess % 10 == lottery % 10) //如果猜中一位數
     System.out.println("Match all: you win $3,000");
   else //猜錯
     System.out.println("sorry,no match");
  }
}