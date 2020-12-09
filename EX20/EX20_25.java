//display subset

import java.util.Scanner;

public class EX20_25
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//宣告輸入
   
   System.out.print("Enter a number n: ");
   int n = input.nextInt();//輸入集合內有幾個數

   System.out.println("The subset of set 1 to "+n+" is: ");//顯示所有子集合
   String[] s = displaySubset(n);//子集合陣列
   for(int i=0;i<s.length;i++)//依陣列顯示子集合
    {
     System.out.print("{");
     System.out.print(s[i]);
     System.out.println("}");
    }
  }

 //遞迴 獲取子集合
 public static String[] displaySubset(int value)
  {
   if(value==1)//base case
    {
     String[] s  = {"1",""};
     return s;
    }
   else
    {
     String[] s1 = displaySubset(value-1); //獲取前一子集
     String[] s2 = new String[s1.length];//這次遞迴獲得的新子集
     for(int i=0;i<s1.length;i++)//將前一子集各加1數即新子集
      {
       if(s1[i].length()<=0)
        s2[i] = value+"";
       else
        s2[i] = s1[i]+","+value;
      }
     String[] rs = new String[s1.length+s2.length];//回傳陣列 長度兩者相加

     //加入新舊兩陣列
     for(int i=0;i<s1.length;i++)
      rs[i] = s1[i];
     for(int i=0;i<s2.length;i++)
      rs[s1.length+i] = s2[i];
 
     //回傳
     return rs;
    }
  }
}