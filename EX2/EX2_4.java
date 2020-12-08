//converting pounds into kilograms

import java.util.Scanner;

public class EX2_4
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //宣告輸入
   
   System.out.print("Enter a number of pounds:");
   double pound = input.nextDouble(); //輸入磅數

   double kilogram = pound*0.454; //轉換公斤
   
   System.out.print("The pounds converted into kilograms are:"+kilogram);//輸出結果
  }
}