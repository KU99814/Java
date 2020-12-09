//output a string with diffierent type

import java.io.*;

public class EX19_3
{
 public static void main(String args[]) throws IOException
  {
   String greeting = "La Fheile Padraig Sona Daoibh"; //定義字串

   System.out.println(greeting);//系統上顯示
   
   System.out.println(greeting.length());//顯示長度

   //檔案輸出
   DataOutputStream output = new DataOutputStream(new FileOutputStream("EX19.3(d).dat"));
   
   output.writeUTF(greeting);//檔案輸出字串

   output = new DataOutputStream(new FileOutputStream("EX19.3(e).dat"));//重新宣告輸出檔案

   output.writeChars(greeting);//以字元輸出字串

   output.close();
  }
}