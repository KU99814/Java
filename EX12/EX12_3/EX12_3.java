//using the Rational class

public class EX12_3
{
 public static void main(String args[])
  {
   Rational r1 = new Rational(1,2);//宣告Rational
   
   // 1/2+ 2/3+3/4+...+99/100
   for(int i=2;i<=99;i++)
    {
     r1 = r1.add(new Rational(i,i+1));
     System.out.println(i);
    }

   //顯示
   System.out.println(r1.doubleValue());
  }
}
