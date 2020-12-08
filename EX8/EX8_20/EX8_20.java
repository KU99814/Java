//Replace text 

import java.util.*;
import java.io.*;

public class EX8_20
{
 public static void main(String args[]) throws Exception
  {
   if(args.length != 3) //如果輸入格式錯誤
    {
     System.out.println("Usage: java ReplaceText source targetFile oldStr newStr");
     System.exit(0);
    }
   
   File file = new File(args[0]); //從cmd得到路徑
   if(!file.exists()) //如果輸入格式錯誤
    {
     System.out.println("file not exist");
     System.exit(0);
    }
   Scanner input = new Scanner(file); //宣告輸入

   StringBuilder s1 = new StringBuilder();
   
   while(input.hasNext()) //比較檔內文字
    {
     String s2 = input.nextLine();
     String S3 = s2.replaceAll(args[1],args[2]);
     System.out.println(S3);
     s1.append(S3+"\n"); //將檔內args[1]文字換為args[2]文字
    }

   PrintWriter output = new PrintWriter(new File(args[0])); 

  //重新輸出   
   output.print(s1.toString());
  
   input.close();
   output.close();
  }
}