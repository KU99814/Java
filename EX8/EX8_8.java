//Binary to decimal

import java.util.Scanner;

public class EX8_8
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//宣告輸入

   System.out.print("Enter a Binary number: "); //輸入二進位數
   String binaryNum = input.nextLine();
 
   System.out.print("The binary to decimal are "+parseBinary(binaryNum)); //顯示
  }

 public static int parseBinary(String binaryString) //二進位轉十進位
  {
   int binary = Integer.parseInt(binaryString);//將字串轉為數字 因為沒有字母直接轉即可
   int time = 1; //從2的零次方=1開始依序乘2
   int num = 0; //回傳數

   while(binary != 0)
    {
     num += (binary%10)*time;//從低位依序乘2的n次方

     binary /= 10;
     time *= 2;
    }

   return num; //回傳
  }
}