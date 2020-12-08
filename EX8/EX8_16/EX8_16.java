//Reformatting the Java source code
//檔案不能有中文

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
   Scanner input = new Scanner(sourceFile);//宣告輸入

  // System.out.println(input.hasNext());

   StringBuilder outputString = new StringBuilder();//宣告stringbuilder用來輸出
   
   while(input.hasNext()) //讀檔
    {
     String s = input.nextLine();//讀取字串
     String s1 = s.trim();//將空白省略
     if(s1.equals("{"))//若省略後剩下{
      {
       outputString.insert(outputString.length()-1,s1);//插入斷行之前
      }
     else
     {
      outputString.append(s+"\n");//正常輸入
     }
    }

  java.io.PrintWriter output = new java.io.PrintWriter("output.java"); //設定輸出檔案
   
  output.print(outputString.toString());//將字串輸出

   input.close();    //結束
   output.close();
  }
}  