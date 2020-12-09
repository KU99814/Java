//Catalan numbers

import java.util.Scanner;

public class EX20_10
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//宣告輸入

   System.out.print("Enter n: ");
   int n = input.nextInt();//輸入數字
   
   if(n<0)//輸入小於零 跳出例外
    throw new IllegalArgumentException("n is nagetive");
   else
    System.out.print("cn = "+catalan(n-1));//顯示結果
  }

 //計算method
 public static int catalan(int n)
  {
   if(n==0)//base case
    return 1;
   else//遞迴計算
    {
     int cn = 0;
     for(int i=0;i<=(n-1);i++)
      {
       cn += catalan(i)*catalan((n-1)-i);
      }
     return cn;
    }
  }
}