//computing total cost

import java.util.Scanner;

public class EX2_3
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //�ŧi��J

   System.out.print("Enter the price of the product:");
   double price = input.nextDouble(); //��J����

   double tax = 0.06; //�|�v
   
   double totalPrice = price + (price*tax); //�p���`��

   System.out.print("The total price of the product are:"+totalPrice); //��X���G
  }
}
   
 