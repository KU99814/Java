//Divisible by 5 and 6

import java.math.*;

public class EX11_11
{
 public static void main(String args[])
  {
   BigInteger num = new BigInteger(Long.MAX_VALUE +"0");//��l��
   
   BigInteger rem = new BigInteger("0");//�l�� 0
   int count = 0;//�p��
   
   while(count<10)//���50��
    {
     if(num.remainder(new BigInteger("30")).compareTo(rem) == 0)//��Q5�M6������
      {
       System.out.println(num);//���
       count++;
      }
     num = num.add(new BigInteger("1"));//+1
    }
  }
}