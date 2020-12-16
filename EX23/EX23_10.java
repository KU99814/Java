//Last 100 prime number

import java.io.*;
import java.math.*;
import java.util.*;

public class EX23_10
{
 public static void main(String args[]) throws IOException
  {
   RandomAccessFile inout = new RandomAccessFile("EX23_8.dat","rw");//讀取檔案
   
   inout.seek(inout.length()-100*8);//將指針撥回100單位

   int count = 1;//計算數量

   //讀取資料直到100個質數
   while(true)
    {
     //例外
     try{
      long prime = inout.readLong();//讀取

      //顯示     
      if(count%10==0)
        System.out.println(prime+"   ");
       else
        System.out.print(prime+"   ");

     }
     catch(Exception ex){
      break;
     }
     count++;
    }

   inout.close();//關閉檔案
  }
}