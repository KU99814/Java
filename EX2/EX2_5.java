//Computing total value of penny nickel dimes quarter and dollar

import java.util.Scanner;

public class EX2_5
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //�ŧi��J
  
   System.out.print("Enter a number of pennies:");
   int penny = input.nextInt(); //��Jpenny

   System.out.print("Enter a number of nickels:");
   int nickel = input.nextInt(); //��Jnickel

   System.out.print("Enter a number of dimes:");
   int dimes = input.nextInt(); //��Jdimes
   
   System.out.print("Enter a number of quarters:");
   int quarter = input.nextInt(); //��Jquarter

   System.out.print("Enter a number of dollars:");
   double dollar = input.nextDouble(); //��Jdollar

   dollar += (penny*0.01)+(nickel*0.05)+(dimes*0.1)+(quarter*0.25); //�ഫ��dollar�[�`

   System.out.print("The total value of dollars are:"+dollar); //��X���G
  }
}
  
   
   