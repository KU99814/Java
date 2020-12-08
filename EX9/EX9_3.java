//The MyDouble class

import java.util.Scanner;

public class EX9_3
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//宣告輸入
   
   System.out.print("Enter a double number: ");
   double d1 = input.nextDouble(); //輸入double

   MyDouble MD1 = new MyDouble(d1);//宣告MyDouble

   System.out.println("the number in integer is: "+MD1.intValue());//顯示為int
   System.out.println("the number in integer is: "+MD1.doubleValue());//顯示double
   //轉為指定的基數
   System.out.println("The 5.45 in 16 of specified radix is "+MyDouble.parseDouble("50.45",16));
   //判斷是否相等
   System.out.println("Is equal to d1 ? "+MD1.equals(d1));
   System.out.print("Is equal to new MyDouble? "+MD1.equals(new MyDouble()));
  }
}

//自作double
class MyDouble
{
 private double value;//值

 //建構子
 public MyDouble()
  {
   value = 1.0;
  }

 public MyDouble(double value)
  {
   this.value = value;
  }

 //輸出int
 public int intValue()
  {
   return (int)(value);
  }

 //輸出double
 public double doubleValue()
  {
   return value;
  }

 //將文字轉為double
 public static double parseDouble(String s,int radix)
  {
   String[] v = s.split("[.]");  //以小數點作區別
   double result = 0; //回傳值

   //小數點以上
   for(int i=0;i<v[0].length();i++)
    {
     //取出位數
     char c = v[0].charAt(i);
     int num = 0;
     if(c>='0' && c <='9')
      num = (int)(c-'0');
     else if(c>='A' && c <= 'Z')
      num = (int)(c-'A')+10;

     result += num*(int)(Math.pow(radix,(v[0].length()-1-i))); //將為數根據基數1轉換
    }

   //若有小數點
   if(v.length>1)
    {
     double temp = 0;
     for(int i=0;i<v[1].length();i++)
      {
       char c = v[1].charAt(i);
       double num = 0;
       if(c>='0' && c <='9')
        num = (int)(c-'0');
       else if(c>='A' && c <= 'Z')
        num = (int)(c-'A')+10;
       temp += num*(Math.pow(radix,(-i-1)));//小數點乘以負的次方
      } 
     result += temp;
    }
   
   return result;
  }

 //判斷是否相等
 public boolean equals(double d)
  {
   return (value == d);
  }

 public boolean equals(MyDouble d)
  {
   return d.equals(value);
  }
} 