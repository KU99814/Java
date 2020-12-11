//Revising Listing 22.12, CountOccurenceOfWords.java using arraylist

import java.util.*;

public class EX22_8
{
 public static void main(String args[]) 
  {
   //測試文字
   String text = "Good morning. Have a good class. "+
                 "Have a good visit. Have fun!";
   
   //map
   Map<String, Integer> map = new HashMap<String, Integer>();
   
   String[] words = text.split("[ \n\t\r.,;:!?(){}]"); //去除符號

   //將文字與出現頻率插入map
   for(int i=0;i<words.length;i++)
    {
     String key = words[i].toLowerCase();
     
     if(map.get(key)==null)
      map.put(key,1);
     else
      {
       int value = map.get(key).intValue();
       value++;
       map.put(key,value);
      }
    }
  
   Set<Map.Entry<String,Integer>> entrySet = map.entrySet(); //換成set

   ArrayList<WordOccurence> list = new ArrayList<WordOccurence>();

   //加入list中以便排序
   for(Map.Entry<String,Integer> entry: entrySet)
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
 int count;    //次數

 //建構子
 public WordOccurence()
  {
   word = "a";
   count = 0;
  }

 public WordOccurence(String word,int count)
  {
   this.word = word;
   this.count = count;
  }

 //實作比較
 public int compareTo(Object o)
  {
   if(count>((WordOccurence)o).count)
    return 1;
   else if(count < ((WordOccurence)o).count)
    return -1;
   else
    return 0;
  }

 //顯示
 public String toString()
  {
   return count+"  "+word;
  }
}
      
