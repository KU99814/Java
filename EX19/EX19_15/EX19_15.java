//Encrypting files by adding 5 to every byte

import java.io.*;
import java.util.Scanner;

public class EX19_15
{
 public static void main(String args[]) throws IOException
  {
   Scanner input = new Scanner(System.in);//宣告輸入

   System.out.print("Enter the input file name: ");
   String in = input.nextLine();//輸入讀取檔案

   System.out.print("Enter the output decrypting file name: ");
   String out = input.nextLine();//輸入輸出檔案

   //宣告檔案讀取與輸入
   RandomAccessFile inFile = new RandomAccessFile(in,"rw");
   RandomAccessFile outFile = new RandomAccessFile(out,"rw");

   //將每個資料-5來解碼
   for(int i=0;i<inFile.length();i++)
    {
     outFile.write(inFile.read()-5);
    }

   //關閉檔案   
   inFile.close();
   outFile.close();

   //輸出結束
   System.out.print("Decrypting over");
  }
}