//Summing series m(i) = 1/2+2/3+...+i/i+1

import java.util.Scanner;

public class EX20_6
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J

   System.out.println("m(i) = 1/2+2/3+...+i/i+1");
   System.out.print("Enter i: ");
   int i = input.nextInt();//��Ji �M�w�B����

   System.out.print("m("+i+") is "+m(i));//��ܵ��G
  }

 //���j�p��
 public static double m(double i)
  {
   //���j�ۥ[ ����base case
   double num = i/(i+1);
   if(i == 1)//base case
    return (double)num;
   else
    return (double)num+m(i-1);
  }
}