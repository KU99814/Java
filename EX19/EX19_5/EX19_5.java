//Storing objects and arrays into a file

import java.io.*;
import java.util.Date;

public class EX19_5
{
 public static void main(String args[]) throws IOException
  {
   //宣告要儲存的資料
   int[] a = {1,2,3,4,5};
   Date d = new Date();
   double value = 5.5;

   //檔案輸出 可物件儲存
   ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("EX19_5.dat"));
   
   //陣列依序儲存
   for(int i=0;i<a.length;i++)
    output.writeInt(a[i]);
   output.writeObject(d);//儲存日期
   output.writeDouble(value);//儲存double
   
   output.close();//關閉檔案
  }
}