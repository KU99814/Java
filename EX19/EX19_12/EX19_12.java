//combining files
//��J�Gjava EX19_12 �ɮפ@ �ɮפG ..... �ؼ���

import java.io.*;

public class EX19_12
{
 public static void main(String args[]) throws IOException
  {
   RandomAccessFile raf = new RandomAccessFile(args[args.length-1],"rw");

   //�̧�Ū�������� �N�ƾڦs��P�@�ɤ�
   for(int i=0;i<args.length-1;i++)
    {
     RandomAccessFile in = new RandomAccessFile(args[i],"rw"); 
     
     for(long j=0;j<=in.length();j++)
      {
       raf.write(in.read());
      }
     in.close();
    }

   System.out.println("Combining is over");
  }
}