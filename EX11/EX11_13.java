//find square number greater than Long.MAX_VALUE

import java.math.*;

public class EX11_13
{
 public static void main(String args[])
  {
   BigInteger com = new BigInteger(Long.MAX_VALUE + "0");//�����
   BigInteger num = new BigInteger("1000000000"); //�n�����
 
   int count = 0;//�p��

   while(count<10)//��X10��
    {
     if(num.multiply(num).compareTo(com) > 0)//�������
      {
       System.out.println(num);
       count++;
      }
     num = num.add(BigInteger.ONE);//++
    }
  }
}