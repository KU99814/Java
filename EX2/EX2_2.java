//computing the volume of a cylinder

import java.util.Scanner;

public class EX2_2
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //宣告輸入
   
   System.out.print("Enter a radius of a cylinder:");
   double radius = input.nextDouble();//輸入半徑

   System.out.print("Enter a length of a cylinder:");
   double length = input.nextDouble(); //輸入長度
   
   double area = radius*radius*Math.PI; //面積公式
   double volume = area*length; //體積公式

   System.out.print("The volume of cylinder is:"+volume); //輸出圓柱體體積
  }
}