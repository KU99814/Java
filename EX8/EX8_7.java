//octal to decimal

import java.util.Scanner;

public class EX8_7
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J	

   System.out.print("Enter a octal number: "); //��J�@8�i���
   String octal = input.nextLine();
   
   System.out.print("the decimal are "+parseOctal(octal)); //��ܤQ�i���
  }

 public static int parseOctal(String octalString) //8�i����Q�i��
  {
   int octal = Integer.parseInt(octalString);//�N�r���ର�Ʀr
   int time = 1;//8������ �q0����=1�}�l�v�B*8
   int num = 0; //�^�Ǽ�

   while(octal != 0)
    {
     num += (octal%10)*time; //�q�̥k��̦����^�Q�i��

     octal /= 10;
     time *= 8;
    }

   return num;
  }
}