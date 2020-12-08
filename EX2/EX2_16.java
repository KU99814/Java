//calaulating The energy needed to heat water from an initial
//temperature to a final temperature of the water

import java.util.Scanner;

public class EX2_16
{
 public static void main(String arga[])
  {
   Scanner input = new Scanner(System.in);//宣告輸入

   System.out.print("Enter the amount of water in kiloigrams: ");
   double amountOfWater = input.nextDouble(); //輸入水量

   System.out.print("Enter the initial: ");
   double initial = input.nextDouble(); //輸入初始溫度

   System.out.print("Enter the final temperatures of the water: ");
   double finalTemperature = input.nextDouble(); //輸入最後溫度

   double Q = amountOfWater*(finalTemperature - initial)*4184; //計算所需熱量

   System.out.print("The energy needed to heat water from an initial "+
    "temperature to a final temperature of the water is: "+Q); //輸出結果
  }
}