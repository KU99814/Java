//Removing text

import java.io.*;
import java.util.*;

public class EX8_21
{
 public static void main(String args[]) throws Exception
  {
   File file = new File(args[1]); //

   Scanner input = new Scanner(file);

   String s1 = "";
   while(input.hasNext()) //�N���Oargs[0]����r���s��J
    {
     String s2 = input.nextLine();
     
     s1 += s2.replaceAll(args[0],"")+"\n";//�N���w�r��""���N��
    }

   //��X�ɮ�
   PrintWriter output = new PrintWriter(file);
   
   output.print(s1);
   
   output.close();
  }
}