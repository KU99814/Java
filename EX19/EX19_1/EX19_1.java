//creaing a text file

import java.io.*;

public class EX19_1
{
 public static void main(String args[]) throws IOException
  {
   PrintWriter output = new PrintWriter("Exercise19_1.txt");//�ɮ׿�X text I/O

   for(int i=0;i<100;i++)//��X100��int
    {
     int num = (int)(Math.random()*100);//�H��
     output.print(num+"");//��J
     output.print(" "); //�Ů�j�}
    }

   output.close();//�����ɮ�
  }
}
   