//Financial: credit card number validation

import java.util.Scanner;

public class EX5_31
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J

   System.out.print("Enter your credit card number: ");
   long number = input.nextLong(); //��J�d�� 4388576018402625 invalid 4388576018410707 valid

   //�ˬd�O�_����
   System.out.print("This number is "+isValid(number));
  }

 //�ˬd�O�_���Ī�method
 public static boolean isValid(long number)
  {
   long num = number;
   while(true)//�ˬd�}�Y�O�_�X�k �]���d����Ƥ��T�w �H�j���X�Y
    {
     num /=10;
     if(num==37 || num == 4 || num == 5 || num == 6)
      break;
     if(num==0)
      return false;
    }
   int sum = sumOfEvenPlace(number) + sumOfOddPlace(number);//�N�_�Ʀ�P���Ʀ쵲�G�ۥ[
   
   if(sum%10 == 0)//�ˬd���G
    return true;
   else
    return false;
  }

 //���Ƭۥ[
 public static int sumOfEvenPlace(long number)
  {
   int even = 0;

   number/=10;
   while(number!=0)
    {
     int num =(int)(number%10);
     num *= 2;//���Ʀ�ҭ�2

     if(num>=10) //�j��10�ɦU��Ƭۥ[
      num = getDigit(num);
     even += num;
     number /= 100;
    }
   
   return even;
  }

 //���ۥ[
 public static int getDigit(int number)
  {
   int num = number/10 + number%10;
   return num;
  }

 //�_�Ƭۥ[
 public static int sumOfOddPlace(long number)
  {
   int odd = 0;

   while(number!=0)
    {
     int num = (int)(number%10);
     odd += num;
     number /= 100;
    }

   return odd;
  }
}     