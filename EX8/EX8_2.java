//check substring use own indexOf function

import java.util.Scanner;

public class EX8_2
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //�ŧi��J
   
   System.out.print("Enter first string: "); //��J�r��1
   String s1 = input.nextLine();

   System.out.print("Enter second string: "); //��J�r��2
   String s2 = input.nextLine();

   if(newIndexOf(s1,s2) == -1) //�˴�1�O�_�O2��substring
    System.out.print("The first string is not substring");
   else
    System.out.print("The first string is second string's substring");
  }

 public static int newIndexOf(String s1,String s2)
  {
   //��Ӧr�����
   int s1len = s1.length();
   int s2len = s2.length();

   if(s1len>s2len) //�p�G�r��1��r��2�u �^�ǿ��~
    return -1;

   char c1 = s1.charAt(0);//����P�r��2�}�Y�ۦP���r 
   for(int i=0;i+s1len-1<s2len;i++)//�q�Y�}�l�� �Y���פ����Y���X
    {
     if(s2.charAt(i)==c1)//���ᱵ�U�Ө̧ǹ��
      {
       boolean isSubstring = true;
     
       for(int j=0;j<s1len;j++)
        { 
         if(s2.charAt(i+j)!=s1.charAt(j)) //�p�G�������Ť]���X
          {
           isSubstring = false;
           break;
          }
        }
       
       if(isSubstring)//�۲Ū��ܦ^�Ƕ}�lindex
        return i;
      }
    }

   return -1; //���S���^��-1
  }
}      