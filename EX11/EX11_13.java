//find square number greater than Long.MAX_VALUE

import java.math.*;

public class EX11_13
{
 public static void main(String args[])
  {
   BigInteger com = new BigInteger(Long.MAX_VALUE + "0");//比較值
   BigInteger num = new BigInteger("1000000000"); //要平方值
 
   int count = 0;//計數

   while(count<10)//找出10個
    {
     if(num.multiply(num).compareTo(com) > 0)//平方後比較
      {
       System.out.println(num);
       count++;
      }
     num = num.add(BigInteger.ONE);//++
    }
  }
}