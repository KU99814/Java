public class Rational extends Number implements Comparable
{
 private long numerator = 0;//���l
 private long denominator = 1; //����

 //�غc�l
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

 //�̤j���]��
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

 //���o���l
 public long getNumerator()
  {
   return numerator;
  }

 //���o����
 public long getDenominator()
  {
   return denominator;
  }

 //�[�k
 public Rational add(Rational secondRational)
  {
   long n = numerator * secondRational.getDenominator()
             + denominator * secondRational.getNumerator();
   long d = denominator * secondRational.getDenominator();

   return new Rational(n,d);
  }

 //��k
 public Rational subtract(Rational secondRational)
  {
   long n = numerator * secondRational.getDenominator()
             - denominator * secondRational.getNumerator();
   long d = denominator * secondRational.getDenominator();

   return new Rational(n,d);
  }

 //���k
 public Rational multiply(Rational secondRational)
  {
   long n = numerator * secondRational.getNumerator();
   long d = denominator * secondRational.getDenominator();

   return new Rational(n,d);
  }

 //���k
 public Rational divide(Rational secondRational)
  {
   long n = numerator * secondRational.getDenominator();
   long d = denominator * secondRational.getNumerator();
   
   return new Rational(n,d);
  }

 //���
 public String toString()
  {
   if(denominator == 1)
    return numerator + "";
   else
    return numerator + "/" + denominator;
  }

 //�P�_�O�_�۵�
 public boolean equals(Object parm1)
  {
   if((this.subtract((Rational)(parm1))).getNumerator() == 0)
    return true;
   else
    return false;
  }

 //��ܬ�int
 public int intValue()
  {
   return (int)doubleValue();
  }

 //��ܬ�float
 public float floatValue()
  {
   return (float)doubleValue();
  }

 //��ܬ�double
 public double doubleValue()
  {
   return numerator *1.0 / denominator;
  }

 //��ܬ�long
 public long longValue()
  {
   return (long)doubleValue();
  }

 //���
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