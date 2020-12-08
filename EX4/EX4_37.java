//Decimal to binary

import java.util.Scanner;

public class EX4_37
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //宣告輸入
   
   System.out.print("Enter a number: ");
   int num = input.nextInt(); //輸入要轉換的數字
   
   String s = "";
  
   System.out.print("The number of binary is: ");

   //轉換為二進制
   while(true)
    {
     //每次除2 將餘數放前頭
     int d = num % 2;
     s = d + s;    
     if(num == 1 || num == 0)
      break;
     num = (int)(num/2);
    }
   System.out.print(s);
  }
}