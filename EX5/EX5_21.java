//計算年齡平均與偏差數

import java.util.Scanner;

public class EX5_21
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //宣告輸入

   double mean = 0;  //平均數
   double deviation = 0; //偏差數
   double d1 = 0;
   final double n = 10;  //輸入的數目
   
   System.out.print("Enter ten numbers: ");   

   for(int i = 0;i<n;i++)  //輸入十個數
    {
     int age = input.nextInt();
     mean += age;  //輸入的數相加
     d1 += Math.pow(age,2);//平方相加
    }
   
   deviation = d1-(Math.pow(mean,2))/n;  //運算 此時mean還沒有平均
   mean /= n; //平均
   deviation /= (n-1);
   deviation = Math.sqrt(deviation);//開根號
   
   System.out.print("The mean is "+mean+" and the deviation is "+deviation); //輸出
  }
}