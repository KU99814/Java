//BMI

import java.util.Scanner;

public class EX2_14
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //�ŧi��J

   System.out.print("Enter your weights: ");
   double pound = input.nextDouble();//��J�魫(�S)
  
   double weight = pound*0.45359237; //�ഫ������

   System.out.print("Enter your heights: ");
   double inch = input.nextDouble(); //��J����(�^�T)

   double height = inch*0.0254;//�ഫ������

   double bmi = weight/((height)*(height)); //�p��BMI

   System.out.print("Your BMI is: "+bmi); //��X���G
  }
}