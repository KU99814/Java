//Nonrecursive directory size

import java.io.*;
import java.util.Scanner;
import java.util.*;

public class EX20_28
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J

   System.out.print("Enter a directory or a file: ");   
   String directory = input.nextLine();//��J��Ƨ����ɮצW��

   File file = new File(directory);//�ŧifile

   System.out.println(getSize(file)+ " bytes"); //��ܪ���                  
  }

 //����ɮת��� �D���j
 public static long getSize(File file)
  {
   long size = 0;//�ɮת���
   int index = 0;//�{�b����
   ArrayList<File> directoryList = new ArrayList<File>();//��Ƨ�

   if(!file.isDirectory())//�p�G���O��Ƨ� �����^�Ǫ���
    return file.length();
   else
    {
     directoryList.add(file);//�Y�O �[�Jlist
     
     while(!directoryList.isEmpty())//���X�Ҧ���Ƨ� ����list����
      {
       File files = (File)directoryList.remove(0);//��Ƨ��U�����
       System.out.println(files.getName());//��ܸ�Ƨ��W
       File[] fileArray = files.listFiles();//���o��Ƨ����ɮ�
       for(int i=0;i<fileArray.length;i++)
        {
         //�P�_�ɮ׬O�_��Ƨ�
         if(fileArray[i].isDirectory())//�Y�O �[�Jlist
          directoryList.add(fileArray[i]);
         else//�Y�_ �p���ɮ׮e�q
          {
           //System.out.println(fileArray[i].getName());
           size += fileArray[i].length();
          }
        }
      }
    }

   return size;//�^�Ǥj�p
  }
} 

