//Decrypting files by adding 5 to every byte

import java.io.*;
import java.util.Scanner;

public class EX19_14
{
 public static void main(String args[]) throws IOException
  {
   Scanner input = new Scanner(System.in);//�ŧi��J

   System.out.print("Enter the input file name: ");
   String in = input.nextLine();//��JŪ���ɮצW��

   System.out.print("Enter the output encrypting file name: ");
   String out = input.nextLine();//��J��X�ɮצW��

   //�ɮ׿�X�J�ŧi
   RandomAccessFile inFile = new RandomAccessFile(in,"rw");
   RandomAccessFile outFile = new RandomAccessFile(out,"rw");

   //�N��J�ɮת��C�Ӹ��+5���X
   for(int i=0;i<inFile.length();i++)
    {
     outFile.write(inFile.read()+5);
    }
   
   //�ɮ�����
   inFile.close();
   outFile.close();

   System.out.print("Encrypting over");//��������X
  }
}