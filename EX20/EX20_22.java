//Decimal to hex

import java.util.Scanner;

public class EX20_22
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//宣告輸入

   System.out.print("Enter a Decimal number: ");
   int num = input.nextInt();//輸入數字

   System.out.print("The hex number is "+convertDecimalToHex(num));//十進位轉十六進位
  }

 //遞迴方法轉十六進位
 public static String convertDecimalToHex(int value)
  {
   int mod = value%16;//取餘數
   if(value<16)//base case
    {
     //以十為分界 決定是數字或字母
     if(mod>=10)
      return String.valueOf((char)('A'+(mod-10)));
     else
      return value+"";
    }
   else//遞迴
    {
     //以十為分界 決定是數字或字母
     if(mod>=10)
      return convertDecimalToHex(value/16) + String.valueOf((char)('A'+(mod-10)));
     else
      return convertDecimalToHex(value/16) + value%16;
    }
  }
}