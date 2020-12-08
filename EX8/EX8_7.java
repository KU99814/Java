//octal to decimal

import java.util.Scanner;

public class EX8_7
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//宣告輸入	

   System.out.print("Enter a octal number: "); //輸入一8進位數
   String octal = input.nextLine();
   
   System.out.print("the decimal are "+parseOctal(octal)); //顯示十進位數
  }

 public static int parseOctal(String octalString) //8進位轉十進位
  {
   int octal = Integer.parseInt(octalString);//將字串轉為數字
   int time = 1;//8的次方 從0次方=1開始逐步*8
   int num = 0; //回傳數

   while(octal != 0)
    {
     num += (octal%10)*time; //從最右邊依位數轉回十進位

     octal /= 10;
     time *= 8;
    }

   return num;
  }
}