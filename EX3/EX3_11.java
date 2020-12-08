//distance between two points

import java.util.Scanner;

public class EX3_11
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//宣告輸入
   
   //輸入第一點座標
   System.out.print("Enter the x- and y- coordinates for point1: ");
   Double xPoint1 = input.nextDouble(); //x1
   Double yPoint1  = input.nextDouble(); //y1

   //輸入第二點座標
   System.out.print("Enter the x- and y- coordinates for point2: ");
   Double xPoint2  = input.nextDouble(); //x2
   Double yPoint2  = input.nextDouble(); //y2
   
   //計算兩點距離
   double temp1 = Math.pow((xPoint2 - xPoint1),2) + Math.pow((yPoint2 - yPoint1),2);
   double temp2 = Math.sqrt(temp1);
   
   System.out.print("The distance between the two points is "+temp2); //輸出結果
  }
}