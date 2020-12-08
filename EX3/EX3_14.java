//Game:head or tail

import java.util.Scanner;

public class EX3_14
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //宣告輸入

   //以隨機0或一決定硬幣正反面
   int coin = (int)(Math.random()*2);
  
   System.out.print("Enter 0 or 1 to guess the head or tail of a coin, 0 is head and 1 is tail :");
   int guess = input.nextInt(); //輸入猜測結果

   if(guess > 1 || guess < 0 )//判斷輸入是否有誤
    System.out.print("Error");
   else//判斷是否答對
    {
     if(guess == coin)
      {
       System.out.print("correct");
      }
     else
      {
       System.out.print("incorrect");
      }
    }
  }
}
     