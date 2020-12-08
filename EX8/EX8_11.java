//shuffling letters in a string

import java.util.Scanner;

public class EX8_11
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//宣告輸入

   System.out.print("Enter a string: "); //輸入字串
   String s = input.nextLine();   

   System.out.print("The shuffling letter is "+shuffle(s)); //顯示
  }

 public static String shuffle(String s) //shuffle
  {
   StringBuilder newS = new StringBuilder(s); //宣告StringBuilder
   String reS = ""; //回傳字串
   while(newS.length()>0)//字串長度大於0就繼續
    {
     int r = (int)(Math.random()*newS.length());//隨機選擇1個index
     reS += newS.charAt(r);//取出該index字元
     newS.deleteCharAt(r);//刪除該index字元
    }
   
   return reS; //回傳
  }
}