import java.util.Scanner;

public class EX3_9
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //宣告輸入
 
   //隨機產生三數字
   int number1 = (int)(Math.random()*50);
   int number2 = (int)(Math.random()*50);
   int number3 = (int)(Math.random()*50);

   System.out.print("What is "+number1+" + "+number2 + " + "+number3+" =? ");
   int answer = input.nextInt(); //輸入答案

   //正確顯示答對
   if(number1 + number2 + number3 == answer)
     System.out.println("You are corrent!");
   else //錯誤顯示正確答案
     System.out.println("Your answer is wrong.\n" + number1 + " + "
               + number2 + " + "+ number3+" should be "+ (number1 + number2 + number3));
  }
}