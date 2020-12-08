//Decimal to octal

import java.util.Scanner;

public class EX8_9
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//宣告輸入

   System.out.print("Enter a decimal number: ");//輸入十進位數
   int num = input.nextInt();

   System.out.print("The octal number are "+convertDecimalToOctal(num)); //顯示八進位
  }

 public static String convertDecimalToOctal(int value) // 十進位轉八進位
  {
   StringBuilder s = new StringBuilder();

   while(value > 1) //用除法求
    {
     int num = value%8;
     s.append(num);
     value /= 8;
    }

   if(value > 0) //去零 以免前面有零
    s.append(value);
   
   s.reverse(); //反轉過來才是正解
   return s.toString();
  }
}