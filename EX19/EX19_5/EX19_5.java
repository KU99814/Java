//Storing objects and arrays into a file

import java.io.*;
import java.util.Date;

public class EX19_5
{
 public static void main(String args[]) throws IOException
  {
   //�ŧi�n�x�s�����
   int[] a = {1,2,3,4,5};
   Date d = new Date();
   double value = 5.5;

   //�ɮ׿�X �i�����x�s
   ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("EX19_5.dat"));
   
   //�}�C�̧��x�s
   for(int i=0;i<a.length;i++)
    output.writeInt(a[i]);
   output.writeObject(d);//�x�s���
   output.writeDouble(value);//�x�sdouble
   
   output.close();//�����ɮ�
  }
}