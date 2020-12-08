//反轉數字(回傳)

import java.util.Scanner;

public class EX5_4
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //宣告輸入
   
   System.out.print("Enter a number: ");
   int number = input.nextInt();//輸入數字
   
   System.out.print(reverse(number));//反轉
  }

 //反轉並回傳變數的method
 public static int reverse(int number)
  {
   int num2 = 0;//回傳變數
   while(true)
    {
     num2+=number%10; //加入餘數 等於加入最後一位數
     number/=10;//原數往右退一位
     if(number==0)
      break;
     else
      num2*=10;  //回傳數往左進一位
    }
   return num2; //回傳
  }
}