//BMI

import java.util.Scanner;

public class EX3_18
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //宣告輸入

   System.out.print("Enter weight in pounds: ");
   double pound = input.nextDouble(); //輸入體重 磅

   System.out.print("Enter weight in feet: ");
   double feet = input.nextDouble(); //輸入身高 英尺 

   System.out.print("Enter weight in inches: ");
   double inch = input.nextDouble(); //輸入身高 英吋

   inch += feet*12;//將英尺換成英吋

   //將身高轉換成公尺 體重轉換成公斤
   final double KILOGRAMS_PER_POUND = 0.45359237;//磅轉公斤比例
   final double METERS_PER_INCH = 0.0254;//英吋轉公尺比例

   double weight = pound * KILOGRAMS_PER_POUND;//轉為公斤
   double height = inch * METERS_PER_INCH;//轉為公尺

   double bmi = weight / (height*height);

   System.out.println("Your BMI is "+bmi); //輸出BMI
   
   //根據BMI判斷身體狀況
   if(bmi < 16)
    System.out.println("You are seriously underweight");
   else if(bmi < 18)
    System.out.println("You are underweight");
   else if(bmi < 24)
    System.out.println("You are normal weight");
   else if(bmi < 29)
    System.out.println("You are overweight");
   else if(bmi < 35)
    System.out.println("You are seriously overweight");
   else
    System.out.println("You are gravely overweight");
  }
}
