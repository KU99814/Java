//Printing prime numbers between 2 and 1000

public class EX4_20
{
 public static void main(String args[])
  {
   final int NUMBER_OF_PRIMES_PER_LINE = 8; //–︽陪ボ8计
   int count = 0; //璸计传︽
   int number = 2; //陪ボ计
   
   System.out.println("The first 1000 print numbers are \n");
   
   while (number < 1001)
    {
     boolean isPrime = true;

     for(int divisor = 2;divisor <= number/2; divisor++)//程借计琌 浪琩2だぇ计
      {
       if(number% divisor == 0)
        {
         isPrime = false;
         break;
        }
      }
 
     if(isPrime) //狦琌借计陪ボ
      {
       count++;
        
       if(count % NUMBER_OF_PRIMES_PER_LINE == 0)
        {
         System.out.println(number);
        }
       else
        System.out.print(number + " ");
      }

     number++;
    }
  }
}