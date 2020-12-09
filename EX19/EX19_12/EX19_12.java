//combining files
//輸入：java EX19_12 檔案一 檔案二 ..... 目標檔

import java.io.*;

public class EX19_12
{
 public static void main(String args[]) throws IOException
  {
   RandomAccessFile raf = new RandomAccessFile(args[args.length-1],"rw");

   //依序讀取分割檔 將數據存到同一檔中
   for(int i=0;i<args.length-1;i++)
    {
     RandomAccessFile in = new RandomAccessFile(args[i],"rw"); 
     
     for(long j=0;j<=in.length();j++)
      {
       raf.write(in.read());
      }
     in.close();
    }

   System.out.println("Combining is over");
  }
}