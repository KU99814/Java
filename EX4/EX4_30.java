//compound value

import java.util.Scanner;

public class EX4_30
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //�ŧi��J

   System.out.print("Enter the amount: ");
   double amount = input.nextDouble(); //��J���B

   System.out.print("Enter the rate: ");
   double rate = input.nextDouble(); //��J�Q�v

   System.out.print("Enter the month: ");
   int month = input.nextInt(); //��J���
  
   double account = 0; //�`���B

   //�p���`���B
   for(int i = 1;i<=month;i++)
    {
     account += amount;
     account *= (1+(rate/100/12));
    }
   account = (int)(account*1000);
   account /= 1000;
   System.out.print("The saving account after the given month is "+account);
  }
}