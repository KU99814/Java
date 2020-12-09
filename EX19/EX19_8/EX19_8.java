//Updating count

import java.io.*;

public class EX19_8
{
 public static void main(String args[]) throws IOException
  {
   RandomAccessFile inout = new RandomAccessFile("inout.dat","rw");//宣告檔案讀取與存入

   int count = 0; //檔案開啟次數

   //第一次建檔 設0
   if(inout.length() == 0)
    {
     inout.writeInt(1);
     count=1;
    }
   //不是第一次 讀取數字
   else
    {
     count = inout.readInt();
     count++;
    }   
   
   System.out.print("The time of open the file is " +count);

   //指標回到第一個
   inout.seek(0);
   inout.writeInt(count);//存入
   inout.close();//關閉檔案
  }
}
   