//Summing series m(i) = 1+1/2+1/3+....+1/i

import java.util.Scanner;

public class EX20_4
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J

   System.out.println("m(i) = 1+1/2+1/3+....+1/i");
   System.out.print("Enter i: ");
   int i = input.nextInt();//��Ji �M�w�n�B������

   System.out.print("m("+i+") is "+m(i));//��ܵ��G
  }

 //�B��method
 public static double m(double i)
  {
   //����i=1����j�p��
   double num = 1/i; 
   if(i == 1)//base case
    return num;
   else
    return (double)num+m(i-1);
  }
}