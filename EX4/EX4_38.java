//Decimal to Hex

import java.util.Scanner;

public class EX4_38
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //�ŧi��J
   
   System.out.print("Enter a number: ");
   int num = input.nextInt(); //��J�n�ഫ����
   
   String s = "";
  
   System.out.print("The number of binary is: ");
   
   //�ഫ16�i��
   while(true)
    {
     //�P�G�i�� �N�l�Ʃ�e
     int d = num % 16;

     //�j��10���ƭn�ഫ���r��
     if(d >= 10)
      s = (char)('A'+(d-10)) + s;
     else
      s = d + s;
    
     if(num < 16)
      break;
     num = (int)(num/16);
    }
   System.out.print(s);
  }
}