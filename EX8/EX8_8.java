//Binary to decimal

import java.util.Scanner;

public class EX8_8
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J

   System.out.print("Enter a Binary number: "); //��J�G�i���
   String binaryNum = input.nextLine();
 
   System.out.print("The binary to decimal are "+parseBinary(binaryNum)); //���
  }

 public static int parseBinary(String binaryString) //�G�i����Q�i��
  {
   int binary = Integer.parseInt(binaryString);//�N�r���ର�Ʀr �]���S���r��������Y�i
   int time = 1; //�q2���s����=1�}�l�̧ǭ�2
   int num = 0; //�^�Ǽ�

   while(binary != 0)
    {
     num += (binary%10)*time;//�q�C��̧ǭ�2��n����

     binary /= 10;
     time *= 2;
    }

   return num; //�^��
  }
}