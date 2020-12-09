//Finding the number of uppercase letter in an array

import java.util.Scanner;

public class EX20_16
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//宣告輸入

   System.out.print("Enter a string: ");
   String s = input.nextLine();//輸入字串

   char[] chars = new char[s.length()];//宣告字元陣列

   for(int i=0;i<chars.length;i++)//將字串存入陣列
    chars[i] = s.charAt(i);

   System.out.print("The uppercase number of string is: " + count(chars));//顯示
  }

 //遞迴找出大寫
 public static int count(char[] chars)
  {
   return count(chars,chars.length - 1);
  }

 //rcursive helper method
 public static int count(char[] chars,int high)
  {
   int num = 0;//回傳數

   if(Character.isUpperCase(chars[high]))//判斷大小寫
    num++;
   if(high==0)//回傳數量
    return num;
   else//遞迴
    return num+count(chars,high-1);
  }
}