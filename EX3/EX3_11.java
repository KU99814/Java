//distance between two points

import java.util.Scanner;

public class EX3_11
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J
   
   //��J�Ĥ@�I�y��
   System.out.print("Enter the x- and y- coordinates for point1: ");
   Double xPoint1 = input.nextDouble(); //x1
   Double yPoint1  = input.nextDouble(); //y1

   //��J�ĤG�I�y��
   System.out.print("Enter the x- and y- coordinates for point2: ");
   Double xPoint2  = input.nextDouble(); //x2
   Double yPoint2  = input.nextDouble(); //y2
   
   //�p����I�Z��
   double temp1 = Math.pow((xPoint2 - xPoint1),2) + Math.pow((yPoint2 - yPoint1),2);
   double temp2 = Math.sqrt(temp1);
   
   System.out.print("The distance between the two points is "+temp2); //��X���G
  }
}