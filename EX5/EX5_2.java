//��Ƭۥ[

import java.util.Scanner;

public class EX5_2
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //�ŧi��J
   
   System.out.print("Enter a number: ");
   long number = input.nextLong();//��J�Ʀr

   System.out.println("The sum of number's digital is: "+sumDigitals(number));//��ܵ��G
  }

 //�[�`method 
 public static int sumDigitals(long n)
  {
   int sum = 0;

   while(true)//�B��
    {
     sum += (int)(n%10);//�[�̫�@��
     n /= 10;//��ƥk��

     if(n == 0)
      break; 
    }
   return sum; //�^��
  }
}    