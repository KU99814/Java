//找出Mersenne prime

public class EX5_28
{
 public static void main(String args[])
  {
   System.out.println("p\t2^p-1");//列表
   
   for(int i = 2;i<=31;i++) //顯示2到31
    {
     if(isPrime(i))//判斷是否質數
      {
       long p2 = (long)(Math.pow(2,i)) - 1;//運算
       if(isPrime(p2))//再一次判斷是否質數
        System.out.println(i+"\t "+p2);
      }
    }
  }

 public static boolean isPrime(long number) //檢查是否質數
  {
   int sqrt = (int)(Math.sqrt(number));

   for(int i = 2;i<=sqrt;i++)
    if(number%i==0)
      return false;
   
   return true;
  }
}