//calaulating The energy needed to heat water from an initial
//temperature to a final temperature of the water

import java.util.Scanner;

public class EX2_16
{
 public static void main(String arga[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J

   System.out.print("Enter the amount of water in kiloigrams: ");
   double amountOfWater = input.nextDouble(); //��J���q

   System.out.print("Enter the initial: ");
   double initial = input.nextDouble(); //��J��l�ū�

   System.out.print("Enter the final temperatures of the water: ");
   double finalTemperature = input.nextDouble(); //��J�̫�ū�

   double Q = amountOfWater*(finalTemperature - initial)*4184; //�p��һݼ��q

   System.out.print("The energy needed to heat water from an initial "+
    "temperature to a final temperature of the water is: "+Q); //��X���G
  }
}