//Creating a binary data file

import java.io.*;

public class EX19_2
{
 public static void main(String args[]) throws IOException
  {
   File f = new File("Exercise19_2.dat");//�ŧi�ɮ�

   if(f.exists()) //�P�_�O�_�s�b0
    System.out.println("The file is exist!");
  
   else
   {
    FileOutputStream file = new FileOutputStream(f);//�ŧi�ɮ׿�X binary I/O
    for(int i=0;i<100;i++) //��X���
     {
      int num = (int)(Math.random()*100);
      file.write(num);
     }
    System.out.println("The file is created!");//��ܤw����
    file.close();//�����ɮ�
   }
  }
}
   