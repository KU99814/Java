//REstoring objects form

import java.io.*;

public class EX19_7
{
 public static void main(String args[]) throws Exception
  {
   Loan[] l = new Loan[200];//�ŧi�ɶU�}�C

   //��object
   for(int i=0;i<l.length;i++)
    l[i] = new Loan();

   //�ɮ׿�X ����
   ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("EX19_7.dat"));

   //��X�ɮ�
   for(int i=0;i<l.length;i++)
    output.writeObject(l[i]);

   output.close();//�ɮ�����

   //�ɮ׿�J ����
   ObjectInputStream input = new ObjectInputStream(new FileInputStream("EX19_7.dat"));

   //����Ӽ�
   int count = 0;

   try//�ҥ~�B�z
    {
     //�s�Xobject
     while(true)
      {
       input.readObject();//Ū���ɮ�
       count++;
      }
    }
   //�W�X�ɸ��X
   catch(EOFException ex)
    {
     System.out.print("The number of Loan is "+count);//���Ū��
    }
  }
}