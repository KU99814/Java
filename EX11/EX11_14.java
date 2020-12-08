//find large prime number

import java.math.*;

public class EX11_14
{
 public static void main(String args[])
  {
   BigInteger num = new BigInteger(Long.MAX_VALUE+"");//比較數

   int count = 0;//計數
   while(count < 5)
    {
     BigInteger div = num.divide(new BigInteger("2"));//現在數的2分之一
     boolean t = true;//是否質數

     BigInteger div2 = new BigInteger("2");//除數
     while(div2.compareTo(div) <= 0) //除數到2分之一跳出
      {
       if(num.remainder(div2).compareTo(new BigInteger("0")) == 0)//是否整除
        {
         t = false;
         break;
        }
       div2 = div2.add(BigInteger.ONE);//除數++
      }
     
     if(t)//若是質數 顯示
      {
       System.out.println(num);
       count++;
      }
     num = num.add(BigInteger.ONE);//number++
    }
  }
}