//Repeat additions

import java.util.Scanner;

public class EX4_5
{
 public static void main(String args[])
  {
   final int NUMBER_OF_QUESTIONS = 5; //�X�D��
   int correctCount = 0; //���隸��
   int count = 0; //���D����
   long startTime = System.currentTimeMillis(); //�}�l�ɶ�
   String output = ""; //��X���G
   Scanner input = new Scanner(System.in); //�ŧi��J

   while(count < NUMBER_OF_QUESTIONS) //�X���D���캡���X�D��
    {
     //�H�����ͤT�Ӽ� �d��20~90
     int number1 = (int)(Math.random()*71)+20;
     int number2 = (int)(Math.random()*71)+20;
     int number3 = (int)(Math.random()*71)+20;

     //�X���D�ÿ�J����
     System.out.print("What is " + number1 + " + " + number2 + " + " + number3 +"? ");
     int answer = input.nextInt();
     
     //�p�G���T 
     if(number1 + number2 + number3 == answer)
      {
       System.out.println("You are correct!");
       correctCount++;
      }
     else //�p�G���~
       System.out.println("Your answer is wrong. \n"+ number1 + " + "+ number2 + " + " 
                           + number3 + " should be "+(number1 + number2 + number3));

     count++; //�W�[�w���D��
     output += "\n"+ number1 + " + "+ number2 + " + " + number3 + " = "+ answer + 
                       ((number1 + number2 + number3 == answer)? " correct":" wrong");
    }
     
   long endTime = System.currentTimeMillis(); //�����ɶ�
   long testTime = endTime - startTime; //��O�ɶ�

   //��X���G
   System.out.println("Correct count is " + correctCount + "\nTest time is "+testTime / 1000 +
                      " seconds\n"+output);
  }
}
 