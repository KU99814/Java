//Occurrences of a specified character in a string

import java.util.Scanner;

public class EX20_15
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//宣告輸入

   System.out.print("Enter a string: ");
   String s = input.nextLine();//輸入字串

   System.out.print("Enter the char you want to find: ");
   char c = input.nextLine().charAt(0);//輸入選擇字元

   System.out.print("The character number in the string is: " + count(s,c));//找出字元數量
  }

 //遞迴找出字元數
 public static int count(String s,char a)
  {
   return count(s,a,s.length()-1);
  }

 //recursive Helper mathod
 public static int count(String s,char a,int high)
  {
   int num = 0;
   if(a-s.charAt(high)==0)//判斷
    num++;
   if(high==0)//base case
    return num;
   else//遞迴
    return num+count(s,a,high-1);
  }
}