//Counting the letters in a string

import java.util.Scanner;

public class EX8_6
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J

   System.out.print("Enter a string: "); //��J�r��
   String s = input.nextLine();
 
   System.out.print("The number of letters are "+countLetters(s)); //�^�Ǥ�r��
  }

 public static int countLetters(String s) //�p���r��
  {
   int count = 0;

   for(int i=0;i<s.length();i++) //�v�r�ˬd �]�A�j�p�g
    {
     if(Character.isLetter(s.charAt(i)))
      count++;
    }
   
   return count;
  }
}   