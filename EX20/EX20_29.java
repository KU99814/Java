//Number of files in a directory

import java.io.*;
import java.util.Scanner;

public class EX20_29
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J
   
   System.out.print("Enter a directory or a file: ");
   String directory = input.nextLine();//��J�ɮ׸��|
   
   System.out.println(getFileNum(new File(directory))+"'s file");//����ɮ׼ƶq
  }

 //���j ���o�ɮ׼ƶq
 public static long getFileNum(File file)
  {
   long count = 0;//�p��
   if(file.isDirectory())//�p�G�O��Ƨ�
    {
     File[] files = file.listFiles();//�W�U�ɮ�
     for(int i=0;i<files.length;i++)
      count +=getFileNum(files[i]);//�̧ǻ��j���o�ɮ׼�
    }
   else //�p�G�O�ɮת����[
    count++;
   return count;//�^��
  }
} 