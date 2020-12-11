//Displaying nonduplicate words in ascending order
//執行時:java EX22_2 sourceFile 

import java.util.*;
import java.io.*;

public class EX22_2
{
 public static void main(String args[]) throws Exception
  {
   File file = new File(args[0]); //宣告檔案
  
   Set<String> set1 = new TreeSet<String>();//宣告tree set 會按大小自動排序

   Scanner input = new Scanner(file);//宣告輸入

   while(input.hasNext())//從檔案輸入
    {
     set1.add(input.next());
    }

   System.out.print(set1);//顯示

   input.close();//關閉檔案
  }
}
   

   