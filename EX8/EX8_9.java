//Decimal to octal

import java.util.Scanner;

public class EX8_9
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J

   System.out.print("Enter a decimal number: ");//��J�Q�i���
   int num = input.nextInt();

   System.out.print("The octal number are "+convertDecimalToOctal(num)); //��ܤK�i��
  }

 public static String convertDecimalToOctal(int value) // �Q�i����K�i��
  {
   StringBuilder s = new StringBuilder();

   while(value > 1) //�ΰ��k�D
    {
     int num = value%8;
     s.append(num);
     value /= 8;
    }

   if(value > 0) //�h�s �H�K�e�����s
    s.append(value);
   
   s.reverse(); //����L�Ӥ~�O����
   return s.toString();
  }
}