//Hex to decimal

import java.util.Scanner;

public class EX18_6
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//宣告輸入

   System.out.print("Enter a Hex number: "); //輸入一16進位數
   String hex = input.nextLine();
   
   System.out.print("the decimal are "+parseHex(hex)); //顯示十進位數
  }

 public static int parseHex(String hexString) throws NumberFormatException //16進位轉十進位
  {
   int num = 0;

   for(int i=0;i<hexString.length();i++)
    {
     char c = hexString.charAt(i);
     int n = 0;

     //將字母轉為數字
     if(c>='A' && c<='F')
      n = (int)(c - 'A')+10;
     else if(c>='0' && c<='9')
      n = Integer.parseInt(String.valueOf(c));
     else
      throw new NumberFormatException();//格式錯誤throw
     num += n*Math.pow(16,(hexString.length()-1-i));//按位數乘16的n次方
    }
   return num;
  }
}