//find large prime number

import java.math.*;

public class EX11_14
{
 public static void main(String args[])
  {
   BigInteger num = new BigInteger(Long.MAX_VALUE+"");//�����

   int count = 0;//�p��
   while(count < 5)
    {
     BigInteger div = num.divide(new BigInteger("2"));//�{�b�ƪ�2�����@
     boolean t = true;//�O�_���

     BigInteger div2 = new BigInteger("2");//����
     while(div2.compareTo(div) <= 0) //���ƨ�2�����@���X
      {
       if(num.remainder(div2).compareTo(new BigInteger("0")) == 0)//�O�_�㰣
        {
         t = false;
         break;
        }
       div2 = div2.add(BigInteger.ONE);//����++
      }
     
     if(t)//�Y�O��� ���
      {
       System.out.println(num);
       count++;
      }
     num = num.add(BigInteger.ONE);//number++
    }
  }
}