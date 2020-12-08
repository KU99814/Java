//wind chill temperature

import java.util.Scanner;

public class EX3_20
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //宣告輸入
 
   System.out.print("Enter the outside temperature measured in Celusius degree: ");
   double ta = input.nextDouble(); //輸入室外溫度

   double F = (ta+40)*1.8-40; //轉為華氏
   
   System.out.print("Enter the wind speed measured in kilometer per hour: ");
   double v = input.nextDouble(); //輸入風速 大於等於2

   //按照溫度以及風速範圍決定是否可計算 輸出結果
   if((F>-58 && F < 41) && v >= 2)
    {
     v = Math.pow(v,0.16);
     double twc = 13.12 + 0.6215*ta - 11.37*v+0.3965*ta*v;
   
     System.out.print("The NWS is: "+twc);
    }
   else 
    {
     if(F>-58 || F > 41)
      System.out.println("the outside temperature is invalid");
     if(v< 2)
      System.out.print(" wind speed is invalid");
    }
  }
}