//����Ʀr(�^��)

import java.util.Scanner;

public class EX5_4
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //�ŧi��J
   
   System.out.print("Enter a number: ");
   int number = input.nextInt();//��J�Ʀr
   
   System.out.print(reverse(number));//����
  }

 //����æ^���ܼƪ�method
 public static int reverse(int number)
  {
   int num2 = 0;//�^���ܼ�
   while(true)
    {
     num2+=number%10; //�[�J�l�� ����[�J�̫�@���
     number/=10;//��Ʃ��k�h�@��
     if(number==0)
      break;
     else
      num2*=10;  //�^�ǼƩ����i�@��
    }
   return num2; //�^��
  }
}