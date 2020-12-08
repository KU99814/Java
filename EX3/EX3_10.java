//computing taxes

import java.util.Scanner;

public class EX3_10
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //宣告輸入

   System.out.print("(0-single filer, 1-married joinly,\n"+
                    "2-married separately, 3-head of household)\n"+
                    "Enter the filing status: ");
   int status = input.nextInt(); //輸入狀態

   System.out.print("Enter the taxable income: ");
   double income = input.nextDouble(); //輸入收入

   double tax = 0;

   //根據狀態與收入作計算
   if(status == 0)
    {
     if(income <= 6000)
      tax = income * 0.10;
     else if(income <= 27950)
      tax = 6000 * 0.10 + (income - 6000)*0.15;
     else if(income <= 67700)
      tax = 6000 * 0.10 + (27950 - 6000)*0.15 + (income - 27950)*0.27 ;
     else if(income <= 141250)
      tax = 6000 * 0.10 + (27950 - 6000)*0.15 + (67700 - 27950)*0.27 
             + (income - 67700)*0.30;
     else if(income <= 307050)
      tax = 6000 * 0.10 + (27950 - 6000)*0.15 + (67700 - 27950)*0.27 
             + (141250 - 67700)*0.30 + (income - 141250)*0.35;
     else
       tax = 6000 * 0.10 + (27950 - 6000)*0.15 + (67700 - 27950)*0.27 
             + (141250 - 67700)*0.30 + (307050 - 141250)*0.35 + (income - 307050)* 0.386;
    }
   else if(status == 1)
    {
     if(income <= 12000)
      tax = income * 0.10;
     else if(income <= 46700)
      tax = 12000 * 0.10 + (income - 12000)*0.15;
     else if(income <= 112850)
      tax = 12000 * 0.10 + (46700 - 12000)*0.15 + (income - 46700)*0.27 ;
     else if(income <= 171950)
      tax = 12000 * 0.10 + (46700 - 12000)*0.15 + (112850 - 46700)*0.27 
             + (income - 1128500)*0.30;
     else if(income <= 307050)
      tax = 12000 * 0.10 + (46700 - 12000)*0.15 + (112850 - 46700)*0.27 
             + (171950 - 112850)*0.30 + (income - 171950)*0.35;
     else
       tax = 12000 * 0.10 + (46700 - 12000)*0.15 + (112850 - 46700)*0.27 
             + (171950 - 112850)*0.30 + (307050 - 171950)*0.35 + (income - 307050)* 0.386;
    }
   else if(status == 2)
    {
     if(income <= 6000)
      tax = income * 0.10;
     else if(income <= 23350)
      tax = 6000 * 0.10 + (income - 6000)*0.15;
     else if(income <= 56425)
      tax = 6000 * 0.10 + (23350 - 6000)*0.15 + (income - 23350)*0.27 ;
     else if(income <= 85975)
      tax = 6000 * 0.10 + (23350 - 6000)*0.15 + (56425 - 23350)*0.27 
             + (income - 56425)*0.30;
     else if(income <= 153525)
      tax = 6000 * 0.10 + (23350 - 6000)*0.15 + (56425 - 23350)*0.27 
             + (85975 - 56425)*0.30 + (income - 85975)*0.35;
     else
       tax = 6000 * 0.10 + (23350 - 6000)*0.15 + (56425 - 23350)*0.27 
             + (85975 - 56425)*0.30 + (153525 - 85975)*0.35 + (income - 153525)* 0.386;
    }
   else if(status == 3)
    {
     if(income <= 10000)
      tax = income * 0.10;
     else if(income <= 37450)
      tax = 10000 * 0.10 + (income - 10000)*0.15;
     else if(income <= 96700)
      tax = 10000 * 0.10 + (37450 - 10000)*0.15 + (income - 37450)*0.27 ;
     else if(income <= 156600)
      tax = 10000 * 0.10 + (37450 - 10000)*0.15 + (96700 - 37450)*0.27 
             + (income - 96700)*0.30;
     else if(income <= 307050)
      tax = 10000 * 0.10 + (37450 - 10000)*0.15 + (96700 - 37450)*0.27 
             + (156600 - 96700)*0.30 + (income - 156600)*0.35;
     else
       tax = 10000 * 0.10 + (37450 - 10000)*0.15 + (96700 - 37450)*0.27 
             + (156600 - 96700)*0.30 + (307050 - 156600)*0.35 + (income - 307050)* 0.386;
    }
   else //如果輸入得數不屬於任一狀態 結束程式
    {
     System.out.println("Error: invalid status");
     System.exit(0);
    }
   
   //顯示結果
   System.out.println("Tax is "+ (int)(tax * 100)/ 100.0);
  }
}