//convent the dollars between us and HK 

import java.util.Scanner;

public class EX2_1
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//宣告輸入
   
   double UsDollar; //美元
   double HkDollar; //港幣

   System.out.print("Enter Us dollars:");
   UsDollar = input.nextDouble(); //輸入美元
       
   HkDollar = UsDollar*7.7807; //乘以港幣兌換比
   
   System.out.print("\nThe US dollars convent to Hong Kong dollars are:"+HkDollar); //輸出結果

   System.out.print("\nEnter Hong Kong dollars:");
   HkDollar = input.nextDouble(); //輸入港幣

   UsDollar = HkDollar/7.7807; //乘以美元兌換比

   System.out.print("\nThe Hong Kong dollars convent to US dollars are:"+UsDollar); //輸出結果
  }
}

   
   