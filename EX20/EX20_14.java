//Finding the number of uppercase letter in a string

import java.util.Scanner;

public class EX20_14
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J

   System.out.print("Enter a string: ");
   String s = input.nextLine();//��J�r��

   System.out.print("The uppercase number of string is: " + numberOfUpp(s));//��ܵ��G
  }

 //���j��X�j�g�ƶq
 public static int numberOfUpp(String s)
  {
   return numberOfUpp(s,s.length()-1,0);
  }

 //recursive helper method
 public static int numberOfUpp(String s,int high,int count)
  {
   if(Character.isUpperCase(s.charAt(high)))
    count++;
   if(high==0)
    return count;
   else//���j�q�̫��̪�
    return numberOfUpp(s,high-1,count);
  }
}