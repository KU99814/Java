//Common prefix

import java.util.Scanner;

public class EX8_28
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //宣告輸入
   
   System.out.print("Enter first string: ");  //輸入第一個字
   String s1 = input.next();

   System.out.print("Enter second string: "); //輸入第二個字
   String s2 = input.next();
   
   String s = prefix(s1,s2); //比較開頭文字
   //比較結果
   if(s.length() < 1)
    System.out.print("The two string not has commom prefix");
   else
    System.out.print("The common is "+s);
  }

 //找prefix
 public static String prefix(String s1,String s2)
  {
   if(s1.length()==0 || s2.length()==0)//如果其中一個為0 必為空字串
    return "";
   StringBuilder s = new StringBuilder();//宣告stringbuilder儲存字串
   
   for(int i=0;i<s1.length() && i<s2.length();i++)//重頭開始比較
    {
     if(s1.charAt(i)==s2.charAt(i))
      s.append(s1.charAt(i));
     else
      break;
    }

   return s.toString();//回傳
  }
}