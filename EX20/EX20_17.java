//Occurrences of a specified character in an array

import java.util.Scanner;

public class EX20_17
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J

   System.out.print("Enter a string: ");
   String s = input.nextLine();//��J�r��

   char[] chars = new char[s.length()];//�ŧi�r���}�C

   for(int i=0;i<chars.length;i++)//�N�r��s�J�}�C
    chars[i] = s.charAt(i);

   System.out.print("Enter the char you want to find: ");
   char c = input.nextLine().charAt(0);//��J��ܦr��

   System.out.print("The character number in the string is: " + count(chars,c));//��ܵ��G
  }

 //���j�q�r���}�C����X�S�w�r���ƶq
 public static int count(char[] chars,char ch)
  {
   return count(chars,ch,chars.length-1);
  }

 //recursive helper method
 public static int count(char[] chars,char ch,int high)
  {
   int num = 0;
   if(ch-chars[high]==0)//�P�_�O�_�ۦP
    num++;
   if(high==0)//base case
    return num;
   else //���j
    return num+count(chars,ch,high-1);
  }
}