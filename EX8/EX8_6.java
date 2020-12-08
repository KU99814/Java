//Counting the letters in a string

import java.util.Scanner;

public class EX8_6
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//宣告輸入

   System.out.print("Enter a string: "); //輸入字串
   String s = input.nextLine();
 
   System.out.print("The number of letters are "+countLetters(s)); //回傳文字數
  }

 public static int countLetters(String s) //計算文字數
  {
   int count = 0;

   for(int i=0;i<s.length();i++) //逐字檢查 包括大小寫
    {
     if(Character.isLetter(s.charAt(i)))
      count++;
    }
   
   return count;
  }
}   