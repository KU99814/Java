//Occurrences of a specified character in a string

import java.util.Scanner;

public class EX20_15
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J

   System.out.print("Enter a string: ");
   String s = input.nextLine();//��J�r��

   System.out.print("Enter the char you want to find: ");
   char c = input.nextLine().charAt(0);//��J��ܦr��

   System.out.print("The character number in the string is: " + count(s,c));//��X�r���ƶq
  }

 //���j��X�r����
 public static int count(String s,char a)
  {
   return count(s,a,s.length()-1);
  }

 //recursive Helper mathod
 public static int count(String s,char a,int high)
  {
   int num = 0;
   if(a-s.charAt(high)==0)//�P�_
    num++;
   if(high==0)//base case
    return num;
   else//���j
    return num+count(s,a,high-1);
  }
}