//finding the number of days in a year

import java.util.Scanner;

public class EX3_13
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //�ŧi��J

   System.out.print("Enter a year: ");
   int year = input.nextInt(); //��J�~��

   int day = 365;//�w�]�Ѽ�
   //�q�~���P�_�Ѽ�
   if(year%4 == 0 && year % 100 !=0 || year%400 == 0)
    {
     day++;//�Y���|�~�Ѽ�+1
    }
   System.out.print("The days of "+year+" year are "+day);
  }
}