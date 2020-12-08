//計算wind-chill temparature

import java.util.Scanner;

public class EX5_17
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //宣告輸入
   
   System.out.print("Enter outside temparature: ");//輸入溫度
   double t = input.nextDouble();

   System.out.print("Enter wind speed: ");//輸入風速
   double s = input.nextDouble();

   System.out.print("The wind-chill temparature is "+getWillChillTemparature(t,s));//顯示
  }
 
 //回傳風速的method
 public static double getWillChillTemparature(double outsideTemparature,double speed)
  {
   double twc = 13.12 + 0.6215*outsideTemparature - 11.37*Math.pow(speed,0.16) 
                +0.3965*outsideTemparature*Math.pow(speed,0.16);  //計算
   
   return twc;
  }
}