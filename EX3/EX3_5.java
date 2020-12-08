//Using the && and || operators

import java.util.Scanner;

public class EX3_5
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //宣告輸入

   System.out.print("Enter an integer: ");
   int number = input.nextInt(); //輸入數字

   //根據判斷條件輸出結果
   boolean isAnd = (number%5==0&&number%7==0);//and
   System.out.println("Is "+number+" divisible by 5 and 7 ? " +isAnd);//顯示and

   boolean isOr = (number%5==0 || number%7==0);//or
   System.out.println("Is "+number+" divisible by 5 or 7 ? "+ isOr); //顯示or 

   boolean isNeitherOr = (isOr && !isAnd); //neither or
   System.out.println("Is "+number+" divisible by 5 or 7, but not both ? "+ isNeitherOr);//顯示neither or
  }
}