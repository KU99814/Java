//Nonrecursive directory size

import java.io.*;
import java.util.Scanner;
import java.util.*;

public class EX20_28
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//宣告輸入

   System.out.print("Enter a directory or a file: ");   
   String directory = input.nextLine();//輸入資料夾或檔案名稱

   File file = new File(directory);//宣告file

   System.out.println(getSize(file)+ " bytes"); //顯示長度                  
  }

 //顯示檔案長度 非遞迴
 public static long getSize(File file)
  {
   long size = 0;//檔案長度
   int index = 0;//現在索引
   ArrayList<File> directoryList = new ArrayList<File>();//資料夾

   if(!file.isDirectory())//如果不是資料夾 直接回傳長度
    return file.length();
   else
    {
     directoryList.add(file);//若是 加入list
     
     while(!directoryList.isEmpty())//走訪所有資料夾 直到list成空
      {
       File files = (File)directoryList.remove(0);//資料夾下的資料
       System.out.println(files.getName());//顯示資料夾名
       File[] fileArray = files.listFiles();//取得資料夾中檔案
       for(int i=0;i<fileArray.length;i++)
        {
         //判斷檔案是否資料夾
         if(fileArray[i].isDirectory())//若是 加入list
          directoryList.add(fileArray[i]);
         else//若否 計算檔案容量
          {
           //System.out.println(fileArray[i].getName());
           size += fileArray[i].length();
          }
        }
      }
    }

   return size;//回傳大小
  }
} 

