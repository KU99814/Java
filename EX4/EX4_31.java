//computing CD value

import java.util.Scanner;

public class EX4_31
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //�ŧi��J
   
   System.out.print("Enter an amount into CD every month: ");
   double amount = input.nextDouble(); //��J���B

   System.out.print("Enter the annual percentage yield: ");
   double rate = input.nextDouble(); //��J�Q�v

   System.out.print("Enter the number of months: ");
   int month = input.nextInt(); //��J���

   System.out.println("Month\t\t\tCD Value");

   double value = amount;
  
   //��ܨC����B
   for(int i = 1;i<=month;i++)
    {
     value +=  value*(rate/1200);
    
     System.out.printf("%d\t\t\t%.2f\n",i,value);
     
    }
  }
}