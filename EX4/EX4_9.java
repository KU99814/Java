// find the three highest score

import java.util.Scanner;

public class EX4_9
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J
  
   System.out.print("Enter the student number: ");
   int num = input.nextInt(); //��J�ǥͼ�

   //�e�T����
   int max1 = 0; 
   int max2 = 0;
   int max3 = 0;

   for(int i = 0;i<num;i++)//�̾ǥͼư���
    {
     System.out.print("Enter the "+(i+1)+"student's score: ");
     int score = input.nextInt();
      
     //����O�_�e�T�����ñƧ�
     if(score > max1)//��̰�����
      {
       max3 = max2;
       max2 = max1;
       max1 = score;
      }

     else if(score > max2)//��ĤG������
      {
       max3 = max2;
       max2 = score;
      }

     else if(score > max3)//��ĤT������
      {
       max3 = score;
      }
   
    }
   
   //��X���G
   System.out.println("The highest score is: " + max1);
   System.out.println("The second-highest score is: " + max2);
   System.out.println("The third-highest score is: " + max3);
  }
}     