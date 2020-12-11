//counting the keywords in java source code
//java EX22_3 sourceFile

import java.util.*;
import java.io.*;

public class EX22_3
{
 public static void main(String args[]) throws Exception
  {
   File file = new File(args[0]);//宣告檔案
   
   Scanner input = new Scanner(file);//宣告檔案輸入
  
   Set<String> set1 = new HashSet<String>();//宣告set

   //輸入keyword
   set1.add("abstract");
   set1.add("continue");
   set1.add("for");
   set1.add("new");
   set1.add("switch");
   set1.add("assert");
   set1.add("default");
   set1.add("goto");
   set1.add("package");
   set1.add("synchronized");
   set1.add("boolean");
   set1.add("do");
   set1.add("if");
   set1.add("private");
   set1.add("this");
   set1.add("break");
   set1.add("double");
   set1.add("implements");
   set1.add("protected");
   set1.add("throw");
   set1.add("byte");
   set1.add("else");
   set1.add("import");
   set1.add("public");
   set1.add("throws");
   set1.add("case");
   set1.add("enum");
   set1.add("instanceof");
   set1.add("return");
   set1.add("transient");
   set1.add("catch");
   set1.add("extends");
   set1.add("int");
   set1.add("short");
   set1.add("try");
   set1.add("char");
   set1.add("final");
   set1.add("interface");
   set1.add("static");
   set1.add("void");
   set1.add("class");
   set1.add("finally");
   set1.add("long");
   set1.add("strictfp");
   set1.add("volatile");
   set1.add("const");
   set1.add("float");
   set1.add("native");
   set1.add("super");
   set1.add("while");
   

   int count = 0;//計算出現次數
   while (input.hasNext())//檢查是否包含
    {
     if(set1.contains(input.next()))
      count++; 
    }
   
   System.out.print(count);//顯示次數
  }
}
