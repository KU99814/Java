//Finding the number of uppercase letter in an array

import java.util.Scanner;

public class EX20_16
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J

   System.out.print("Enter a string: ");
   String s = input.nextLine();//��J�r��

   char[] chars = new char[s.length()];//�ŧi�r���}�C

   for(int i=0;i<chars.length;i++)//�N�r��s�J�}�C
    chars[i] = s.charAt(i);

   System.out.print("The uppercase number of string is: " + count(chars));//���
  }

 //���j��X�j�g
 public static int count(char[] chars)
  {
   return count(chars,chars.length - 1);
  }

 //rcursive helper method
 public static int count(char[] chars,int high)
  {
   int num = 0;//�^�Ǽ�

   if(Character.isUpperCase(chars[high]))//�P�_�j�p�g
    num++;
   if(high==0)//�^�Ǽƶq
    return num;
   else//���j
    return num+count(chars,high-1);
  }
}