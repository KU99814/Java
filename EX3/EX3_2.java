//Checking whether a number is even

import java.util.Scanner;

public class EX3_2
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //宣告輸入
   
   System.out.print("Enter a integer: ");
   int num = input.nextInt(); //輸入數字

   //判斷是否為偶數
   System.out.print("Is "+num+" an even number? "+(num%2 == 0));
  }
}