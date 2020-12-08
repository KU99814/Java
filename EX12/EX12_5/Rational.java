import java.math.*;

public class Rational implements Comparable
{
 private BigInteger numerator = new BigInteger("0");//���l
 private BigInteger denominator = new BigInteger("1"); //����

 //�غc�l
 public Rational()
  {}

 public Rational(BigInteger numerator,BigInteger denominator)
  {
   this.numerator = numerator;
   this.denominator = denominator;
  }

 //���o���l
 public BigInteger getNumerator()
  {
   return numerator;
  }

 //���o����
 public BigInteger getDenominator()
  {
   return denominator;
  }

 //�[�k
 public Rational add(Rational secondRational)
  {
   BigInteger n = (numerator.multiply(secondRational.getDenominator())).add(
             denominator.multiply(secondRational.getNumerator()));
   BigInteger d = denominator.multiply(secondRational.getDenominator());
   
   return new Rational(n,d);
  }

 //��k
 public Rational subtract(Rational secondRational)
  {
   BigInteger n = (numerator.multiply(secondRational.getDenominator())).subtract(
             denominator.multiply(secondRational.getNumerator()));
   BigInteger d = denominator.multiply(secondRational.getDenominator());
   
   return new Rational(n,d);
  }

 //���k
 public Rational multiply(Rational secondRational)
  {
   BigInteger n = numerator.multiply(secondRational.getNumerator());
   BigInteger d = denominator.multiply(secondRational.getDenominator());
   
   return new Rational(n,d);
  }

 //���k
 public Rational divide(Rational secondRational)
  {
   BigInteger n = numerator.multiply(secondRational.getDenominator());
   BigInteger d = denominator.multiply(secondRational.getNumerator());
   
   return new Rational(n,d);
  }

 //���
 public String toString()
  {
   if(denominator.compareTo(BigInteger.ONE) == 0)
    return numerator + "";
   else
    return numerator + "/" + denominator;
  }

 //�P�_�O�_�۵�
 public boolean equals(Object parm1)
  {
   if((this.subtract((Rational)(parm1))).getNumerator().compareTo(new BigInteger("0")) == 0)
    return true;
   else
    return false;
  }

 //��int
 public int intValue()
  {
   return Integer.parseInt((numerator.divide(denominator)).toString());
  }

 //���
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