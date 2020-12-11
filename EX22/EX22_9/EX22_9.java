//同22.8 找出每個字的所在行數 只是把輸入換file 以及使用Map<String,List<Integer>>

import java.util.*;
import java.io.*;

public class EX22_9
{
 public static void main(String args[]) throws Exception
  {
   File file = new File(args[0]); //從主控台(cmd)輸入檔名

   Scanner input = new Scanner(file);//輸入檔案


   Map<String,List<Integer>> map = new TreeMap<String,List<Integer>>();//宣告map

   for(int line=1;input.hasNext();line++)//因為要記錄出現行數
    {
     String s = input.nextLine();//輸入文字
     
     String[] words = s.split("[ ]"); //去除空白
     
     for(int i=0;i<words.length;i++)
      {
       String key = words[i].toLowerCase();
     
       if(map.get(key)==null)//如果沒有記錄過 加入
        {
         ArrayList<Integer> list = new ArrayList<Integer>();
         list.add(line);
         map.put(key,list);
        }
       else //如果有紀錄 檢查行是否重複
        {
         if(((List)(map.get(key))).indexOf(line)<0)
          ((List)(map.get(key))).add(line);
        }
      }
    }
   
   Set<Map.Entry<String,List<Integer>>> entrySet = map.entrySet(); //換成set

   ArrayList<WordOccurence> list = new ArrayList<WordOccurence>();

   //加入list中以便排序
   for(Map.Entry<String,List<Integer>> entry: entrySet)
    list.add(new WordOccurence(entry.getKey(),entry.getValue()));
   Collections.sort(list);

   //顯示
   for(WordOccurence entry: list)
    System.out.println(entry.toString());
  }
}

//排序用class
class WordOccurence implements Comparable
{
 String word; //字
 List<Integer> line;    //次數

 public WordOccurence()
  {
   word = "a";
   List<Integer> list = new ArrayList<Integer>();
  }

 public WordOccurence(String word,List<Integer> line)
  {
   this.word = word;
   this.line = line;
  }

 //實作比較
 public int compareTo(Object o)
  {
   return word.compareTo(((WordOccurence)o).word);
  }

 //顯示
 public String toString()
  {
   return word+"  "+line.toString();
  }
}