//Check a number divisible by 5 or 6

import java.util.Scanner;

public class EX3_12
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J
  
   System.out.print("Enter the number to divisible: ");
   int number = input.nextInt(); //��J�Ʀr

   boolean isOr = (number%5==0 || number%6 == 0 );//�O�_�Q���@�㰣
   boolean isAnd = (number%5==0 && number%6 == 0 ); //�O�_�Q�P�ɾ㰣

   //�P�_�Q5�M6�㰣�o���p
   if(isOr)
    {
     if(isAnd)//�P�ɾ㰣���p
      {
       System.out.print(number + " divisible by 5 and 6");
      }
     else //�D�P��
      {
       System.out.print(number + " divisible by 5 or 6,but not both");
      }
    }
   else //���Q���@�㰣
    System.out.print(number + " not divisible by either 5 or 6");
  }
}