//Summing the digits in an integers

import java.util.Scanner;

public class EX2_6
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //�ŧi��J

   System.out.print("Enter a number betweem 0 and 1000:");
   int num = input.nextInt(); //��J�Ʀr
   
   int sum = (num%10)+(num/10%10)+(num/100); //�N�U�Ӧ�ƥ[�`
   
   System.out.print("The sum of all its digits is "+sum); //��X���G
  }
}
