//Counting positive and negative numbers and computing the average of numbers

import java.util.Scanner;

public class EX4_2
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //块

   int num; //块计
   int sum = 0; //羆㎝
   int positive = 0; //タ计计
   int negative = 0; //璽计计

   //块计块0
   while(true)
    {
     System.out.print("Enter a number: ");
     num = input.nextInt();
   
     if(num > 0) //璝タ计
      positive++;
     else if(num < 0) //璝璽 
      negative++;
     else if(num == 0)
      break;
   
     sum += num; //羆
    }
   double average = 0; //キА计
   if(positive+negative == 0) //璝⊿Τ块
    average = 0;
   else //璝Τ 璸衡キА
    average = sum / (positive+negative);

   //块挡狦
   System.out.print("\nThe positive number hae been read "+positive);
   System.out.print("\nThe negativ number hae been read "+negative);
   System.out.print("\nThe total are "+ sum);
   System.out.print("\nThe average are "+ average);
  }
}             