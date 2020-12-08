//十進位轉十六進位

import java.util.Scanner;

public class EX5_13
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //宣告輸入
 
   System.out.print("Enter a decimal integer: "); //輸入十進位數
   int decimal = input.nextInt();

   System.out.print("It's Hexadecimal integer is "+toHexadecimal(decimal)); //輸出十六進位
  }

 //十進位轉十六進位的method
 public static String toHexadecimal(int decimal)
  {
   String H = "";  //輸出字串
   
   while(true)
    {
     int num = decimal%16;//得出餘數後加到字串首
     if(num>=10)
      H = (char)('A'+(num-10))+H;
     else
      H = num+H;
     
     decimal/=16;
     if(decimal==0)
      break;
    }       
   return H;
  }
}
     
      