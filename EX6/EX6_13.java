//算出不特定個數的平均

import java.util.Scanner;

public class EX6_13
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //宣告輸入

   System.out.print("Enter a number of amount: "); //輸入個數
   int amount = input.nextInt();

   if(amount == 0) //如果個數為零時的情況
     System.out.print("There is no number");  
   else
    {
     int[] num = new int[amount];

     System.out.print("Enter "+amount+" numbers: "); //輸入數
     for(int i =0;i<num.length;i++)
      num[i] = input.nextInt(); 
   
     System.out.print("The average is "+average(num)); //顯示平均
    }
  }

 //平均的method
 public static double average(int... number)
  {
   double average = 0;
   
   for(int i=0;i<number.length;i++) //運算加總
    average+=number[i];
   average/=number.length;

   return average;
  }
}   
   