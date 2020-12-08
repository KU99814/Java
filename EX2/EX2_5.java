//Computing total value of penny nickel dimes quarter and dollar

import java.util.Scanner;

public class EX2_5
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //宣告輸入
  
   System.out.print("Enter a number of pennies:");
   int penny = input.nextInt(); //輸入penny

   System.out.print("Enter a number of nickels:");
   int nickel = input.nextInt(); //輸入nickel

   System.out.print("Enter a number of dimes:");
   int dimes = input.nextInt(); //輸入dimes
   
   System.out.print("Enter a number of quarters:");
   int quarter = input.nextInt(); //輸入quarter

   System.out.print("Enter a number of dollars:");
   double dollar = input.nextDouble(); //輸入dollar

   dollar += (penny*0.01)+(nickel*0.05)+(dimes*0.1)+(quarter*0.25); //轉換成dollar加總

   System.out.print("The total value of dollars are:"+dollar); //輸出結果
  }
}
  
   
   