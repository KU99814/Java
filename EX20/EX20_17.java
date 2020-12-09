//Occurrences of a specified character in an array

import java.util.Scanner;

public class EX20_17
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//宣告輸入

   System.out.print("Enter a string: ");
   String s = input.nextLine();//輸入字串

   char[] chars = new char[s.length()];//宣告字元陣列

   for(int i=0;i<chars.length;i++)//將字串存入陣列
    chars[i] = s.charAt(i);

   System.out.print("Enter the char you want to find: ");
   char c = input.nextLine().charAt(0);//輸入選擇字元

   System.out.print("The character number in the string is: " + count(chars,c));//顯示結果
  }

 //遞迴從字元陣列中找出特定字的數量
 public static int count(char[] chars,char ch)
  {
   return count(chars,ch,chars.length-1);
  }

 //recursive helper method
 public static int count(char[] chars,char ch,int high)
  {
   int num = 0;
   if(ch-chars[high]==0)//判斷是否相同
    num++;
   if(high==0)//base case
    return num;
   else //遞迴
    return num+count(chars,ch,high-1);
  }
}