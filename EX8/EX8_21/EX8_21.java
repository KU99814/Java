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
   while(input.hasNext()) //將不是args[0]的文字重新輸入
    {
     String s2 = input.nextLine();
     
     s1 += s2.replaceAll(args[0],"")+"\n";//將指定字用""取代掉
    }

   //輸出檔案
   PrintWriter output = new PrintWriter(file);
   
   output.print(s1);
   
   output.close();
  }
}