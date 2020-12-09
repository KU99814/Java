//Hex to decimal

import java.util.Scanner;

public class EX20_24
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J

   System.out.print("Enter a hex number: ");
   String num = input.nextLine();//��J�Q���i��

   System.out.print("The decimal number is "+parseHex(num));//��ܤQ�i��
  }

 //�Q���i����Q�i�� ���j
 public static int parseHex(String hexString)
  {
   return parseHex(hexString,hexString.length()-1,0);
  }

 //helper method
 public static int parseHex(String hexString,int square,int position)
  {
   int num = 0;//�^�Ǽ�
   
   char c = hexString.charAt(position);//���Ĥ@�Ӧr�@�ഫ
   //�]���Q�H�W�O�r�� �G���ഫ
   if(c >= 'A')
    num = c -'A'+10;
   else
    num = c -'0';

   position++;//�b�o��+1 ����index error
   if(square==0) //base case
    {
      return num;
    }
   else//���j
    {
     return (int)(Math.pow(16,square)*num) + parseHex(hexString,square-1,position);
    }
  }
}