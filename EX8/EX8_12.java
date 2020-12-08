//Anagrams

import java.util.Scanner;

public class EX8_12
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J

   System.out.print("Enter first word: "); //��J�Ĥ@�Ӧr
   String s1 = input.nextLine();

   System.out.print("Enter second word: "); //��J�ĤG�Ӧr
   String s2 = input.nextLine();

   System.out.print("The two word is Anagrams? "+isAnagrams(s1,s2)); //��ܵ��G
  }

 public static boolean isAnagrams(String s1,String s2) //���
  {
   //�N��r��ŧi��stringbuilder
   StringBuilder S1 = new StringBuilder(s1);
   StringBuilder S2 = new StringBuilder(s2); 

   if(s1.length() != s2.length()) //�p�G���פ��P ����false
    return false;

   //�s����檽��������秹��
   while(S1.length()>0)
   {
    String s = S1.substring(0,1);//�N��1�Ӧr���X
    int index = S2.indexOf(s);//��X�b�r��2��index
    if(index<0)//�Y�䤣�� �����^��false
     return false;
    //�N�Ӧr���R��
    S1.deleteCharAt(0);
    S2.deleteCharAt(index);
   }
   
   return true;//���ҧ��^��true
  }
}