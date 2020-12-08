//Finding the factors of an integer

import java.util.Scanner;

public class EX4_16
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //宣告輸入

   System.out.print("Enter a number: "); 
   int num = input.nextInt(); //輸入一個數字
  
   int i = 2;//初始質因數

   System.out.print("The factors of this number is ");
   
   while(true)
    {
     //如果能夠整除 除到不能整除為止
     if(num%i == 0)
      {
       System.out.print(i+" ");
       num /= i;
      }
     else if(num%i != 0)
      i++;
     if(num == 1)
      break;
    }
  }
}