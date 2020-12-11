//syntax highlighting
//�����������a�� �ٲ��ᱵ�޸��|�P�_���~

import java.util.*;
import java.io.*;

public class EX22_10
{
 public static void main(String args[]) throws Exception
  {
   //java ��keyword
   String[] keyWord = {"abstract","continue","for","new","switch","assert","default",
                       "goto","package","synchronized","boolean","do","if","private",
                       "this","break","double","implements","protected","throw","byte",
                       "else","import","public","throws","case","enum","instanceof",
                       "return","transient","catch","extends","int","short","try","char",
                       "final","interface","static","void","class","finally","long",
                       "strictfp","volatile","const","float","native","super","while"};

   //��Jset����K��X
   Set<String> set1 = new HashSet<String>();

   for(int i=0 ;i<keyWord.length;i++)
    set1.add(keyWord[i]);

   File fileIn = new File(args[0]);

   Scanner input = new Scanner(fileIn);

   String html = ""; //��X�ohtml��r

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

   //�N�ɮפ�r��JString����K����
   while (input.hasNext())
    {
     text += input.nextLine() + "\r\n";
    }
   //�Ncomment�ഫ�H�K����
   text = text.replaceAll("// ", "LINECOMMENT"); 
   text = text.replaceAll("/\\*", "BLOCKCOMMENT");

   //html��<>�O�n�ίS��r������ܪ�
   text = text.replaceAll(">", "&gt;");
   text = text.replaceAll("<", "&lt;");

   boolean stringToken = false; //��O�O�_�r�ꤤ���r

   while(text != null && text.length()>0)
    {
     //�N�ˬd���r�ΥH�U�r�����}
     String[] word = text.split("[%\\+\\-\\*/\r\n\t \\[\\].;(){},]",2); 
       
     if(word[0].length()>1 && word[0].startsWith("LINECOMMENT")) //�Y�O���ٲ�
      {
       html += "<span class = \"comment\">";
       word = text.split("\r\n", 2);
       html += word[0].replaceAll("LINECOMMENT", "// ");
       html += "</span>\r\n";
       text = word[1];
       continue;
      }
     else if(word[0].length()>1 && word[0].startsWith("BLOCKCOMMENT"))//�Y�O�϶��ٲ�
      {
       html += "<span class = \"comment\">";
       word = text.split("\\*/",2);
       text = word[1];
       html +=  word[0].replaceAll("/*", "BLOCKCOMMENT") + "*/";
       html += "</span>";
       continue;
      }
     else if(word[0].length() > 1 && word[0].matches("'\\w'*")) //�J��Ʀr�����X
      {
       html += "<span class = \"literal\">";
       html += word[0];
       html += "</span>";
      }

     //�J��""���r��ɪ��P�_
     else if(word[0].startsWith("\"") && word[0].endsWith("\"") &&
             (word[0].length() > 1)) //�޸���s�r�ꪺ���p
      html += "<span class = \"literal\">" + word[0] + "</span>";
     else if(word[0].startsWith("\"") && word[0].endsWith("\"") &&
               (word[0].length() == 1)) //�u���޸������p
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
        html += text.charAt(word[0].length()); //�ɦ^�Q�ٲ����r
      }
     
     if(word.length == 2) //���U�@��
      text = word[1];
    }

   html += "</pre>\r\n";
   html += "</body>\r\n";
   html += "</html>\r\n";

   PrintWriter output = new PrintWriter(new File(args[1])); //��X

   output.print(html);
    //131561651
   input.close();
   output.close(); 
  }
}