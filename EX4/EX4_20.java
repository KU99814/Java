//Printing prime numbers between 2 and 1000

public class EX4_20
{
 public static void main(String args[])
  {
   final int NUMBER_OF_PRIMES_PER_LINE = 8; //����C�����8�Ӽ�
   int count = 0; //�p�ƴ���
   int number = 2; //��ܼƦr
   
   System.out.println("The first 1000 print numbers are \n");
   
   while (number < 1001)
    {
     boolean isPrime = true;

     for(int divisor = 2;divisor <= number/2; divisor++)//�]���̤p��]�ƬO�G �ˬd2�����@�H�U�ƧY�i
      {
       if(number% divisor == 0)
        {
         isPrime = false;
         break;
        }
      }
 
     if(isPrime) //�p�G�O��ƧY���
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