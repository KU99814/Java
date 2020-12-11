//Game:lottery

import java.util.*;

public class EX22_13
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J

   int lottery1 = (int)(Math.random()*10)+1;//���o�H���Ʀr 0~9
   int lottery2 = 0;//�ŧi�Ʀr �b�U�C���o�H���Ʀr �קK��1���� 0~9

   //���o�H��
   while(true)
    {
     lottery2 = (int)(Math.random()*10);

     if(lottery2 != lottery1)
      break;
    }

   //�N�ֳz�Ʀr��Jset
   Set<Integer> lotterySet = new HashSet<Integer>();
   lotterySet.add(lottery1);
   lotterySet.add(lottery2);

   int lottery = (lottery1*10) + lottery2;//���o�ֳz�Ʀr

   System.out.print("Enter your lottery pick (teo digitals): ");//��J�q���Ʀr
   int guess = input.nextInt();

   Set<Integer> guessSet = new HashSet<Integer>();//�N�q���Ʀr�q����Ʀs�J
   guessSet.add(guess/10);
   guessSet.add(guess%10);

   if(lotterySet.containsAll(guessSet))//�p�G�����]�A 
    System.out.println("You get additional money $2000");

   //��L���p
   if(guess == lottery)
     System.out.println("Exact match: you win $10,000");
   else if(guess % 10 == lottery / 10 && guess / 10 == lottery % 10)
     System.out.println("Match all: you win $3,000");
   else if(guess % 10 == lottery / 10 || guess / 10 == lottery % 10
           || guess / 10 == lottery / 10 || guess % 10 == lottery % 10)
     System.out.println("Match all: you win $3,000");
   else
     System.out.println("sorry,no match");
  }
}