//Replace text 

import java.util.*;
import java.io.*;

public class EX8_20
{
 public static void main(String args[]) throws Exception
  {
   if(args.length != 3) //�p�G��J�榡���~
    {
     System.out.println("Usage: java ReplaceText source targetFile oldStr newStr");
     System.exit(0);
    }
   
   File file = new File(args[0]); //�qcmd�o����|
   if(!file.exists()) //�p�G��J�榡���~
    {
     System.out.println("file not exist");
     System.exit(0);
    }
   Scanner input = new Scanner(file); //�ŧi��J

   StringBuilder s1 = new StringBuilder();
   
   while(input.hasNext()) //����ɤ���r
    {
     String s2 = input.nextLine();
     String S3 = s2.replaceAll(args[1],args[2]);
     System.out.println(S3);
     s1.append(S3+"\n"); //�N�ɤ�args[1]��r����args[2]��r
    }

   PrintWriter output = new PrintWriter(new File(args[0])); 

  //���s��X   
   output.print(s1.toString());
  
   input.close();
   output.close();
  }
}