//�P22.8 ��X�C�Ӧr���Ҧb��� �u�O���J��file �H�Ψϥ�Map<String,List<Integer>>

import java.util.*;
import java.io.*;

public class EX22_9
{
 public static void main(String args[]) throws Exception
  {
   File file = new File(args[0]); //�q�D���x(cmd)��J�ɦW

   Scanner input = new Scanner(file);//��J�ɮ�


   Map<String,List<Integer>> map = new TreeMap<String,List<Integer>>();//�ŧimap

   for(int line=1;input.hasNext();line++)//�]���n�O���X�{���
    {
     String s = input.nextLine();//��J��r
     
     String[] words = s.split("[ ]"); //�h���ť�
     
     for(int i=0;i<words.length;i++)
      {
       String key = words[i].toLowerCase();
     
       if(map.get(key)==null)//�p�G�S���O���L �[�J
        {
         ArrayList<Integer> list = new ArrayList<Integer>();
         list.add(line);
         map.put(key,list);
        }
       else //�p�G������ �ˬd��O�_����
        {
         if(((List)(map.get(key))).indexOf(line)<0)
          ((List)(map.get(key))).add(line);
        }
      }
    }
   
   Set<Map.Entry<String,List<Integer>>> entrySet = map.entrySet(); //����set

   ArrayList<WordOccurence> list = new ArrayList<WordOccurence>();

   //�[�Jlist���H�K�Ƨ�
   for(Map.Entry<String,List<Integer>> entry: entrySet)
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
 List<Integer> line;    //����

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

 //��@���
 public int compareTo(Object o)
  {
   return word.compareTo(((WordOccurence)o).word);
  }

 //���
 public String toString()
  {
   return word+"  "+line.toString();
  }
}