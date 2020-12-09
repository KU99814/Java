//Summing the digits in an integer using recursion

import java.util.Scanner;

public class EX20_11
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J

   System.out.print("Enter a number: ");
   long num = input.nextLong();//��J�Ʀr

   System.out.print("The sum of digits is "+sumDigits(num));//��ܵ��G
  }

 //���j�p���ƥ[�`
 public static int sumDigits(long n)
  {
   if(n/10==0)//base case
    return (int)(n%10);
   else //���j���H�Q�᪺��
    return (int)(n%10+sumDigits(n/10));
  }
}