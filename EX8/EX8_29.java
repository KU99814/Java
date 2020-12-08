//new string split method

import java.util.Scanner;

public class EX8_29
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J

   System.out.print("Enter a string: "); //��J�r��
   String s = input.next();

   System.out.print("Enter a split string: "); //��J�j�}����r
   String sp = input.next();

   String[] result = split(s,sp); //�B�z
   for(int i=0;i<result.length;i++) //��X
    {
     System.out.print(result[i]+" ");
    }
  }

 //������method
 public static String[] split(String s,String regex)
  {
   int len = 0;//�}�C����
   boolean between = false;//�ˬd�r���O�_�s��
   //�H���j�r���D�X�ݭn�}�C����
   for(int i=0;i<s.length();i++)
    {
     if(regex.indexOf(s.charAt(i))>=0)//
      {
       between = false;//�I����j�]��false
      }
     else if(regex.indexOf(s.charAt(i))<0 && !between)
      {
       between = true;//�I��r���]��true�� ��U�@�����j�e�����p��
       len++;
      }
    }
   
   String[] result = new String[len]; //��X���r��}�C
   
   for(int i=0;i<len;i++)//�]���O����}�C �ݭn��l��
    result[i] = "";

   int i;
   int j = 0;
   between = false;//�o�̥Ψ��ˬd���j�O�_�s��
   for(i=0;i<s.length();i++)
    {
     if(regex.indexOf(s.charAt(i))>=0 && between)
      {
       j++;//�I����j ��U�@�ӦC
       between = false;//����U���I��r���e��������
      }
     else if(regex.indexOf(s.charAt(i))<0)
      {
       result[j] += s.charAt(i);//�[�J�r��
       between = true;
      }
    }
      
   return result;//�^��
  }
}   