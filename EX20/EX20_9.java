//Printing the characters in a string reversely

import java.util.Scanner;

public class EX20_9
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J

   System.out.print("Enter a String: ");
   String s = input.nextLine();//��J�r��

   System.out.print("The reverse string is ");
   reverseDisplay(s);//�A�˦r�����
  }

 //�λ��j�A�˦r��
 public static void reverseDisplay(String value)
  {
   if(value.length()==1)//base case
    System.out.print(value.charAt(value.length()-1));
   else//��̫ܳ�@�Ӧr �û��j���h�̫�@�r���l�r��
    {
     System.out.print(value.charAt(value.length()-1));
     reverseDisplay(value.substring(0,value.length()-1));
    }
  }
}