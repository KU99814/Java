//Using the && and || operators

import java.util.Scanner;

public class EX3_5
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //�ŧi��J

   System.out.print("Enter an integer: ");
   int number = input.nextInt(); //��J�Ʀr

   //�ھڧP�_�����X���G
   boolean isAnd = (number%5==0&&number%7==0);//and
   System.out.println("Is "+number+" divisible by 5 and 7 ? " +isAnd);//���and

   boolean isOr = (number%5==0 || number%7==0);//or
   System.out.println("Is "+number+" divisible by 5 or 7 ? "+ isOr); //���or 

   boolean isNeitherOr = (isOr && !isAnd); //neither or
   System.out.println("Is "+number+" divisible by 5 or 7, but not both ? "+ isNeitherOr);//���neither or
  }
}