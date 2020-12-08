//Counting scores in a text file

import java.util.Scanner;

public class EX8_19
{
 public static void main(String args[]) throws Exception
  {
   java.io.File file = new java.io.File(args[0]);  //�bcmd��J�ɦW

   Scanner input = new Scanner(file); //�ŧi��J

   //�j�p�g�r���Ӽ�
   int[] upper = new int[26]; 
   int[] lower = new int[26];
   
   while(input.hasNext()) //����ɮפ�r
    {
     String s = input.next();//Ū���@�Ӧr
     
     for(int i=0;i<s.length();i++)
      {
       //����r�� �Ϥ��j�p�g
       char c = s.charAt(i);
       if(Character.isUpperCase(c))
        {
         int j = c -'A';
         upper[j]++;
        }
       else
        {
         int j = c -'a';
         lower[j]++;
        }
      }
    }     
   for(int i=0;i<26;i++) //��X�j�p�g��r��
    {
     System.out.print((char)('A'+i)+ " "+upper[i]+" ");
     System.out.println((char)('a'+i)+" "+lower[i]); 
    }
  }
}