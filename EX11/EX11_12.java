//divisible 2 or 3 50 decimal digits

import java.math.*;

public class EX11_12
{
 public static void main(String args[])
  {
   BigInteger num = new BigInteger("10000000000000000000000000000000000000000000000000");//50位數
   num.add(new BigInteger("1"));//+1
   BigInteger div1 = new BigInteger("2");//除數 2
   BigInteger div2 = new BigInteger("3");//除數 3
   BigInteger rem = new BigInteger("0"); //餘數 0

   int count = 0;//計數
   while(count < 10) //到第十個
    {
     if(num.remainder(div1).compareTo(rem) == 0 ||
        num.remainder(div2).compareTo(rem) == 0) //除以2或3為0的話
      {
       System.out.println(num);//顯示
       count++;
      }
     
     num = num.add(BigInteger.ONE);//加1
    }
  }
}