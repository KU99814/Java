//Binary to decimal

import java.util.Scanner;

public class EX20_23
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J

   System.out.print("Enter a Binary number: ");
   String num = input.nextLine();//��J�G�i���

   System.out.print("The decimal number is "+parseBinary(num));//��ܤQ�i��
  }

 //���j �G�i����Q�i��
 public static int parseBinary(String binaryString)
  {
   return parseBinary(binaryString,binaryString.length()-1,0);
  }

 //helper method
 public static int parseBinary(String binaryString,int square,int position)
  {
   int num = binaryString.charAt(position) - '0';//���̫e�����Ʀr
   position++;//��m���e
   if(square==0) //base case
    {
     return num;
    }
   else//���j
    {
     return (int)(Math.pow(2,square)*num) + parseBinary(binaryString,square-1,position);
    }
  }
}