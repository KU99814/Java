//Decimal to hex

import java.util.Scanner;

public class EX20_22
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J

   System.out.print("Enter a Decimal number: ");
   int num = input.nextInt();//��J�Ʀr

   System.out.print("The hex number is "+convertDecimalToHex(num));//�Q�i����Q���i��
  }

 //���j��k��Q���i��
 public static String convertDecimalToHex(int value)
  {
   int mod = value%16;//���l��
   if(value<16)//base case
    {
     //�H�Q������ �M�w�O�Ʀr�Φr��
     if(mod>=10)
      return String.valueOf((char)('A'+(mod-10)));
     else
      return value+"";
    }
   else//���j
    {
     //�H�Q������ �M�w�O�Ʀr�Φr��
     if(mod>=10)
      return convertDecimalToHex(value/16) + String.valueOf((char)('A'+(mod-10)));
     else
      return convertDecimalToHex(value/16) + value%16;
    }
  }
}