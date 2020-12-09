//Encrypting files by adding 5 to every byte

import java.io.*;
import java.util.Scanner;

public class EX19_15
{
 public static void main(String args[]) throws IOException
  {
   Scanner input = new Scanner(System.in);//�ŧi��J

   System.out.print("Enter the input file name: ");
   String in = input.nextLine();//��JŪ���ɮ�

   System.out.print("Enter the output decrypting file name: ");
   String out = input.nextLine();//��J��X�ɮ�

   //�ŧi�ɮ�Ū���P��J
   RandomAccessFile inFile = new RandomAccessFile(in,"rw");
   RandomAccessFile outFile = new RandomAccessFile(out,"rw");

   //�N�C�Ӹ��-5�ӸѽX
   for(int i=0;i<inFile.length();i++)
    {
     outFile.write(inFile.read()-5);
    }

   //�����ɮ�   
   inFile.close();
   outFile.close();

   //��X����
   System.out.print("Decrypting over");
  }
}