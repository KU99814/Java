//Maximum consecutive sorted substring
//T(n) = O(n)

import java.util.*;

public class EX23_1
{
 public static void main(String ars[])
  {
   Scanner input = new Scanner(System.in); //��J�ŧi

   System.out.print("Enter a string:");
   String s = input.next();//ex:"abacdefkabfh" 

   String ss = ""+s.charAt(0);//�M��Φr��
   String max = "";//�̤j�r��
   
   for(int i=1;i<s.length();i++)
    {
     char c = s.charAt(i);//�q��r����X�@�r
     //��ss�̫�@�r��j�p
     if(ss.charAt(ss.length()-1)>c)//�Y��o�@�r�j 
      {
       if(max.length()<ss.length())//����ثe�̤j�r�� �Y��� ���N
        max = ss;
       ss = ""+c;//�q�o�@�r�}�l����
      }
     else//�Y����p
      {
       ss+=c;//�[�b�᭱
      }  
    }

   if(max.length()<ss.length())//�j�駹��A����@��
    max = ss;

   System.out.print(max);//���
  }
}