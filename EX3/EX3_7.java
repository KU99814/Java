//Financial application: monetary units

import java.util.Scanner;

public class EX3_7
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //宣告輸入

   System.out.print("Enter an amount in double, for example 11.56: ");
   double amount = input.nextDouble();//輸入金額

   //以下轉換成各單位
   int remainingAmount = (int)(amount*100);

   int numberOfOneDollars = remainingAmount / 100;// dollar
   remainingAmount = remainingAmount % 100;

   int numberOfQuarters = remainingAmount / 25; //quarters
   remainingAmount = remainingAmount % 25;
 
   int numberOfDimes = remainingAmount / 10; //dimes
   remainingAmount = remainingAmount % 10;

   int numberOfNickels = remainingAmount / 5; //nickel
   remainingAmount = remainingAmount % 5;

   int numberOfPennies = remainingAmount; //penny

   String output = "Your amount " + amount + " consists of \n";

   //如果該單位至少有一個 顯示該單位 
   //區分出複數型
   if(numberOfOneDollars>0)//如果dollar單位不為0
     {
      output += "\t" + numberOfOneDollars + " dollar"; //加上dollar數量
      if(numberOfOneDollars>1)//複數型加S
       {
        output += "s";
       }
     }
    if(numberOfQuarters>0) //如果quarter單位不為0
     {
      output += "\n\t" + numberOfQuarters + " quarter";//加上quarter數量 這裡開始句首加斷行
      if(numberOfQuarters>1)//複數型加S
       {
        output += "s";
       }
     }
    if(numberOfDimes>0) //如果dime單位不為0
     {
       output += "\n\t" + numberOfDimes + " dime";//加上dime數量
      if(numberOfDimes>1)//複數型加S
       {
        output += "s";
       }
     }
    if(numberOfNickels>0) //如果nickle單位不為0
     {
      output += "\n\t" + numberOfNickels + " nickel";//加上nickle數量
      if(numberOfNickels>1)//複數型加S
       {
        output += "s";
       }
     }
    if(numberOfPennies>0) //如果penny單位不為0
     {
      output += "\n\t" + numberOfPennies + " penn";//加上penny數量
      if(numberOfPennies>1)//字尾為y 複數型去y加ies
       {
        output += "ies\n";
       }
      else
       {
        output += "y\n";
       }
     }
   System.out.println(output);//顯示結果
  }
}