//Decimal to binary

import java.util.Scanner;

public class EX20_21
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J

   System.out.print("Enter a Decimal number: ");
   int num = input.nextInt();//��J�Ʀr

   System.out.print("The Binary number is "+convertDecimalToBinary(num));//�ର�G�i��
  }

 //���j�ର�G�i��
 public static String convertDecimalToBinary(int value)
  {
   if(value<2)//base case
    return value+"";
   else//���j ���j��k��e
    {
     return convertDecimalToBinary(value/2) + value%2;
    }
  }
}