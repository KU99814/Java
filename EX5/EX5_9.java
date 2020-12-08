//英里公里互換

import java.util.Scanner;

public class EX5_9
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //宣告輸入

   System.out.println("Miles\t\tkilometer\t|\tkilometer\t\tMiles");     //顯示
   
   for(double i=1;i<=10;i++)
    System.out.println(i+"\t\t"+MToK(i)+"\t\t|\t"+(20+5*(i-1))+"\t\t\t"+KToM(20+5*(i-1)));
  }

 public static double MToK(double mile)   //英哩換公里
  {
   double k = mile/1.609;          //運算
   k = (int)(k*10000);         //取到第四位
   
   k/=10000;
   
   return k;
  }

 public static double KToM(double kilometer)   //公里換英哩
  {
   double m = kilometer*1.609;
   m = (int)(m*1000);           //取到第三位
   m/=1000;
   
   return m;
  }
}

   
   
