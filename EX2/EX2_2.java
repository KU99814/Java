//computing the volume of a cylinder

import java.util.Scanner;

public class EX2_2
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //�ŧi��J
   
   System.out.print("Enter a radius of a cylinder:");
   double radius = input.nextDouble();//��J�b�|

   System.out.print("Enter a length of a cylinder:");
   double length = input.nextDouble(); //��J����
   
   double area = radius*radius*Math.PI; //���n����
   double volume = area*length; //��n����

   System.out.print("The volume of cylinder is:"+volume); //��X��W����n
  }
}