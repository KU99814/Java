//binary to decimal

import java.util.Scanner;

public class EX18_9
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//宣告輸入

   System.out.print("Enter a Binary number: "); //輸入一16進位數
   String bin = input.nextLine();
   
   System.out.print("the decimal are "+parseBinary(bin)); //顯示十進位數
  }

 public static int parseBinary(String binaryString) //16進位轉十進位
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
      throw new BinaryFormatException();//超過範圍throw
     num += n*Math.pow(2,(binaryString.length()-1-i));//按位數乘以2的n次方
    }
   return num;
  }
}

//自製exception
class BinaryFormatException extends NumberFormatException
{
 public BinaryFormatException()
  {
   super();
  }
}