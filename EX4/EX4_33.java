//Game:lottery

import java.util.Scanner;

public class EX4_33
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //�ŧi��J
   
   //�H���o�X�������X
   int lottery1 = (int)(Math.random()*10)+1;
   int lottery2 = (int)(Math.random()*10);

   //�קK���ƭ���
   while(lottery2 == lottery1)
    {
     lottery2 = (int)(Math.random()*10);
    }

   int lottery = (lottery1*10) + lottery2;

   System.out.print("Enter your lottery pick (teo digitals): ");
   int guess = input.nextInt();//��J�q���K�X

   if(guess == lottery)//�p�G���q�諸��
     System.out.println("Exact match: you win $10,000");
   else if(guess % 10 == lottery / 10 && guess / 10 == lottery % 10)//�p�G�q��������A��
     System.out.println("Match all: you win $3,000");
   else if(guess % 10 == lottery / 10 || guess / 10 == lottery % 10
           || guess / 10 == lottery / 10 || guess % 10 == lottery % 10) //�p�G�q���@���
     System.out.println("Match all: you win $3,000");
   else //�q��
     System.out.println("sorry,no match");
  }
}