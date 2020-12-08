//Counting scores in a text file

import java.util.Scanner;

public class EX8_19
{
 public static void main(String args[]) throws Exception
  {
   java.io.File file = new java.io.File(args[0]);  //在cmd輸入檔名

   Scanner input = new Scanner(file); //宣告輸入

   //大小寫字母個數
   int[] upper = new int[26]; 
   int[] lower = new int[26];
   
   while(input.hasNext()) //比較檔案文字
    {
     String s = input.next();//讀取一個字
     
     for(int i=0;i<s.length();i++)
      {
       //比較字母 區分大小寫
       char c = s.charAt(i);
       if(Character.isUpperCase(c))
        {
         int j = c -'A';
         upper[j]++;
        }
       else
        {
         int j = c -'a';
         lower[j]++;
        }
      }
    }     
   for(int i=0;i<26;i++) //輸出大小寫文字數
    {
     System.out.print((char)('A'+i)+ " "+upper[i]+" ");
     System.out.println((char)('a'+i)+" "+lower[i]); 
    }
  }
}