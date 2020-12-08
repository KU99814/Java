//new string split method

import java.util.Scanner;

public class EX8_29
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//宣告輸入

   System.out.print("Enter a string: "); //輸入字串
   String s = input.next();

   System.out.print("Enter a split string: "); //輸入隔開的文字
   String sp = input.next();

   String[] result = split(s,sp); //處理
   for(int i=0;i<result.length;i++) //輸出
    {
     System.out.print(result[i]+" ");
    }
  }

 //分離的method
 public static String[] split(String s,String regex)
  {
   int len = 0;//陣列長度
   boolean between = false;//檢查字元是否連續
   //以分隔字元求出需要陣列長度
   for(int i=0;i<s.length();i++)
    {
     if(regex.indexOf(s.charAt(i))>=0)//
      {
       between = false;//碰到分隔設為false
      }
     else if(regex.indexOf(s.charAt(i))<0 && !between)
      {
       between = true;//碰到字元設為true值 到下一次分隔前都不計數
       len++;
      }
    }
   
   String[] result = new String[len]; //輸出的字串陣列
   
   for(int i=0;i<len;i++)//因為是物件陣列 需要初始化
    result[i] = "";

   int i;
   int j = 0;
   between = false;//這裡用來檢查分隔是否連續
   for(i=0;i<s.length();i++)
    {
     if(regex.indexOf(s.charAt(i))>=0 && between)
      {
       j++;//碰到分隔 到下一個列
       between = false;//直到下次碰到字元前都不移動
      }
     else if(regex.indexOf(s.charAt(i))<0)
      {
       result[j] += s.charAt(i);//加入字元
       between = true;
      }
    }
      
   return result;//回傳
  }
}   