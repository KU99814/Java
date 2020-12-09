//Binary to decimal

import java.util.Scanner;

public class EX20_23
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//宣告輸入

   System.out.print("Enter a Binary number: ");
   String num = input.nextLine();//輸入二進位數

   System.out.print("The decimal number is "+parseBinary(num));//顯示十進位
  }

 //遞迴 二進位轉十進位
 public static int parseBinary(String binaryString)
  {
   return parseBinary(binaryString,binaryString.length()-1,0);
  }

 //helper method
 public static int parseBinary(String binaryString,int square,int position)
  {
   int num = binaryString.charAt(position) - '0';//取最前面的數字
   position++;//位置往前
   if(square==0) //base case
    {
     return num;
    }
   else//遞迴
    {
     return (int)(Math.pow(2,square)*num) + parseBinary(binaryString,square-1,position);
    }
  }
}