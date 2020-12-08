//Funancial: credit card number validation

import java.util.Scanner;

public class EX8_30
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J

   System.out.print("Enter your credit card number: ");//��J�d��
   String number = input.next();

   System.out.print("This number is "+isValid(number));//����
  }

 //�ˬd�H�Υd�O�_�X�k
 public static boolean isValid(String number)
  {
   //�ˬd�}�Y
   char head = number.charAt(0);
   System.out.println(head);
   if(head != '4' && head!='5' && head !='6' 
       &&!number.substring(0,2).equals("37"))
     return false;

   int sum = sumOfEvenPlace(number) + sumOfOddPlace(number);//�i��B��
   //�B���ˬd�O�_�X�k
   if(sum%10 == 0)
    return true;
   else
    return false;
  }

 //����Ƭۥ[
 public static int sumOfEvenPlace(String number)
  {
   int even = 0;
   int count = number.length()-1;

   count--;//�q�Q��ƶ}�l �G����@
   while(count >= 0)
    {
     int num =Integer.parseInt(String.valueOf(number.charAt(count))); //�ରint
     num *= 2;

     //�B��
     if(num>=10)
      num = getDigit(num);
     even += num;
     count -= 2;
    }
   
   return even;
  }

 //���ۥ[
 public static int getDigit(int number)
  {
   int num = number/10 + number%10;
   return num;
  }

 //�_��Ƭۥ[
 public static int sumOfOddPlace(String number)
  {
   int odd = 0;
   int count = number.length()-1;

   while(count >= 0)
    {
     int num = Integer.parseInt(String.valueOf(number.charAt(count)));//���o�Ʀr
     odd += num;
     count -= 2;
    }

   return odd;
  }
}     