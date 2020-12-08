//Displaying numbers in a pyramid pattern

import java.util.Scanner;

public class EX4_19
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //块
  
   System.out.print("Enter the number of lines: ");
   int numberOfLines = input.nextInt(); //块璶陪ボ︽计 眖110

   if(numberOfLines<1 || numberOfLines>10)
    {
     System.out.println("You must enter a number from 1 to 10: ");
     System.exit(0);
    }

   int count = 1; //璸衡计 籔︽计传︽
   int num = 1; //块计

   for(int row = 1;row <= numberOfLines;row++)
    {
     for(int column = 1;column <= numberOfLines - row; column++)
       System.out.print("   "); //块计ゎ

     while(num <= Math.pow(count,2)) //赣︽程计ゲ单︽计キよ 
      {
       System.out.print((num >= 10) ? " " + num : "  "+num);
       num++;
      }
     count++;

     System.out.println();
    }
  }
}  