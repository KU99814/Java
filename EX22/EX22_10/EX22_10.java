//syntax highlighting
//有不完美的地方 省略後接引號會判斷錯誤

import java.util.*;
import java.io.*;

public class EX22_10
{
 public static void main(String args[]) throws Exception
  {
   //java 的keyword
   String[] keyWord = {"abstract","continue","for","new","switch","assert","default",
                       "goto","package","synchronized","boolean","do","if","private",
                       "this","break","double","implements","protected","throw","byte",
                       "else","import","public","throws","case","enum","instanceof",
                       "return","transient","catch","extends","int","short","try","char",
                       "final","interface","static","void","class","finally","long",
                       "strictfp","volatile","const","float","native","super","while"};

   //輸入set中方便找出
   Set<String> set1 = new HashSet<String>();

   for(int i=0 ;i<keyWord.length;i++)
    set1.add(keyWord[i]);

   File fileIn = new File(args[0]);

   Scanner input = new Scanner(fileIn);

   String html = ""; //輸出得html文字

   html += "<html>\r\n";
   html += "<head>\r\n";
   html += "<title></title>\r\n";
   html += "<meta http-equiv=\"Content-Type\" content=\"text/html;"+
           " charset=windows-1252\">\r\n";
   html += "<style type = \"text/css\">\r\n";
   html += "body {font-family: \"Courier New\","+
           " sans-serif; font-size: 100%; color: black}\r\n";

   html += ".keyword {color: #000080; font-weight: bold}\r\n";
   html += ".comment {color: #008000}\r\n";
   html += ".literal {color: #0000ff}\r\n";
   html += "</style>\r\n";

   html += "</head>\r\n";
   html += "<body>\r\n";
   html += "<pre>\r\n";


   String text = "";

   //將檔案文字輸入String中方便辨識
   while (input.hasNext())
    {
     text += input.nextLine() + "\r\n";
    }
   //將comment轉換以便辨識
   text = text.replaceAll("// ", "LINECOMMENT"); 
   text = text.replaceAll("/\\*", "BLOCKCOMMENT");

   //html中<>是要用特殊字元來顯示的
   text = text.replaceAll(">", "&gt;");
   text = text.replaceAll("<", "&lt;");

   boolean stringToken = false; //辨別是否字串中的字

   while(text != null && text.length()>0)
    {
     //將檢查的字用以下字元分開
     String[] word = text.split("[%\\+\\-\\*/\r\n\t \\[\\].;(){},]",2); 
       
     if(word[0].length()>1 && word[0].startsWith("LINECOMMENT")) //若是單行省略
      {
       html += "<span class = \"comment\">";
       word = text.split("\r\n", 2);
       html += word[0].replaceAll("LINECOMMENT", "// ");
       html += "</span>\r\n";
       text = word[1];
       continue;
      }
     else if(word[0].length()>1 && word[0].startsWith("BLOCKCOMMENT"))//若是區塊省略
      {
       html += "<span class = \"comment\">";
       word = text.split("\\*/",2);
       text = word[1];
       html +=  word[0].replaceAll("/*", "BLOCKCOMMENT") + "*/";
       html += "</span>";
       continue;
      }
     else if(word[0].length() > 1 && word[0].matches("'\\w'*")) //遇到數字的場合
      {
       html += "<span class = \"literal\">";
       html += word[0];
       html += "</span>";
      }

     //遇到""的字串時的判斷
     else if(word[0].startsWith("\"") && word[0].endsWith("\"") &&
             (word[0].length() > 1)) //引號緊連字串的狀況
      html += "<span class = \"literal\">" + word[0] + "</span>";
     else if(word[0].startsWith("\"") && word[0].endsWith("\"") &&
               (word[0].length() == 1)) //只有引號的狀況
      {
       if(stringToken)
        {
         html += word[0] + "</span>";
         stringToken = false;
        }
       else
        {
         html += "<span class = \"literal\">" + word[0];
         stringToken = true;
        }
      }
     else if(word[0].startsWith("\""))
      {
       html += "<span class = \"literal\">" + word[0];
       stringToken = true;
      }
     else if(word[0].endsWith("\"") && (!word[0].endsWith("\\\"")))
      {
       html += word[0];
       html += "</span>";
       stringToken = false;
      }
     else if(word[0].matches("\\d*"))// Check if numeric
      html += "<span class = \"literal\">" + word[0] + "</span>";
     else if(!stringToken && set1.contains(word[0]))
      html += "<span class = \"keyword\">" + word[0] +"</span>";
     else
      html += word[0];
      
     if(word[0].length() < text.length())
      {
       if(text.charAt(word[0].length()) == '<')
        html += "&lt;";
       else if(text.charAt(word[0].length()) == '>')
        html += "&gt;";
       else
        html += text.charAt(word[0].length()); //補回被省略的字
      }
     
     if(word.length == 2) //接下一個
      text = word[1];
    }

   html += "</pre>\r\n";
   html += "</body>\r\n";
   html += "</html>\r\n";

   PrintWriter output = new PrintWriter(new File(args[1])); //輸出

   output.print(html);
    //131561651
   input.close();
   output.close(); 
  }
}