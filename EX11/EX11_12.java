//divisible 2 or 3 50 decimal digits

import java.math.*;

public class EX11_12
{
 public static void main(String args[])
  {
   BigInteger num = new BigInteger("10000000000000000000000000000000000000000000000000");//50���
   num.add(new BigInteger("1"));//+1
   BigInteger div1 = new BigInteger("2");//���� 2
   BigInteger div2 = new BigInteger("3");//���� 3
   BigInteger rem = new BigInteger("0"); //�l�� 0

   int count = 0;//�p��
   while(count < 10) //��ĤQ��
    {
     if(num.remainder(div1).compareTo(rem) == 0 ||
        num.remainder(div2).compareTo(rem) == 0) //���H2��3��0����
      {
       System.out.println(num);//���
       count++;
      }
     
     num = num.add(BigInteger.ONE);//�[1
    }
  }
}