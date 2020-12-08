//Game:multiply three numbers

import java.util.Scanner;

public class EX3_3
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//宣告輸入
   
   //以現在時間產生三個數
   int number1 = (int)(System.currentTimeMillis() % 10);
   int number2 = (int)(System.currentTimeMillis() *7 % 10);
   int number3 = (int)(System.currentTimeMillis() *9 % 10);
  
   System.out.print("What is " + number1 + " * " + number2 + " * " +number3+" = " +" ? ");
   int answer = input.nextInt(); //輸入三數相乘答案

   //顯示答案是否正確
   System.out.println(number1 + " * " + number2 + " * " + number3 + " = " + answer +
                      " is " +(number1*number2*number3==answer));
  }
}