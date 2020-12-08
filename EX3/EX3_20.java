//wind chill temperature

import java.util.Scanner;

public class EX3_20
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //�ŧi��J
 
   System.out.print("Enter the outside temperature measured in Celusius degree: ");
   double ta = input.nextDouble(); //��J�ǥ~�ū�

   double F = (ta+40)*1.8-40; //�ର�ؤ�
   
   System.out.print("Enter the wind speed measured in kilometer per hour: ");
   double v = input.nextDouble(); //��J���t �j�󵥩�2

   //���ӷūץH�έ��t�d��M�w�O�_�i�p�� ��X���G
   if((F>-58 && F < 41) && v >= 2)
    {
     v = Math.pow(v,0.16);
     double twc = 13.12 + 0.6215*ta - 11.37*v+0.3965*ta*v;
   
     System.out.print("The NWS is: "+twc);
    }
   else 
    {
     if(F>-58 || F > 41)
      System.out.println("the outside temperature is invalid");
     if(v< 2)
      System.out.print(" wind speed is invalid");
    }
  }
}