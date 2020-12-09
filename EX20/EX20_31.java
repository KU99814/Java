//replaceing words

import java.io.*;
import java.util.Scanner;

public class EX20_31
{
 public static void main(String args[]) throws IOException
  {
   try{
    getFileWord(new File(args[0]),args[1],args[2]);//命令列輸入檔案名與關鍵字
   }
   catch(Exception ex){
    System.out.println("java EX20_30 dirName word");//顯示輸入方法
   }
  }

 //尋找並取代檔案內關鍵字
 public static void getFileWord(File file,String oldWord,String word) throws IOException
  {
   if(file.isDirectory())//如果是資料夾
    {     
     File[] files = file.listFiles();//宣告名下檔案陣列
     for(int i=0;i<files.length;i++)
      getFileWord(files[i],oldWord,word);//遞迴
    }
   else//如果是檔案
    {
     try{
      Scanner input = new Scanner(file);//宣告檔案輸入
      
      boolean isReplace = false;//判斷是否可取代
      while(input.hasNext())
       {
        if(isReplace)
         break;
        String line = input.nextLine();//輸入字串
        for(int i=0;i+oldWord.length()-1<line.length();i++)
         {
          String sub = line.substring(i,i+oldWord.length()-1);//擷取與關鍵字相同長度字串
          if(sub.equals(oldWord))//判斷是否相等
           {
            isReplace = true;
            break;
           }
         }
       }
      if(isReplace)//如果可取代
       {
        String out = "";
        while(input.hasNext())
         {
          String line = input.nextLine();
          out += line.replaceAll(oldWord,word)+"\n";//取代該字
         }
        PrintWriter output = new PrintWriter(file.getPath());//輸出檔案
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