//輸入兩字元 顯示之間的字元

import java.util.Scanner;

public class EX5_12
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //宣告輸入
   
   System.out.print("Enter first char: "); //輸入第一個字元
   String c1 = input.next();
   char ch1 = c1.charAt(0);   //轉換
 
   System.out.print("Enter second char: "); //輸入第二個字元
   String c2 = input.next();
   char ch2 = c2.charAt(0);  //轉換
 
   printChars(ch1,ch2,10);  //輸出
  }
 
 //依序輸出字元的method
 public static void printChars(char ch1,char ch2,int numberPerLine)
  {
   int c1 = (int)ch1;  //先把字元轉換成數字
   int c2 = (int)ch2;
   int count = 1;  //換行
   
   for(int i = c1;i<=c2;i++) //從C1到C2依序輸出
    {
     if(count%numberPerLine==0)
      System.out.println((char)(i));
     else
      System.out.print((char)(i));
     count++;
    }
  }
}