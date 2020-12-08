//十進位轉二進位

import java.util.Scanner;

public class EX5_11
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //宣告輸入

   System.out.print("Enter an integer: ");   //輸入十進位數
   int decimal = input.nextInt();

   System.out.print("It's Binary number is:"+toBinary(decimal));  //顯示二進位數
  }

 //十進制轉二進制的method
 public static String toBinary(int decimal)
  {
   String binary = ""; //回傳的字串

   while(true)//運算
    {
     binary = (decimal%2)+binary; //將餘數加到字首
     if(decimal==1 || decimal == 0)
      break;
     decimal/=2; //除以2
    }
   return binary;
  }
}
 