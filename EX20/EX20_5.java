//Summing series m(i) = 1/3+2/5+3/7+4/9+5/11+6/13....+i/2i+1

import java.util.Scanner;

public class EX20_5
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J

   System.out.println("m(i) = 1/3+2/5+3/7+4/9+5/11+6/13....+i/2i+1");
   System.out.print("Enter i: ");
   int i = input.nextInt();//��Ji �M�w�p����

   System.out.print("m("+i+") is "+m(i));//��ܵ��G
  }

 //���j�p��
 public static double m(double i)
  {
   //���j����base case
   double num = i/(2*i+1);
   if(i == 1)//base case
    return (double)num;
   else
    return (double)num+m(i-1);
  }
}