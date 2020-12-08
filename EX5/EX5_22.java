//碝т程钡キよ计

import java.util.Scanner;

public class EX5_22
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //块
 
   System.out.print("Enter a number: ");  //块稱т计
   double num = input.nextDouble();

   System.out.print("The number's square is: "+sqrt(num)); //陪ボ
  }

 //碝т钡キよ计
 public static double sqrt(double num)
  {
   double lastGuess = 1; // 瞦代计
   double nextGuess = 1;//瞦代计

   while(true)  //笲衡
    {
     lastGuess = nextGuess;
     nextGuess = (lastGuess + (num / lastGuess))/2.0;
     
     if(Math.abs(nextGuess - lastGuess) < 0.0001)  //狦 ㄢ计荡癸畉0.0001 铬
      break;
    }
   
   return nextGuess; //肚
  }
}