//wind chill temperature

import java.util.Scanner;

public class EX2_17
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J
 
   System.out.print("Enter the outside temperature measured in Celusius degree: ");
   double ta = input.nextDouble(); //��J�ū�a ���i�p��-50�M�j��5
   
   System.out.print("Enter the speed measured in kilometer per hour: ");
   double v = input.nextDouble(); //��J�t�� ���i�p��3

   v = Math.pow(v,0.16);//0.16����
   double twc = 13.12 + 0.6215*ta - 11.37*v+0.3965*ta*v; //�p�⵲�G
   
   System.out.print("The NWS is: "+twc);//��X���G
  }
}