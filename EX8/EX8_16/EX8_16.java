//Reformatting the Java source code
//�ɮפ��঳����

import java.util.*;
import java.io.*;

public class EX8_16
{
 public static void main(String args[]) throws Exception
  {   
   if (args.length != 1) {
      System.out.println(
        "Usage: java Exercise8_16 filename");
      System.exit(0);
    }

    // Check if source file exists
    File sourceFile = new File(args[0]);
    if (!sourceFile.exists()) {
       System.out.println("Source file " + args[0] + " not exist");
       System.exit(0);
    }

  // System.out.println(sourceFile.length());
   Scanner input = new Scanner(sourceFile);//�ŧi��J

  // System.out.println(input.hasNext());

   StringBuilder outputString = new StringBuilder();//�ŧistringbuilder�Ψӿ�X
   
   while(input.hasNext()) //Ū��
    {
     String s = input.nextLine();//Ū���r��
     String s1 = s.trim();//�N�ťլٲ�
     if(s1.equals("{"))//�Y�ٲ���ѤU{
      {
       outputString.insert(outputString.length()-1,s1);//���J�_�椧�e
      }
     else
     {
      outputString.append(s+"\n");//���`��J
     }
    }

  java.io.PrintWriter output = new java.io.PrintWriter("output.java"); //�]�w��X�ɮ�
   
  output.print(outputString.toString());//�N�r���X

   input.close();    //����
   output.close();
  }
}  