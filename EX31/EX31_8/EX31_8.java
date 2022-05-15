//華氏攝氏互換 顯示到小數點後兩位

import java.util.*;
import java.text.*;

public class EX31_8
{
 public static void main(String args[])
  {
   double C;//攝氏溫度
   double F;//華氏溫度

   DecimalFormat df = new DecimalFormat("###.00");//數字格式

   //列表
   System.out.println("Celsius\tFahrenheit\t Fahrenheit\t Celsius");

   //用迴圈依序輸出轉換結果
   for(C = 40,F =120;C >= 31; C--,F -= 10)
    {
     System.out.println(C+" \t "+df.format(celsiusToFahrenheit(C))+"\t\t "+F+
                      " \t\t "+df.format(fahrenheitToCelsius(F)));//顯示
    }
  }

 //攝氏轉華氏的method
 public static double celsiusToFahrenheit(double c)
  {
   double f = (9.0/5)*c+32; //算式(攝氏換華氏)
   
   return f;
  }
 
 //華氏轉攝氏的method
 public static double fahrenheitToCelsius(double f)
  {
   double c = (f-32)*(5/9.0);//華氏轉攝氏
   
   return c;
  }
}