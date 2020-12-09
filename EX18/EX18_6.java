//Hex to decimal

import java.util.Scanner;

public class EX18_6
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J

   System.out.print("Enter a Hex number: "); //��J�@16�i���
   String hex = input.nextLine();
   
   System.out.print("the decimal are "+parseHex(hex)); //��ܤQ�i���
  }

 public static int parseHex(String hexString) throws NumberFormatException //16�i����Q�i��
  {
   int num = 0;

   for(int i=0;i<hexString.length();i++)
    {
     char c = hexString.charAt(i);
     int n = 0;

     //�N�r���ର�Ʀr
     if(c>='A' && c<='F')
      n = (int)(c - 'A')+10;
     else if(c>='0' && c<='9')
      n = Integer.parseInt(String.valueOf(c));
     else
      throw new NumberFormatException();//�榡���~throw
     num += n*Math.pow(16,(hexString.length()-1-i));//����ƭ�16��n����
    }
   return num;
  }
}