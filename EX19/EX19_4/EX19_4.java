//Processing text file

import java.io.*;

public class EX19_4
{
 public static void main(String args[]) throws IOException
  {
   DataInputStream input = new DataInputStream(new FileInputStream("pet.txt"));//Ū���ɮ�

   //��X�������
   while(input.available() != 0)
    {
     //��Xbyte �ର16�i��
     System.out.print(Integer.toHexString(input.readByte())+" ");
    }

   input.close();//�ɮ�����
  }
}