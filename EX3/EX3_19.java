//checking ISBN

import java.util.Scanner;

public class EX3_19
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //宣告輸入

   System.out.print("Enter an ISBN: ");
   int isbn = input.nextInt(); //輸入ISBN

   //將ISBN分為9個數字
   int d1 = isbn/100000000;
   int d2 = isbn/10000000%10;
   int d3 = isbn/1000000%10;
   int d4 = isbn/100000%10;
   int d5 = isbn/10000%10;
   int d6 = isbn/1000%10;
   int d7 = isbn/100%10;
   int d8 = isbn/10%10;
   int d9 = isbn%10;
  
   //計算第十位數
   int d10 = (d1 + d2*2 + d3*3 + d4*4 + d5*5 + d6*6 + d7*7 + d8*8 + d9*9)%11;

   //輸出ISBN
   System.out.print("The ISBN is "+d1 + d2 + d3 + d4 + d5 + d6 + d7 + d8 + d9);

   //如果第十位大於10時
   if(d10 == 10)
    {
     System.out.print("X");
    }
   else
    System.out.print(d10);
  }
}