//Occurrences of a specified chaeacter

import java.util.Scanner;

public class EX8_4
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //�ŧi��J

   System.out.print("Enter a string: "); //��J�r��
   String s = input.nextLine();

   System.out.print("Enter a char: ");//��J�Q�䪺�r
   String sc = input.next();
   
   char c = sc.charAt(0);

   System.out.print("The char's occurence: "+count(s,c)); //�^�Ǧ���
  }

 public static int count(String str,char a) //�p��X�{�W�v
  {
   int c = 0;

   for(int i = 0;i<str.length();i++)//�̧ǴM�� ���p��+1
    {
     if(str.charAt(i)==a)
      c++;
    }
   return c;
  }
}