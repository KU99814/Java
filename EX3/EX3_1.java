//validating input

import java.util.Scanner;

public class EX3_1
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J
   
   System.out.print("Enter a radius: ");
   double r = input.nextDouble(); //��J�b�|

   if(r>=0) //�p�G�����t ��X���G
    {
     double circle = r*r*3.14159;
  
     System.out.print("The area is "+circle);
    }
   else//���t ��ܿ��~�T��
    System.out.print("Incorrect input");
  }
}  