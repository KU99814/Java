//Counting digits in a string

import java.util.Scanner;

public class EX8_5
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //�ŧi��J

   System.out.print("Enter a string: "); //��J�r��
   String s = input.nextLine();
   
   boolean digit = (countDigits(s)>1);//�P�_�O�_�j��1 �M�w�O�_�_�ƫ�
   String ss =digit ? "s":"";
   System.out.print("The string has "+countDigits(s)+" digit" + ss); //�^�Ǧ��X�ӼƦr
  }
  
 public static int countDigits(String s) //�p�⦳�X�ӼƦr
  {
   int count = 0; //�^�ǭ�

   for(int i = 0;i<s.length();i++)//�v�r�ˬd
    {
     if(s.charAt(i) >= '0' && s.charAt(i) <= '9')
      count++;
    }
   
   return count; //�^��
  }
}

 