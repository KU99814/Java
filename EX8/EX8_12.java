//Anagrams

import java.util.Scanner;

public class EX8_12
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//宣告輸入

   System.out.print("Enter first word: "); //輸入第一個字
   String s1 = input.nextLine();

   System.out.print("Enter second word: "); //輸入第二個字
   String s2 = input.nextLine();

   System.out.print("The two word is Anagrams? "+isAnagrams(s1,s2)); //顯示結果
  }

 public static boolean isAnagrams(String s1,String s2) //比較
  {
   //將兩字串宣告為stringbuilder
   StringBuilder S1 = new StringBuilder(s1);
   StringBuilder S2 = new StringBuilder(s2); 

   if(s1.length() != s2.length()) //如果長度不同 直接false
    return false;

   //連續執行直到全部檢驗完成
   while(S1.length()>0)
   {
    String s = S1.substring(0,1);//將第1個字取出
    int index = S2.indexOf(s);//找出在字串2的index
    if(index<0)//若找不到 直接回傳false
     return false;
    //將該字元刪除
    S1.deleteCharAt(0);
    S2.deleteCharAt(index);
   }
   
   return true;//驗證完回傳true
  }
}