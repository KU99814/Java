public class Rational extends Number implements Comparable
{
 private long numerator = 0;//分子
 private long denominator = 1; //分母

 //建構子
 public Rational()
  {
   this(0,1);
  }

 public Rational(long numerator,long denominator)
  {
  // long gcd = gcd(numerator,denominator);
   this.numerator = numerator;
   this.denominator = denominator;
  }

 //最大公因數
 private static long gcd(long n,long d)
  {
   long n1 = Math.abs(n);
   long n2 = Math.abs(d);
   int gcd = 1;
   
   for(int k=1;k<=n1 && k<= n2;k++)
    {
     if(n1 % k ==0 && n2 % k == 0)
      gcd = k;
    }

   return gcd;
  }

 //取得分子
 public long getNumerator()
  {
   return numerator;
  }

 //取得分母
 public long getDenominator()
  {
   return denominator;
  }

 //加法
 public Rational add(Rational secondRational)
  {
   long n = numerator * secondRational.getDenominator()
             + denominator * secondRational.getNumerator();
   long d = denominator * secondRational.getDenominator();

   return new Rational(n,d);
  }

 //減法
 public Rational subtract(Rational secondRational)
  {
   long n = numerator * secondRational.getDenominator()
             - denominator * secondRational.getNumerator();
   long d = denominator * secondRational.getDenominator();

   return new Rational(n,d);
  }

 //乘法
 public Rational multiply(Rational secondRational)
  {
   long n = numerator * secondRational.getNumerator();
   long d = denominator * secondRational.getDenominator();

   return new Rational(n,d);
  }

 //除法
 public Rational divide(Rational secondRational)
  {
   long n = numerator * secondRational.getDenominator();
   long d = denominator * secondRational.getNumerator();
   
   return new Rational(n,d);
  }

 //顯示
 public String toString()
  {
   if(denominator == 1)
    return numerator + "";
   else
    return numerator + "/" + denominator;
  }

 //判斷是否相等
 public boolean equals(Object parm1)
  {
   if((this.subtract((Rational)(parm1))).getNumerator() == 0)
    return true;
   else
    return false;
  }

 //顯示為int
 public int intValue()
  {
   return (int)doubleValue();
  }

 //顯示為float
 public float floatValue()
  {
   return (float)doubleValue();
  }

 //顯示為double
 public double doubleValue()
  {
   return numerator *1.0 / denominator;
  }

 //顯示為long
 public long longValue()
  {
   return (long)doubleValue();
  }

 //比較
 public int compareTo(Object o)
  {
   if((this.subtract((Rational)o)).getNumerator() > 0)
    return 1;
   else if((this.subtract((Rational)o)).getNumerator() < 0)
    return -1;
   else
    return 0;
  }
}