//�p��wind-chill temparature

import java.util.Scanner;

public class EX5_17
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //�ŧi��J
   
   System.out.print("Enter outside temparature: ");//��J�ū�
   double t = input.nextDouble();

   System.out.print("Enter wind speed: ");//��J���t
   double s = input.nextDouble();

   System.out.print("The wind-chill temparature is "+getWillChillTemparature(t,s));//���
  }
 
 //�^�ǭ��t��method
 public static double getWillChillTemparature(double outsideTemparature,double speed)
  {
   double twc = 13.12 + 0.6215*outsideTemparature - 11.37*Math.pow(speed,0.16) 
                +0.3965*outsideTemparature*Math.pow(speed,0.16);  //�p��
   
   return twc;
  }
}