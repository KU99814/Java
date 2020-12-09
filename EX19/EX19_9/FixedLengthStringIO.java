import java.io.*;

public class FixedLengthStringIO
{
 //讀取字串
 public static String readFixedLengthString(int size,DataInput in) throws IOException
  {
   char[] chars = new char[size];//宣告字元陣列
   
   //讀取字元
   for(int i=0;i<size;i++)
    chars[i] = in.readChar();

   //回傳字串
   return new String(chars);
  }

 //寫入字串
 public static void writeFixedLengthString(String s,int size,DataOutput out) throws IOException
  {
   //宣告字元陣列
   char[] chars = new char[size];
   
   //字串轉為字元陣列
   s.getChars(0,Math.min(s.length(),size),chars,0);

   //將沒有文字的地方設為空格
   for(int i=Math.min(s.length(),size);i<chars.length;i++)
    chars[i] = ' ';

   out.writeChars(new String(chars));//存入檔案
  }
}