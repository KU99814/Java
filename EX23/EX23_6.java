//Execution time for prime numbers

public class EX23_6
{
 public static void main(String args[])
  {
   //��ܪ�O�ɶ�
   //23.4
   System.out.println("               8000000         10000000          12000000           14000000");
   System.out.println("Listing23.4      "+Listing23_4(8000000)+"            "+Listing23_4(10000000)+
                      "             "+Listing23_4(12000000)+"              "+Listing23_4(14000000));
   System.out.println("               16000000        18000000");
   System.out.println("                  "+Listing23_4(16000000)+"           "+Listing23_4(18000000));

   //23.5
   System.out.println("               8000000         10000000          12000000           14000000");   
   System.out.println("Listing23.5       "+Listing23_5(8000000)+"             "+Listing23_5(10000000)+
                      "              "+Listing23_5(12000000)+"               "+Listing23_5(14000000));
   System.out.println("               16000000        18000000");
   System.out.println("                   "+Listing23_5(16000000)+"            "+Listing23_5(18000000));

   //23.6
   System.out.println("               8000000         10000000          12000000           14000000"); 
   System.out.println("Listing23.6         "+Listing23_6(8000000)+"               "+Listing23_6(10000000)+
                      "               "+Listing23_6(12000000)+"                "+Listing23_6(14000000));
   System.out.println("               16000000        18000000");
   System.out.println("                    "+Listing23_6(16000000)+"             "+Listing23_6(18000000));    
  }

 //�Ĥ@�ؤ�k
 public static long Listing23_4(int n)
  {
   long t0,t1;
   t0 = System.currentTimeMillis();//�}�l�p��
   
   int count = 0;//��Ƽƶq
   int number = 2;//�Ĥ@��

   //�j�骽���F�ؼм�
   while(number <= n)
    {
     boolean isPrime = true;
     
     //�H�۰�����
     //���Ƴ̤j��ثe�ƪ��ڸ�
     for(int divisor = 2;divisor <= (int)(Math.sqrt(number));divisor++)
      {
       if(number%divisor == 0)
        {
         isPrime = false;
         break;
        }
      }

     if(isPrime)
      count++;
     number++;
    }

   t1 = System.currentTimeMillis();//����p��
   
   return (t1-t0);//�^�Ǯɶ�
  }
   
 //�ĤG�ؤ�k    
 public static long Listing23_5(int n)
  {
   long t0,t1;
   t0 = System.currentTimeMillis();//�p�ɶ}�l

   java.util.List<Integer> list = new java.util.ArrayList<Integer>();//�x�s���list

   int count = 0;
   int number = 2;
   int squareRoot = 1;//�ڸ�

   while(number <= n)
    {
     boolean isPrime = true;//�P�_���

     if(squareRoot*squareRoot < number)
      squareRoot++;

     //�j�� �Ylist�����Ƥp��squareRoot �P�_�O�_����
     for(int k = 0;k < list.size() && list.get(k) <= squareRoot;k++)
      {
       if(number % list.get(k) == 0)
        {
         isPrime = false;
         break;
        }
      }

     if(isPrime)
      {
       count++;
       list.add(number);//�Y�O��� �[�Jlist
      }

     number++;
    }
   
   
   t1 = System.currentTimeMillis();
   
   return (t1-t0);//�^�Ǯɶ�
  }

 //�ĤT��k
 public static long Listing23_6(int n)
  {
   long t0,t1;
   t0 = System.currentTimeMillis();

   boolean[] primes = new boolean[n+1];//��ƿz��

   for(int i=0;i<primes.length;i++)
    primes[i] = true;

   for(int k=2;k<=n/k;k++)
    {
     if(primes[k])
      {
       for(int i=k;i<= n/k;i++)
        primes[k*i] = false;//k*i ���O���
      }
    }

   int count = 0;//��Ƽƶq

   for(int i=2;i<primes.length;i++)
    {
     if(primes[i])
      count++;
    }

   t1 = System.currentTimeMillis();
   
   return (t1-t0);//�^�Ǯɶ�
  }
}
         