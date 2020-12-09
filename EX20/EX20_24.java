//Hex to decimal

import java.util.Scanner;

public class EX20_24
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//宣告輸入

   System.out.print("Enter a hex number: ");
   String num = input.nextLine();//輸入十六進位

   System.out.print("The decimal number is "+parseHex(num));//顯示十進位
  }

 //十六進位轉十進位 遞迴
 public static int parseHex(String hexString)
  {
   return parseHex(hexString,hexString.length()-1,0);
  }

 //helper method
 public static int parseHex(String hexString,int square,int position)
  {
   int num = 0;//回傳數
   
   char c = hexString.charAt(position);//取第一個字作轉換
   //因為十以上是字母 故先轉換
   if(c >= 'A')
    num = c -'A'+10;
   else
    num = c -'0';

   position++;//在這裡+1 防止index error
   if(square==0) //base case
    {
      return num;
    }
   else//遞迴
    {
     return (int)(Math.pow(16,square)*num) + parseHex(hexString,square-1,position);
    }
  }
}