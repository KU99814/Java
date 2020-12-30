//Rearranging string

import java.util.Scanner;

public class EX24_9
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//宣告輸入

   java.util.Queue<Character> queueNonLetter = new java.util.LinkedList<Character>();//queue

   //輸入要再排列的字串
   System.out.print("Enter a string:");
   String s1 = input.nextLine();

   StringBuilder s = new StringBuilder(s1);//為方便顯示結果 宣告stringbuilder

   for(int i=0;i<s.length();i++)
    {
     //將非字母的字元加入queue並從string中刪去
     if(!((s.charAt(i)>='a' && s.charAt(i)<='z') ||
        (s.charAt(i)>='A' && s.charAt(i)<='Z')))
      {
       queueNonLetter.offer(s.charAt(i));
       s = s.deleteCharAt(i);
       i--;
      }
    }

   //從queue中取出字元加入倒string尾部
   while(queueNonLetter.size()>0)
    {
     s.append(queueNonLetter.poll());
    }
   System.out.print(s);//顯示
  }
}