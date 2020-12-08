//Decimal to binary

import java.util.Scanner;

public class EX8_10
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //宣告輸入

   System.out.print("Enter a decimal number: ");//輸入十進位數
   int num = input.nextInt();

   System.out.print("The octal number are "+convertDecimalToBinary(num)); //顯示二進位
  }

 public static String convertDecimalToBinary(int value) // 十進位轉二進位
  {
   StringBuilder s = new StringBuilder();

   while(value > 1) //用除法求
    {
     int num = value%2;
     s.append(num);
     value /= 2;
    }

   if(value > 0) //去零 以免前面有零
    s.append(value);
   
   s.reverse(); //反轉過來才是正解
   return s.toString();
  }
}