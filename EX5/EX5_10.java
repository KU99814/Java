//�ϥ�isPrime�D10000�H�U���

public class EX5_10
{
 public static void main(String args[])
  {
   final int number_of_prime = 10000;  //�d��
   final int number_of_pre_line = 10;  //�ĴX�Ӵ���
   int count = 0;//�p��ĴX��
   
   for(int i = 2;i<=number_of_prime;i++)   
    {
     if(isPrime(i))  //�p�G�Otrue
      {
       count++;
       
       if(count%number_of_pre_line == 0) //��10�Ӵ���
         System.out.println(i+" ");      
       else
         System.out.print(i+" ");
      }
    }
  }
 
 public static boolean isPrime(int number)  //���ҬO�_���
  {
   //�]���̤p��]�Ƭ�2 �ҥH�ˬd��2�����@�Y�i
   for(int divisor = 2;divisor <= number/2;divisor++)
    {
     if(number % divisor==0)
      return false;
    }
   
   return true;
  }
}
        