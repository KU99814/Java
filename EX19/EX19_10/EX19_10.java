//��J: java EX19_10 sourceFile numberOfPiece\
//�����ɮ�

import java.io.*;

public class EX19_10
{
 public static void main(String args[]) throws IOException
  {
   RandomAccessFile raf = new RandomAccessFile(args[0],"rw");//Ū���ɮ�

   int silde = Integer.parseInt(args[1])-1;//���Υ���

   long size = raf.length()/silde;//���Ϋ����

   if(raf.length()%silde == 0)
    size = raf.length()/(silde+1); //�������ת��B�m
   
   int count = 1;//�p�Ƥ��F�X��
   while(true)
    {
     RandomAccessFile out = new RandomAccessFile(args[0]+"."+count,"rw");//�x�s���Ϊ��ɮ�
     if(raf.length() - raf.getFilePointer()<=size)//�p�G���פj����Ϊ��� �����פ���
      {
       for(long i= raf.getFilePointer();i<raf.length();i++)
        {
         out.write(raf.read());
        }
       out.close();
       break;
      }
     else//�p����Ϊ��� 
      {
       for(long i=0;i<size;i++)
        {
         out.write(raf.read());
        }
       if(count==Integer.parseInt(args[1]))
        {
         for(long i=raf.getFilePointer();i<raf.length();i++)
          {
           out.write(raf.read());
          }
         break;
        }
       out.close();
       if(raf.length() - raf.getFilePointer()==0)
        break;
      }
     count++;
    }
   raf.close();
  }
} 
     