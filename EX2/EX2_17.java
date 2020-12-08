//wind chill temperature

import java.util.Scanner;

public class EX2_17
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//宣告輸入
 
   System.out.print("Enter the outside temperature measured in Celusius degree: ");
   double ta = input.nextDouble(); //輸入溫度a 不可小於-50和大於5
   
   System.out.print("Enter the speed measured in kilometer per hour: ");
   double v = input.nextDouble(); //輸入速度 不可小於3

   v = Math.pow(v,0.16);//0.16次方
   double twc = 13.12 + 0.6215*ta - 11.37*v+0.3965*ta*v; //計算結果
   
   System.out.print("The NWS is: "+twc);//輸出結果
  }
}