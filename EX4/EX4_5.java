//Repeat additions

import java.util.Scanner;

public class EX4_5
{
 public static void main(String args[])
  {
   final int NUMBER_OF_QUESTIONS = 5; //出題數
   int correctCount = 0; //答對次數
   int count = 0; //答題次數
   long startTime = System.currentTimeMillis(); //開始時間
   String output = ""; //輸出結果
   Scanner input = new Scanner(System.in); //宣告輸入

   while(count < NUMBER_OF_QUESTIONS) //出問題直到滿足出題數
    {
     //隨機產生三個數 範圍為20~90
     int number1 = (int)(Math.random()*71)+20;
     int number2 = (int)(Math.random()*71)+20;
     int number3 = (int)(Math.random()*71)+20;

     //出問題並輸入答案
     System.out.print("What is " + number1 + " + " + number2 + " + " + number3 +"? ");
     int answer = input.nextInt();
     
     //如果正確 
     if(number1 + number2 + number3 == answer)
      {
       System.out.println("You are correct!");
       correctCount++;
      }
     else //如果錯誤
       System.out.println("Your answer is wrong. \n"+ number1 + " + "+ number2 + " + " 
                           + number3 + " should be "+(number1 + number2 + number3));

     count++; //增加已答題數
     output += "\n"+ number1 + " + "+ number2 + " + " + number3 + " = "+ answer + 
                       ((number1 + number2 + number3 == answer)? " correct":" wrong");
    }
     
   long endTime = System.currentTimeMillis(); //結束時間
   long testTime = endTime - startTime; //花費時間

   //輸出結果
   System.out.println("Correct count is " + correctCount + "\nTest time is "+testTime / 1000 +
                      " seconds\n"+output);
  }
}
 