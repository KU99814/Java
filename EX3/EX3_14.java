//Game:head or tail

import java.util.Scanner;

public class EX3_14
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //�ŧi��J

   //�H�H��0�Τ@�M�w�w�����ϭ�
   int coin = (int)(Math.random()*2);
  
   System.out.print("Enter 0 or 1 to guess the head or tail of a coin, 0 is head and 1 is tail :");
   int guess = input.nextInt(); //��J�q�����G

   if(guess > 1 || guess < 0 )//�P�_��J�O�_���~
    System.out.print("Error");
   else//�P�_�O�_����
    {
     if(guess == coin)
      {
       System.out.print("correct");
      }
     else
      {
       System.out.print("incorrect");
      }
    }
  }
}
     