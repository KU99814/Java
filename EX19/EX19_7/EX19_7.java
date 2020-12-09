//REstoring objects form

import java.io.*;

public class EX19_7
{
 public static void main(String args[]) throws Exception
  {
   Loan[] l = new Loan[200];//宣告借貸陣列

   //創object
   for(int i=0;i<l.length;i++)
    l[i] = new Loan();

   //檔案輸出 物件
   ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("EX19_7.dat"));

   //輸出檔案
   for(int i=0;i<l.length;i++)
    output.writeObject(l[i]);

   output.close();//檔案關閉

   //檔案輸入 物件
   ObjectInputStream input = new ObjectInputStream(new FileInputStream("EX19_7.dat"));

   //物件個數
   int count = 0;

   try//例外處理
    {
     //叫出object
     while(true)
      {
       input.readObject();//讀取檔案
       count++;
      }
    }
   //超出時跳出
   catch(EOFException ex)
    {
     System.out.print("The number of Loan is "+count);//顯示讀取
    }
  }
}