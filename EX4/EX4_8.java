//Finding the highest score

import java.util.Scanner;

public class EX4_8
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //�ŧi��J
   
   System.out.print("Enter the student number: ");
   int num = input.nextInt(); //��J�ǥͼ�

   int max = 0; //�̰���
   String student; //�ǥͦW
   String MaxName = ""; //�̰������W�r
   
   for(int i = 0;i<num;i++)//�̷Ӿǥͼƿ�J
    {
     System.out.print("Enter student's name: ");
     student = input.next(); //��J�ǥͩm�W
     System.out.print("Enter student's score: ");
     int score = input.nextInt(); //��J����
     if(score > max) //�̰����ǥ�
      {
       max = score;
       MaxName = student;
      }
    }
   //��ܵ��G
   System.out.print("The student has the height score is "+MaxName);
   System.out.print("\nThe score is: "+max);
  }
}