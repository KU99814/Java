//Divisible by 5 and 6

import java.math.*;

public class EX11_11
{
 public static void main(String args[])
  {
   BigInteger num = new BigInteger(Long.MAX_VALUE +"0");//初始值
   
   BigInteger rem = new BigInteger("0");//餘數 0
   int count = 0;//計數
   
   while(count<10)//到第50個
    {
     if(num.remainder(new BigInteger("30")).compareTo(rem) == 0)//能被5和6除的話
      {
       System.out.println(num);//顯示
       count++;
      }
     num = num.add(new BigInteger("1"));//+1
    }
  }
}