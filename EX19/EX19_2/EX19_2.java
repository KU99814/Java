//Creating a binary data file

import java.io.*;

public class EX19_2
{
 public static void main(String args[]) throws IOException
  {
   File f = new File("Exercise19_2.dat");//宣告檔案

   if(f.exists()) //判斷是否存在0
    System.out.println("The file is exist!");
  
   else
   {
    FileOutputStream file = new FileOutputStream(f);//宣告檔案輸出 binary I/O
    for(int i=0;i<100;i++) //輸出整數
     {
      int num = (int)(Math.random()*100);
      file.write(num);
     }
    System.out.println("The file is created!");//顯示已完成
    file.close();//關閉檔案
   }
  }
}
   