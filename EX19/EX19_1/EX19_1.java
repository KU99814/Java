//creaing a text file

import java.io.*;

public class EX19_1
{
 public static void main(String args[]) throws IOException
  {
   PrintWriter output = new PrintWriter("Exercise19_1.txt");//檔案輸出 text I/O

   for(int i=0;i<100;i++)//輸出100個int
    {
     int num = (int)(Math.random()*100);//隨機
     output.print(num+"");//輸入
     output.print(" "); //空格隔開
    }

   output.close();//關閉檔案
  }
}
   