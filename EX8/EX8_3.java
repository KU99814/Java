//check Palindrome ignore case

import java.util.Scanner;

public class EX8_3
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //�ŧi��J

   System.out.print("Enter a string: "); //��J�r��
   String s = input.nextLine();

   String reverseS = reverse(s); //�A��

   if(s.equalsIgnoreCase(reverseS)) //�H�����j�p�g���覡����
    System.out.println(s + " is a palindrome");
   else
    System.out.println(s + " is not a palindrome");
  }

 public static String reverse(String s) //�A�˦r��
  {
   int length = s.length() - 1;
   String re = "";

   for(int i = length;i>=0;i--)
    {
     re += s.charAt(i);     
    }
 
   return re;
  }
}     