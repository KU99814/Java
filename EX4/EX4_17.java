//finding the sales amount

import java.util.Scanner;

public class EX4_17
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //�ŧi��J

   System.out.print("Enter the commission sought: ");
   double commissionSought = input.nextDouble();    //��J�����D��

   final double INITIAL_SALES_AMOUNT = 0.01; //��l�P���B
   double salesAmount = INITIAL_SALES_AMOUNT; //�P���B

   boolean first = true;//�Ĥ@���@�w�n��
   //�p��Ī�
   for(double commission = 0;commission < commissionSought || first;)
    {
     salesAmount += 0.01;
     if(salesAmount >= 10000.01)
      commission = 5000*0.08 + 5000 *0.1 +(salesAmount - 10000)*0.12;
     else if(salesAmount >= 5000.01)
      commission = 5000*0.08 +(salesAmount - 10000)*0.10;
     else
      commission = salesAmount*0.08;

     first = false;
    }
   
   //��X���G
   System.out.println("The sales amount $"+(int)(salesAmount * 100)/100.0
                +"\nis needed to make a commission of $"+commissionSought);
  }
}