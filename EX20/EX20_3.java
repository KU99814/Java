//Computing greatest common divisor using recursion

import java.util.Scanner;

public class EX20_3
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J

   System.out.print("Enter first number: ");
   int m = input.nextInt();//��J�Ĥ@�Ӽ�

   System.out.print("Enter second number(smaller than first): ");
   int n = input.nextInt();//��J�ĤG�Ӽ�(�p��Ĥ@��)

   System.out.println("The gcd is "+gcd(m,n));//���GCD
  }

 //�̤j���]��(���j)
 public static int gcd(int m,int n)
  {
   if(m%n==0)//�p�G�l�Ƭ��s �^��N
    return n;
   else //�_�h�~�򻼰j
    return gcd(n,m%n);
  }
}