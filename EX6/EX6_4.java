//����}�C���Ƥj�Τp�󥭧�

import java.util.Scanner;

public class EX6_4
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //�ŧi��J

   int[] score = new int[10]; //�]�w���ư}�C �̦h10��
   int i = 0; //�ǥͼƶq
   double average = 0; //����

   while(true)
    {
     System.out.print("Enter a score: "); //��J�Ʀr
     score[i] = input.nextInt();
     average += score[i];

     if(score[i]<0) //��J�t�Ƹ��X
      break;
     i++;
     if(i==score.length) //��F�}�C���׸��X
      break;
    }
   average /= (i); //����

   int above = 0;//�񥭧��j�ε���
   int below = 0;//�񥭧��p

   for(int j=0;j<i;j++) //���
    {
     if(score[j] >= average)
      above++;
     else
      below++;
    }

   System.out.println("There has "+above+" scores above or equal to average"); //��X
   System.out.println(below+" scores below to average");
  }
}   