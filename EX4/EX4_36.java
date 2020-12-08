//checking ISBN

import java.util.Scanner;

public class EX4_36
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//宣告輸入

   System.out.print("Enter an ISBN: ");
   int isbn = input.nextInt(); //輸入ISBN前九碼

   double d10 = 0;
   int d = isbn; //計算用變數

   //計算ISBN d10 = d1*1+d2*2+d3*3+d4*4+d5*5+d6*6+d7*7+d8*8+d9*9)%11
   System.out.print("The ISBN is "+isbn);
   for(int i = 0;i<9;i++)
    {
     int dn = d%10;
     d10 += dn*(9 - i);
     d/=10;
    }

   d10 %=11;
   d10 = (int)d10;
   if(d10 == 10)
    {
     System.out.print("X");
    }
   else
    System.out.print(d10);
  }
}