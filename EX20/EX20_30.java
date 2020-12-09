//Finding words

import java.io.*;
import java.util.Scanner;

public class EX20_30
{
 //static int count = 0;
 public static void main(String args[]) throws IOException
  {
   try{
    //�R�O�C��J�ɦW�P����r
    System.out.println("The occurrence is "+getFileWord(new File(args[0]),args[1])); 
   }
   catch(Exception ex){
    System.out.println("java EX20_30 dirName word");
   }
  }

 //���o����r�W�v
 public static long getFileWord(File file,String word) throws IOException
  {
   long count = 0;//�����X�{��

   if(file.isDirectory())//�p�G�O��Ƨ�
    {     
     File[] files = file.listFiles();//�ŧi�W�U�ɮװ}�C
     for(int i=0;i<files.length;i++)
      count += getFileWord(files[i],word);//���j�p��
    }
   else//�p�G�O�ɮ�
    {
     try{
      Scanner input = new Scanner(file);//�ŧiŪ���ɮ�
      while(input.hasNext())//�j���Ū������
       {
        String line = input.nextLine();//��J�ɮצr��
        for(int i=0;i+word.length()-1<line.length();i++)
         {
          String sub = line.substring(i,i+word.length());
          if(sub.equals(word))
           count++;
          }
        }
     }
     catch(Exception ex){
      ex.printStackTrace();
     }
    } 
   return count;
  }
} 