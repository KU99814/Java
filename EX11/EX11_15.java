import java.math.*;

public class EX11_15
{
 public static void main(String args[])
  {
   BigInteger p = new BigInteger("2");                      //�ŧiBigInteger
   BigInteger p1 = p.multiply(p);                       //p
   BigInteger p2 = p1.subtract(new BigInteger("1"));    //2^p-1
   BigInteger p3 = p1;                             
   BigInteger d = new BigInteger("2"); //����
   boolean isPrime = true;                                 //�P�_�O�_���

   System.out.println("p\t\t2^p-1");
   System.out.println(p+"\t\t "+p2);

   for(int i = 3;i<=100;i++)                                 //p 2 ~ 100
    {
     isPrime = true;
     d = new BigInteger("2");  //2^-1������
     p = BigInteger.ONE;
     p1 = p.multiply(new BigInteger("2"));                   
     p = new BigInteger(i+"");                               //p
     int m = 2;

     for(int j = 2;j<=i;j++)                                 //2^p-1
      {
       p1 = p1.multiply(new BigInteger("2"));
       if(j == i/2)
        p3 = p1;
      }
     p2 = p1.subtract(BigInteger.ONE);

      for(int j = 2;j<=i/2;j++) //����P
       {
        if(p.remainder(new BigInteger(j+"")).equals(BigInteger.ZERO))           //����P�O�_���
         {
          isPrime = false;
          break;
         }
       }
      while(true)
       {
        if(d.compareTo(p3) == 1)
         break;

        if(p2.remainder(d).equals(BigInteger.ZERO))          //����2^P-1�O�_���
         {
          isPrime = false;
          break;
         }
        d = d.add(BigInteger.ONE);
       }
  
     if(isPrime)                                                            //�p�G���O�N���
      { 
       System.out.println(p+"\t\t "+p2);
      }
    }    
  }
}