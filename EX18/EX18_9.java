//binary to decimal

import java.util.Scanner;

public class EX18_9
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J

   System.out.print("Enter a Binary number: "); //��J�@16�i���
   String bin = input.nextLine();
   
   System.out.print("the decimal are "+parseBinary(bin)); //��ܤQ�i���
  }

 public static int parseBinary(String binaryString) //16�i����Q�i��
  {
   int num = 0;

   for(int i=0;i<binaryString.length();i++)
    {
     char c = binaryString.charAt(i);
     int n = 0;

     if(c == '0')
      n = 0;
     else if(c == '1')
      n = 1;
     else
      throw new BinaryFormatException();//�W�L�d��throw
     num += n*Math.pow(2,(binaryString.length()-1-i));//����ƭ��H2��n����
    }
   return num;
  }
}

//�ۻsexception
class BinaryFormatException extends NumberFormatException
{
 public BinaryFormatException()
  {
   super();
  }
}