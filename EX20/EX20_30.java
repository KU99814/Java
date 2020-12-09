//Finding words

import java.io.*;
import java.util.Scanner;

public class EX20_30
{
 //static int count = 0;
 public static void main(String args[]) throws IOException
  {
   try{
    //命令列輸入檔名與關鍵字
    System.out.println("The occurrence is "+getFileWord(new File(args[0]),args[1])); 
   }
   catch(Exception ex){
    System.out.println("java EX20_30 dirName word");
   }
  }

 //取得關鍵字頻率
 public static long getFileWord(File file,String word) throws IOException
  {
   long count = 0;//紀錄出現數

   if(file.isDirectory())//如果是資料夾
    {     
     File[] files = file.listFiles();//宣告名下檔案陣列
     for(int i=0;i<files.length;i++)
      count += getFileWord(files[i],word);//遞迴計算
    }
   else//如果是檔案
    {
     try{
      Scanner input = new Scanner(file);//宣告讀取檔案
      while(input.hasNext())//迴圈到讀完為止
       {
        String line = input.nextLine();//輸入檔案字串
        for(int i=0;i+word.length()-1<line.length();i++)
         {
          String sub = line.substring(i,i+word.length());
          if(sub.equals(word))
           count++;
          }
        }
     }
     catch(Exception ex){
      ex.printStackTrace();
     }
    } 
   return count;
  }
} 