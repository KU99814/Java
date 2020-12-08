//тPalindromic Prime

public class EX5_27
{
 public static void main(String args[])
  {
   int count = 0;//璸计籔传︽ノ
   int number = 2;//﹍计
   
   while(count < 100)
    {
     if(isPrime(number))//浪琩琌借计
      if(isPalindromic(number)) //璝琌借计 秈˙浪琩Palindromic
       {
        System.out.print(number+" ");
        count++;
        if(count%10==0)
         System.out.println();
       }
     number++;
    }
  }

 public static boolean isPrime(int number) //浪琩琌借计
  {
   for(int i = 2;i<=number/2;i++)
    if(number%i==0)
      return false;
   
   return true;
  }
 
 public static boolean isPalindromic(int number) //浪琩琌Palindromic 
  {
   int number2 = reverse(number);//は

   if(number == number2)//耞琌单
    return true;
   else
    return false;
  }

 public static int reverse(int number) //は
  {
   int re = 0;
   while(true)
    {
     re*=10;
     re += number%10;
     number/=10;
     if(number==0)
      break;
    }
   return re;
  }
}