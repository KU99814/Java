import java.util.Scanner;

public class EX2_9
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //�ŧi��J
   
   System.out.print("Enter an amount in Integer, for example 1156: ");//�̫��쬰cent
   int amount = input.nextInt(); //��J����
 
   //��X�ݥI�X��Dollars
   int dollars = amount/100;

   //��X�ݥI�h��cent
   int cent = amount%100;

   System.out.println(dollars+" dollars and "+cent+" cents");
  }
}

   