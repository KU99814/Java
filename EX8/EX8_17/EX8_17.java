//Counting number of word in a text file(.java)

import java.util.Scanner;
public class EX8_17
{
 public static void main(String args[]) throws Exception
  {
   java.io.File file = new java.io.File(args[0]); //檔案路徑
   Scanner input = new Scanner(file); //宣告輸入

   int ch = 0; //字元數
   int word = 0; //單字數
   int line = 0; //句子數

   String s1 = ""; //文本字串

   //開始讀取
   while(input.hasNext())
    {
     s1 += input.nextLine()+" "; //逐行讀取並計算行數
     line++;
    }
   String[] token = s1.split(" "); //以空格分隔陣列並計算單字數
   word = token.length;

   for(int i=0;i<token.length;i++)//計算每一單字的字數
    ch += token[i].length();

   //顯示
   System.out.println("The file "+file.getName() +" has ");
   System.out.println(ch+" characters");
   System.out.println(word+" words");
   System.out.print(line+" lines");
  }
}     