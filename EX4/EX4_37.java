//Decimal to binary

import java.util.Scanner;

public class EX4_37
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //�ŧi��J
   
   System.out.print("Enter a number: ");
   int num = input.nextInt(); //��J�n�ഫ���Ʀr
   
   String s = "";
  
   System.out.print("The number of binary is: ");

   //�ഫ���G�i��
   while(true)
    {
     //�C����2 �N�l�Ʃ�e�Y
     int d = num % 2;
     s = d + s;    
     if(num == 1 || num == 0)
      break;
     num = (int)(num/2);
    }
   System.out.print(s);
  }
}