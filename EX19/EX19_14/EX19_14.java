//Decrypting files by adding 5 to every byte

import java.io.*;
import java.util.Scanner;

public class EX19_14
{
 public static void main(String args[]) throws IOException
  {
   Scanner input = new Scanner(System.in);//宣告輸入

   System.out.print("Enter the input file name: ");
   String in = input.nextLine();//輸入讀取檔案名稱

   System.out.print("Enter the output encrypting file name: ");
   String out = input.nextLine();//輸入輸出檔案名稱

   //檔案輸出入宣告
   RandomAccessFile inFile = new RandomAccessFile(in,"rw");
   RandomAccessFile outFile = new RandomAccessFile(out,"rw");

   //將輸入檔案的每個資料+5後輸出
   for(int i=0;i<inFile.length();i++)
    {
     outFile.write(inFile.read()+5);
    }
   
   //檔案關閉
   inFile.close();
   outFile.close();

   System.out.print("Encrypting over");//結束的輸出
  }
}