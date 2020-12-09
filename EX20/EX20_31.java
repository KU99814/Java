//replaceing words

import java.io.*;
import java.util.Scanner;

public class EX20_31
{
 public static void main(String args[]) throws IOException
  {
   try{
    getFileWord(new File(args[0]),args[1],args[2]);//�R�O�C��J�ɮצW�P����r
   }
   catch(Exception ex){
    System.out.println("java EX20_30 dirName word");//��ܿ�J��k
   }
  }

 //�M��è��N�ɮפ�����r
 public static void getFileWord(File file,String oldWord,String word) throws IOException
  {
   if(file.isDirectory())//�p�G�O��Ƨ�
    {     
     File[] files = file.listFiles();//�ŧi�W�U�ɮװ}�C
     for(int i=0;i<files.length;i++)
      getFileWord(files[i],oldWord,word);//���j
    }
   else//�p�G�O�ɮ�
    {
     try{
      Scanner input = new Scanner(file);//�ŧi�ɮ׿�J
      
      boolean isReplace = false;//�P�_�O�_�i���N
      while(input.hasNext())
       {
        if(isReplace)
         break;
        String line = input.nextLine();//��J�r��
        for(int i=0;i+oldWord.length()-1<line.length();i++)
         {
          String sub = line.substring(i,i+oldWord.length()-1);//�^���P����r�ۦP���צr��
          if(sub.equals(oldWord))//�P�_�O�_�۵�
           {
            isReplace = true;
            break;
           }
         }
       }
      if(isReplace)//�p�G�i���N
       {
        String out = "";
        while(input.hasNext())
         {
          String line = input.nextLine();
          out += line.replaceAll(oldWord,word)+"\n";//���N�Ӧr
         }
        PrintWriter output = new PrintWriter(file.getPath());//��X�ɮ�
        output.print(out);
        output.close();
       }
     }
     catch(Exception ex){
      ex.printStackTrace();
     }
    } 
  }
} 