//Updating count

import java.io.*;

public class EX19_8
{
 public static void main(String args[]) throws IOException
  {
   RandomAccessFile inout = new RandomAccessFile("inout.dat","rw");//�ŧi�ɮ�Ū���P�s�J

   int count = 0; //�ɮ׶}�Ҧ���

   //�Ĥ@������ �]0
   if(inout.length() == 0)
    {
     inout.writeInt(1);
     count=1;
    }
   //���O�Ĥ@�� Ū���Ʀr
   else
    {
     count = inout.readInt();
     count++;
    }   
   
   System.out.print("The time of open the file is " +count);

   //���Ц^��Ĥ@��
   inout.seek(0);
   inout.writeInt(count);//�s�J
   inout.close();//�����ɮ�
  }
}
   