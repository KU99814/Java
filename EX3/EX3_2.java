//Checking whether a number is even

import java.util.Scanner;

public class EX3_2
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //�ŧi��J
   
   System.out.print("Enter a integer: ");
   int num = input.nextInt(); //��J�Ʀr

   //�P�_�O�_������
   System.out.print("Is "+num+" an even number? "+(num%2 == 0));
  }
}