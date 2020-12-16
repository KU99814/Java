//Maximum sorted subsequence
//T(n) = O(n^2)

import java.util.*;

public class EX23_2
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J

   //��J�r��
   System.out.print("Enter a string:");
   String s = input.next();

   int length = s.length();//�r�����

   List<String> lStr = new ArrayList<String>();//�x�s�Ҧ��l�ǦC

   int max = 0;//�̤j����

   //�j���X�Ҧ��̧Ǥl�r��
   for(int i= 0;i<length;i++)
    {
     char c = s.charAt(i);//���X�@�Ӧr
     for(int j= 0;j<lStr.size();j++)//�̧ǴM�X�l�ǦC
      {
       String as = lStr.get(j);//���X�l�ǦC
       if(as.charAt(as.length()-1)<c) //�Y�ŦX���� �[�J����
        {
         String newS = as + c;
         lStr.add(newS);
         if(newS.length()>max)//�p����׬O�_�̤j
          max = newS.length();
        }
       }
      lStr.add(c+"");//�N�r���[�J���s�ǦC
     }
   
   //���
   for(int i=0;i<lStr.size();i++)
    {
     if(lStr.get(i).length()==max)//��X�̪��ǦC����X
      {
       System.out.println(lStr.get(i));
       break;
      }
    }
  }
}