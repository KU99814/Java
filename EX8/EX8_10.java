//Decimal to binary

import java.util.Scanner;

public class EX8_10
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //�ŧi��J

   System.out.print("Enter a decimal number: ");//��J�Q�i���
   int num = input.nextInt();

   System.out.print("The octal number are "+convertDecimalToBinary(num)); //��ܤG�i��
  }

 public static String convertDecimalToBinary(int value) // �Q�i����G�i��
  {
   StringBuilder s = new StringBuilder();

   while(value > 1) //�ΰ��k�D
    {
     int num = value%2;
     s.append(num);
     value /= 2;
    }

   if(value > 0) //�h�s �H�K�e�����s
    s.append(value);
   
   s.reverse(); //����L�Ӥ~�O����
   return s.toString();
  }
}