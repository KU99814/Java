//�M��̱��񥭤�ڪ���

import java.util.Scanner;

public class EX5_22
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //�ŧi��J
 
   System.out.print("Enter a number: ");  //��J�Q�䪺��
   double num = input.nextDouble();

   System.out.print("The number's square is: "+sqrt(num)); //���
  }

 //�M�䱵�񥭤�ڪ���
 public static double sqrt(double num)
  {
   double lastGuess = 1; //�W�@�� �q����
   double nextGuess = 1;//�U�@�Ӳq����

   while(true)  //�B��
    {
     lastGuess = nextGuess;
     nextGuess = (lastGuess + (num / lastGuess))/2.0;
     
     if(Math.abs(nextGuess - lastGuess) < 0.0001)  //�p�G ��Ƶ���Ȯt�p��0.0001 ���X
      break;
    }
   
   return nextGuess; //�^�ǭ�
  }
}