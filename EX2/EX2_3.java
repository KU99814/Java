//computing total cost

import java.util.Scanner;

public class EX2_3
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //宣告輸入

   System.out.print("Enter the price of the product:");
   double price = input.nextDouble(); //輸入價錢

   double tax = 0.06; //稅率
   
   double totalPrice = price + (price*tax); //計算總價

   System.out.print("The total price of the product are:"+totalPrice); //輸出結果
  }
}
   
 