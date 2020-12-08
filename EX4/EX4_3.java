//Repeat multiplications

import java.util.Scanner;

public class EX4_3
{
 public static void main(String args[])
  {
   int NUMBER_OF_QUESTIONS; //問題個數
   int correctCount = 0; //答對數
   int count = 0; //答題次數
   long startTime = System.currentTimeMillis(); //開始時間
   String output = "";
   Scanner input = new Scanner(System.in); //宣告輸入

   System.out.println("Enter the number of question: ");
   NUMBER_OF_QUESTIONS = input.nextInt();
   
   while(count < NUMBER_OF_QUESTIONS)
    {
     //隨機產生兩個數
     int number1 = (int)(Math.random()*8)+2;
     int number2 = (int)(Math.random()*8)+2;

     //出現問題
     System.out.print("What is " + number1 + " * " + number2 + "? ");
     int answer = input.nextInt(); //答出答案
     
     //對答案 答對加分 答錯顯示正解
     if(number1 * number2 == answer)
      {
       System.out.println("You are correct!");
       correctCount++;
      }
     else
       System.out.println("Your answer is wrong. \n"+ number1 + " * "+
                          number2 + " should be "+(number1 * number2));

     count++;
     output += "\n"+ number1 + " * "+ number2 + " = "+ answer +
               ((number1 * number2 == answer)? " correct":" wrong");
    }
     
   long endTime = System.currentTimeMillis(); //結束時間
   long testTime = endTime - startTime; //測試花費時間

   //輸出結果
   System.out.println("Correct count is " + correctCount + 
                      "\nTest time is "+testTime / 1000 + " seconds\n"+output);
  }
}
 