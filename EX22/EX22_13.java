//Game:lottery

import java.util.*;

public class EX22_13
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//块

   int lottery1 = (int)(Math.random()*10)+1;//眔繦诀计 0~9
   int lottery2 = 0;//计 眔繦诀计 磷蛤1狡 0~9

   //眔繦诀
   while(true)
    {
     lottery2 = (int)(Math.random()*10);

     if(lottery2 != lottery1)
      break;
    }

   //盢贾硓计set
   Set<Integer> lotterySet = new HashSet<Integer>();
   lotterySet.add(lottery1);
   lotterySet.add(lottery2);

   int lottery = (lottery1*10) + lottery2;//眔贾硓计

   System.out.print("Enter your lottery pick (teo digitals): ");//块瞦代计
   int guess = input.nextInt();

   Set<Integer> guessSet = new HashSet<Integer>();//盢瞦代计瞦Θㄢ计
   guessSet.add(guess/10);
   guessSet.add(guess%10);

   if(lotterySet.containsAll(guessSet))//狦Ч珹 
    System.out.println("You get additional money $2000");

   //ㄤ猵
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