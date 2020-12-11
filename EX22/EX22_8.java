//Revising Listing 22.12, CountOccurenceOfWords.java using arraylist

import java.util.*;

public class EX22_8
{
 public static void main(String args[]) 
  {
   //���դ�r
   String text = "Good morning. Have a good class. "+
                 "Have a good visit. Have fun!";
   
   //map
   Map<String, Integer> map = new HashMap<String, Integer>();
   
   String[] words = text.split("[ \n\t\r.,;:!?(){}]"); //�h���Ÿ�

   //�N��r�P�X�{�W�v���Jmap
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
  
   Set<Map.Entry<String,Integer>> entrySet = map.entrySet(); //����set

   ArrayList<WordOccurence> list = new ArrayList<WordOccurence>();

   //�[�Jlist���H�K�Ƨ�
   for(Map.Entry<String,Integer> entry: entrySet)
    list.add(new WordOccurence(entry.getKey(),entry.getValue()));
   Collections.sort(list);

   //���
   for(WordOccurence entry: list)
    System.out.println(entry.toString());
  }
}

//�Ƨǥ�class
class WordOccurence implements Comparable
{
 String word; //�r
 int count;    //����

 //�غc�l
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

 //��@���
 public int compareTo(Object o)
  {
   if(count>((WordOccurence)o).count)
    return 1;
   else if(count < ((WordOccurence)o).count)
    return -1;
   else
    return 0;
  }

 //���
 public String toString()
  {
   return count+"  "+word;
  }
}
      
