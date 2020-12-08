//反轉數字

import java.util.Scanner;

public class EX5_1
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //宣告輸入
   
   System.out.print("Enter a number: ");
   int number = input.nextInt();//輸入數字
   
   reverse(number);//反轉
  }

 //反轉的method
 public static void reverse(int number)
  {
   while(true)
    {
     System.out.print(number%10); //顯示最後一個數
     number /= 10; // 數字右移
     
     if(number == 0)  //如果0結束
      break;
    }
  }
}