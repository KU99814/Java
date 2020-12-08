//Twin prime

public class EX5_30
{
 public static void main(String args[])
  {
   for(int i = 2;i<=1000;i++)
    {
     if(isPrime(i))
      {
       if(isPrime((i+2)))
        System.out.println("("+i+", "+(i+2)+")");
      }
    }
  }
 
 public static boolean isPrime(int number) //檢查是否質數
  {
   for(int i = 2;i<=number/2;i++)
    if(number%i==0)
      return false;
   
   return true;
  }
}