//�j�p�g�ഫ

import java.util.Scanner;

public class EX5_3
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //�ŧi��J
   
   System.out.print("Enter a lowercase letter: ");
   String s =  input.nextLine(); //���H�r��覡��J
   char ch = (char)(s.charAt(0)); //�ഫchar

   System.out.print("The uppercase letter is "+lowerCaseToUpperCase(ch));
  }
 
 //�N�p�g�ഫ���j�g
 public static char lowerCaseToUpperCase(char ch)
  {
   int c = (int)ch;  
   int offset = 'a' - 'A';

   char uppercase = (char)(c - offset);//�ഫ���j�g
   
   return uppercase;//�^��
  }
}
   