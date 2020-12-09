//輸入: java EX19_10 sourceFile numberOfPiece\
//分割檔案

import java.io.*;

public class EX19_10
{
 public static void main(String args[]) throws IOException
  {
   RandomAccessFile raf = new RandomAccessFile(args[0],"rw");//讀取檔案

   int silde = Integer.parseInt(args[1])-1;//分割份數

   long size = raf.length()/silde;//分割後長度

   if(raf.length()%silde == 0)
    size = raf.length()/(silde+1); //不滿長度的處置
   
   int count = 1;//計數分了幾分
   while(true)
    {
     RandomAccessFile out = new RandomAccessFile(args[0]+"."+count,"rw");//儲存分割的檔案
     if(raf.length() - raf.getFilePointer()<=size)//如果長度大於分割長度 按長度分割
      {
       for(long i= raf.getFilePointer();i<raf.length();i++)
        {
         out.write(raf.read());
        }
       out.close();
       break;
      }
     else//小於分割長度 
      {
       for(long i=0;i<size;i++)
        {
         out.write(raf.read());
        }
       if(count==Integer.parseInt(args[1]))
        {
         for(long i=raf.getFilePointer();i<raf.length();i++)
          {
           out.write(raf.read());
          }
         break;
        }
       out.close();
       if(raf.length() - raf.getFilePointer()==0)
        break;
      }
     count++;
    }
   raf.close();
  }
} 
     