//Printing the digits in an integer reversely

import java.util.Scanner;

public class EX20_8
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J

   System.out.print("Enter a number: ");
   int num = input.nextInt();//��J�Ʀr

   System.out.print("The reverse number is ");
   reverseDisplay(num);//����A�˼�
  }

 //����A�˼�method
 public static void reverseDisplay(int value)
  {
   if(value/10==0)//base case
    System.out.print(value%10);
   else//��ܧ��� �C�����j�e�ΤQ��
    {
     System.out.print(value%10);
     value/=10;
     reverseDisplay(value);
    }
  }
}