//BMI

import java.util.Scanner;

public class EX2_14
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //宣告輸入

   System.out.print("Enter your weights: ");
   double pound = input.nextDouble();//輸入體重(磅)
  
   double weight = pound*0.45359237; //轉換成公斤

   System.out.print("Enter your heights: ");
   double inch = input.nextDouble(); //輸入身高(英吋)

   double height = inch*0.0254;//轉換成公尺

   double bmi = weight/((height)*(height)); //計算BMI

   System.out.print("Your BMI is: "+bmi); //輸出結果
  }
}