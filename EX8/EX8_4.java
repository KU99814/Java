//Occurrences of a specified chaeacter

import java.util.Scanner;

public class EX8_4
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //宣告輸入

   System.out.print("Enter a string: "); //輸入字串
   String s = input.nextLine();

   System.out.print("Enter a char: ");//輸入想找的字
   String sc = input.next();
   
   char c = sc.charAt(0);

   System.out.print("The char's occurence: "+count(s,c)); //回傳次數
  }

 public static int count(String str,char a) //計算出現頻率
  {
   int c = 0;

   for(int i = 0;i<str.length();i++)//依序尋找 找到計數+1
    {
     if(str.charAt(i)==a)
      c++;
    }
   return c;
  }
}