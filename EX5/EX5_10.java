//使用isPrime求10000以下質數

public class EX5_10
{
 public static void main(String args[])
  {
   final int number_of_prime = 10000;  //範圍
   final int number_of_pre_line = 10;  //第幾個換行
   int count = 0;//計算第幾個
   
   for(int i = 2;i<=number_of_prime;i++)   
    {
     if(isPrime(i))  //如果是true
      {
       count++;
       
       if(count%number_of_pre_line == 0) //第10個換行
         System.out.println(i+" ");      
       else
         System.out.print(i+" ");
      }
    }
  }
 
 public static boolean isPrime(int number)  //驗證是否質數
  {
   //因為最小質因數為2 所以檢查到2分之一即可
   for(int divisor = 2;divisor <= number/2;divisor++)
    {
     if(number % divisor==0)
      return false;
    }
   
   return true;
  }
}
        