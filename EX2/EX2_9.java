import java.util.Scanner;

public class EX2_9
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //宣告輸入
   
   System.out.print("Enter an amount in Integer, for example 1156: ");//最後兩位為cent
   int amount = input.nextInt(); //輸入價錢
 
   //算出需付幾個Dollars
   int dollars = amount/100;

   //算出需付多少cent
   int cent = amount%100;

   System.out.println(dollars+" dollars and "+cent+" cents");
  }
}

   