//計算距離

import java.util.Scanner;

public class EX5_5
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//宣告輸入
   
   System.out.print("Enter first point: "); //輸入第一個點xy座標
   double x1 = input.nextDouble();
   double y1 = input.nextDouble();

   System.out.print("Enter second point: "); //輸入第二個點xy座標
   double x2 = input.nextDouble();
   double y2 = input.nextDouble();

   System.out.print("The distance is: "+distance(x1,y1,x2,y2)); //輸出距離
  }

 //計算距離的method
 public static double distance(double x1,double y1,double x2,double y2)
  {
   double p1 = Math.pow((x2-x1),2);   //X2-X1平方
   double p2 = Math.pow((y2-y1),2);   //Y2-Y1平方
   double p = Math.sqrt((p1+p2));     //開根號
    
   return p;
  }
}