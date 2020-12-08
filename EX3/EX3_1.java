//validating input

import java.util.Scanner;

public class EX3_1
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//宣告輸入
   
   System.out.print("Enter a radius: ");
   double r = input.nextDouble(); //輸入半徑

   if(r>=0) //如果不為負 輸出結果
    {
     double circle = r*r*3.14159;
  
     System.out.print("The area is "+circle);
    }
   else//為負 顯示錯誤訊息
    System.out.print("Incorrect input");
  }
}  