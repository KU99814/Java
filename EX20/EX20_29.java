//Number of files in a directory

import java.io.*;
import java.util.Scanner;

public class EX20_29
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//宣告輸入
   
   System.out.print("Enter a directory or a file: ");
   String directory = input.nextLine();//輸入檔案路徑
   
   System.out.println(getFileNum(new File(directory))+"'s file");//顯示檔案數量
  }

 //遞迴 取得檔案數量
 public static long getFileNum(File file)
  {
   long count = 0;//計數
   if(file.isDirectory())//如果是資料夾
    {
     File[] files = file.listFiles();//名下檔案
     for(int i=0;i<files.length;i++)
      count +=getFileNum(files[i]);//依序遞迴取得檔案數
    }
   else //如果是檔案直接加
    count++;
   return count;//回傳
  }
} 