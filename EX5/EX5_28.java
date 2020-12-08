//��XMersenne prime

public class EX5_28
{
 public static void main(String args[])
  {
   System.out.println("p\t2^p-1");//�C��
   
   for(int i = 2;i<=31;i++) //���2��31
    {
     if(isPrime(i))//�P�_�O�_���
      {
       long p2 = (long)(Math.pow(2,i)) - 1;//�B��
       if(isPrime(p2))//�A�@���P�_�O�_���
        System.out.println(i+"\t "+p2);
      }
    }
  }

 public static boolean isPrime(long number) //�ˬd�O�_���
  {
   int sqrt = (int)(Math.sqrt(number));

   for(int i = 2;i<=sqrt;i++)
    if(number%i==0)
      return false;
   
   return true;
  }
}