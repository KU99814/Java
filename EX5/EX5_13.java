//�Q�i����Q���i��

import java.util.Scanner;

public class EX5_13
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //�ŧi��J
 
   System.out.print("Enter a decimal integer: "); //��J�Q�i���
   int decimal = input.nextInt();

   System.out.print("It's Hexadecimal integer is "+toHexadecimal(decimal)); //��X�Q���i��
  }

 //�Q�i����Q���i�쪺method
 public static String toHexadecimal(int decimal)
  {
   String H = "";  //��X�r��
   
   while(true)
    {
     int num = decimal%16;//�o�X�l�ƫ�[��r�ꭺ
     if(num>=10)
      H = (char)('A'+(num-10))+H;
     else
      H = num+H;
     
     decimal/=16;
     if(decimal==0)
      break;
    }       
   return H;
  }
}
     
      