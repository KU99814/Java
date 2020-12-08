//chack Palindrome

import java.util.Scanner;

public class EX8_1
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //宣告輸入

   System.out.print("Enter a string: "); //輸入字串
   String s = input.nextLine();

   String reverseS = reverse(s); //顛倒

   if(s.equals(reverseS)) //測試是否相同
    System.out.println(s + " is a palindrome");
   else
    System.out.println(s + " is not a palindrome");
  }

 public static String reverse(String s) //顛倒字串
  {
   if(s.length()==0)
    return s;

   int length = s.length() - 1;
   String re = "";

   for(int i = length;i>=0;i--) //從最後一個字加回去
    {
     re += s.charAt(i);     
    }
 
   return re;
  }
}     