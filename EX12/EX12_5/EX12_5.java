//Using BigInteger in Rational class

import java.math.*;

public class EX12_5
{
 public static void main(String args[])
  {
   Rational r1 = new Rational(new BigInteger("1"),new BigInteger("2"));//宣告分數
   
   // 1/2+2/3+3/4+4/5+...+99/100
   for(int i=2;i<=99;i++)
    r1 = r1.add(new Rational(new BigInteger(i +""),new BigInteger((i+1) +"")));

   System.out.println(r1.intValue());
  }
}
