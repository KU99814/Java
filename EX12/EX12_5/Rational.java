import java.math.*;

public class Rational implements Comparable
{
 private BigInteger numerator = new BigInteger("0");//分子
 private BigInteger denominator = new BigInteger("1"); //分母

 //建構子
 public Rational()
  {}

 public Rational(BigInteger numerator,BigInteger denominator)
  {
   this.numerator = numerator;
   this.denominator = denominator;
  }

 //取得分子
 public BigInteger getNumerator()
  {
   return numerator;
  }

 //取得分母
 public BigInteger getDenominator()
  {
   return denominator;
  }

 //加法
 public Rational add(Rational secondRational)
  {
   BigInteger n = (numerator.multiply(secondRational.getDenominator())).add(
             denominator.multiply(secondRational.getNumerator()));
   BigInteger d = denominator.multiply(secondRational.getDenominator());
   
   return new Rational(n,d);
  }

 //減法
 public Rational subtract(Rational secondRational)
  {
   BigInteger n = (numerator.multiply(secondRational.getDenominator())).subtract(
             denominator.multiply(secondRational.getNumerator()));
   BigInteger d = denominator.multiply(secondRational.getDenominator());
   
   return new Rational(n,d);
  }

 //乘法
 public Rational multiply(Rational secondRational)
  {
   BigInteger n = numerator.multiply(secondRational.getNumerator());
   BigInteger d = denominator.multiply(secondRational.getDenominator());
   
   return new Rational(n,d);
  }

 //除法
 public Rational divide(Rational secondRational)
  {
   BigInteger n = numerator.multiply(secondRational.getDenominator());
   BigInteger d = denominator.multiply(secondRational.getNumerator());
   
   return new Rational(n,d);
  }

 //顯示
 public String toString()
  {
   if(denominator.compareTo(BigInteger.ONE) == 0)
    return numerator + "";
   else
    return numerator + "/" + denominator;
  }

 //判斷是否相等
 public boolean equals(Object parm1)
  {
   if((this.subtract((Rational)(parm1))).getNumerator().compareTo(new BigInteger("0")) == 0)
    return true;
   else
    return false;
  }

 //轉int
 public int intValue()
  {
   return Integer.parseInt((numerator.divide(denominator)).toString());
  }

 //比較
 public int compareTo(Object o)
  {
   if((this.subtract((Rational)(o))).getNumerator().compareTo(new BigInteger("0")) > 0)
    return 1;
   else if((this.subtract((Rational)(o))).getNumerator().compareTo(new BigInteger("0")) < 0)
    return -1;
   else
    return 0;
  }
}