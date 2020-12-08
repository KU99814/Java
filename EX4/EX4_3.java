//Repeat multiplications

import java.util.Scanner;

public class EX4_3
{
 public static void main(String args[])
  {
   int NUMBER_OF_QUESTIONS; //���D�Ӽ�
   int correctCount = 0; //�����
   int count = 0; //���D����
   long startTime = System.currentTimeMillis(); //�}�l�ɶ�
   String output = "";
   Scanner input = new Scanner(System.in); //�ŧi��J

   System.out.println("Enter the number of question: ");
   NUMBER_OF_QUESTIONS = input.nextInt();
   
   while(count < NUMBER_OF_QUESTIONS)
    {
     //�H�����ͨ�Ӽ�
     int number1 = (int)(Math.random()*8)+2;
     int number2 = (int)(Math.random()*8)+2;

     //�X�{���D
     System.out.print("What is " + number1 + " * " + number2 + "? ");
     int answer = input.nextInt(); //���X����
     
     //�ﵪ�� ����[�� ������ܥ���
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
     
   long endTime = System.currentTimeMillis(); //�����ɶ�
   long testTime = endTime - startTime; //���ժ�O�ɶ�

   //��X���G
   System.out.println("Correct count is " + correctCount + 
                      "\nTest time is "+testTime / 1000 + " seconds\n"+output);
  }
}
 