//output a string with diffierent type

import java.io.*;

public class EX19_3
{
 public static void main(String args[]) throws IOException
  {
   String greeting = "La Fheile Padraig Sona Daoibh"; //�w�q�r��

   System.out.println(greeting);//�t�ΤW���
   
   System.out.println(greeting.length());//��ܪ���

   //�ɮ׿�X
   DataOutputStream output = new DataOutputStream(new FileOutputStream("EX19.3(d).dat"));
   
   output.writeUTF(greeting);//�ɮ׿�X�r��

   output = new DataOutputStream(new FileOutputStream("EX19.3(e).dat"));//���s�ŧi��X�ɮ�

   output.writeChars(greeting);//�H�r����X�r��

   output.close();
  }
}