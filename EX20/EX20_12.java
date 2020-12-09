//Printing the characters in a string reversely

import java.util.Scanner;

public class EX20_12
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J

   System.out.print("Enter a String: ");
   String s = input.nextLine();//��J�r��

   System.out.print("The reverse string is ");
   reverseDisplay(s);//����A�˦r��
  }

 //�H���j�A�˦r��
 public static void reverseDisplay(String value)
  {
   reverseDisplay(value,value.length()-1);
  }

 //recursive Helper Methods
 public static void reverseDisplay(String value,int high)
  {
   if(high==0)
    System.out.print(value.charAt(high));//base case ��ܦr��
   else///���j�r��M���index
    {
     System.out.print(value.charAt(high));
     reverseDisplay(value,high-1);
    }
  }
}