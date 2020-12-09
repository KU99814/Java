//Processing text file

import java.io.*;

public class EX19_4
{
 public static void main(String args[]) throws IOException
  {
   DataInputStream input = new DataInputStream(new FileInputStream("pet.txt"));//讀取檔案

   //輸出內部資料
   while(input.available() != 0)
    {
     //輸出byte 轉為16進位
     System.out.print(Integer.toHexString(input.readByte())+" ");
    }

   input.close();//檔案關閉
  }
}