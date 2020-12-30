//Matching grouping symbols
//引號內的括弧錯誤 雖然沒問題 但這程式會報錯

import java.util.*;
import java.io.*;

public class EX24_6
{
 public static void main(String args[]) throws Exception
  {
   File fileIn = new File(args[0]);//讀取檔案

   Scanner input = new Scanner(fileIn);//宣告檔案輸入

   Stack<Character> operatorUpperStack = new Stack<Character>();//放入括號stack

   boolean isError = false;//判斷是否出錯

   char[] operator = {'{','(','[','}',')',']'};//括號陣列

   //迴圈逐行讀取
   while(input.hasNext())
    {
     String token = input.nextLine();//讀取一行字
     
     //逐字比較
     for(int i=0;i<token.length();i++)
      { 
       int index = -1;//對應的括號的index 括號以外為-1
       for(int j=0;j<operator.length;j++)
        {
         if(token.charAt(i) == operator[j])
          {
           index = j;
           break;
          } 
        }

       if(index<3 && index>=0)//如果是上括號
        operatorUpperStack.push(token.charAt(i));
       else if(index >=3)//如果是下括號
        {
         if(operatorUpperStack.peek().equals(operator[index-3]))//判斷目前頂端 是否對應的上括號
          operatorUpperStack.pop();
         else//若否 顯示錯誤並跳出讀字迴圈
          {
           isError = true;
           break;
          }
        }
      }
     if(isError)//若有錯誤 跳出讀取迴圈
      break;
    }

   if(!operatorUpperStack.isEmpty())//若stack已清空 顯示正確
    {
     System.out.println("This code is illegal");
    }
   else//若否 顯示錯誤
    System.out.println("This code is correct");
  }
}