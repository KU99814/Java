//converting pounds into kilograms

import java.util.Scanner;

public class EX2_4
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //�ŧi��J
   
   System.out.print("Enter a number of pounds:");
   double pound = input.nextDouble(); //��J�S��

   double kilogram = pound*0.454; //�ഫ����
   
   System.out.print("The pounds converted into kilograms are:"+kilogram);//��X���G
  }
}