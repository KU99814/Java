//Counting number of word in a text file(.java)

import java.util.Scanner;
public class EX8_17
{
 public static void main(String args[]) throws Exception
  {
   java.io.File file = new java.io.File(args[0]); //�ɮ׸��|
   Scanner input = new Scanner(file); //�ŧi��J

   int ch = 0; //�r����
   int word = 0; //��r��
   int line = 0; //�y�l��

   String s1 = ""; //�奻�r��

   //�}�lŪ��
   while(input.hasNext())
    {
     s1 += input.nextLine()+" "; //�v��Ū���íp����
     line++;
    }
   String[] token = s1.split(" "); //�H�Ů���j�}�C�íp���r��
   word = token.length;

   for(int i=0;i<token.length;i++)//�p��C�@��r���r��
    ch += token[i].length();

   //���
   System.out.println("The file "+file.getName() +" has ");
   System.out.println(ch+" characters");
   System.out.println(word+" words");
   System.out.print(line+" lines");
  }
}     