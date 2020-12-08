//т程籔蛤程计计

import java.util.Scanner;

public class EX6_2
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //块

   final int TOTAL_NUMBERS = 6; //块Ω计
   int[] numbers = new int[TOTAL_NUMBERS]; //计皚

   for(int i=0;i<numbers.length;i++)//块せΩ
    {
     System.out.print("Enter a number: ");
     numbers[i] = input.nextInt();
    }
 
   int max = numbers[0]; //盢程砞材计
   int count = 1;
   for(int i=1;i<numbers.length;i++) //ゑ耕 
    {
     if(max < numbers[i]) //狦穝т程
      {
       max = numbers[i];
       count=1; //count耴1
      }
     else if(max == numbers[i]) //狦т计 碞1
      count++;
    }
   
   //陪ボ皚
   String output = "The array is ";
   for(int i=0;i<numbers.length;i++)
    {
     output+=numbers[i];
    }
   output += "\nThe largest number is "+max;
   output += "\nThe occurrence count of the largest number "+"is "+count;
   System.out.print(output); //陪ボ
  }
}