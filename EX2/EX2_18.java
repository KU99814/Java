//printing a table

public class EX2_18
{
 public static void main(String args[])
  {
   //計算次方
   double a = 1;
   double b = 2;
   double c = 3;
   double d = 4;
   double e = 5;

   //計算
   a = Math.pow(a,2);
   b = Math.pow(b,3);  
   c = Math.pow(c,4);
   d = Math.pow(d,5);
   e = Math.pow(e,6);
   
   //輸出結果
   System.out.println("a"+"\tb"+"\tpow(a, b)");
   System.out.println("1"+"\t2"+"\t"+a);
   System.out.println("2"+"\t3"+"\t"+b);
   System.out.println("3"+"\t4"+"\t"+c);
   System.out.println("4"+"\t5"+"\t"+d);
   System.out.println("5"+"\t6"+"\t"+e);
  }
}
   