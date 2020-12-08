//Finding the highest score

import java.util.Scanner;

public class EX4_8
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //宣告輸入
   
   System.out.print("Enter the student number: ");
   int num = input.nextInt(); //輸入學生數

   int max = 0; //最高分
   String student; //學生名
   String MaxName = ""; //最高分的名字
   
   for(int i = 0;i<num;i++)//依照學生數輸入
    {
     System.out.print("Enter student's name: ");
     student = input.next(); //輸入學生姓名
     System.out.print("Enter student's score: ");
     int score = input.nextInt(); //輸入分數
     if(score > max) //最高分學生
      {
       max = score;
       MaxName = student;
      }
    }
   //顯示結果
   System.out.print("The student has the height score is "+MaxName);
   System.out.print("\nThe score is: "+max);
  }
}