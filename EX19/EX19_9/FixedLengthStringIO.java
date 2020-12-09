import java.io.*;

public class FixedLengthStringIO
{
 //Ū���r��
 public static String readFixedLengthString(int size,DataInput in) throws IOException
  {
   char[] chars = new char[size];//�ŧi�r���}�C
   
   //Ū���r��
   for(int i=0;i<size;i++)
    chars[i] = in.readChar();

   //�^�Ǧr��
   return new String(chars);
  }

 //�g�J�r��
 public static void writeFixedLengthString(String s,int size,DataOutput out) throws IOException
  {
   //�ŧi�r���}�C
   char[] chars = new char[size];
   
   //�r���ର�r���}�C
   s.getChars(0,Math.min(s.length(),size),chars,0);

   //�N�S����r���a��]���Ů�
   for(int i=Math.min(s.length(),size);i<chars.length;i++)
    chars[i] = ' ';

   out.writeChars(new String(chars));//�s�J�ɮ�
  }
}