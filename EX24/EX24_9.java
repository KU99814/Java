//Rearranging string

import java.util.Scanner;

public class EX24_9
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J

   java.util.Queue<Character> queueNonLetter = new java.util.LinkedList<Character>();//queue

   //��J�n�A�ƦC���r��
   System.out.print("Enter a string:");
   String s1 = input.nextLine();

   StringBuilder s = new StringBuilder(s1);//����K��ܵ��G �ŧistringbuilder

   for(int i=0;i<s.length();i++)
    {
     //�N�D�r�����r���[�Jqueue�ñqstring���R�h
     if(!((s.charAt(i)>='a' && s.charAt(i)<='z') ||
        (s.charAt(i)>='A' && s.charAt(i)<='Z')))
      {
       queueNonLetter.offer(s.charAt(i));
       s = s.deleteCharAt(i);
       i--;
      }
    }

   //�qqueue�����X�r���[�J��string����
   while(queueNonLetter.size()>0)
    {
     s.append(queueNonLetter.poll());
    }
   System.out.print(s);//���
  }
}