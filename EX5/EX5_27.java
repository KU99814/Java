//��XPalindromic Prime

public class EX5_27
{
 public static void main(String args[])
  {
   int count = 0;//�p�ƻP�����
   int number = 2;//��l��
   
   while(count < 100)
    {
     if(isPrime(number))//�ˬd�O�_���
      if(isPalindromic(number)) //�Y�O��� �i�@�B�ˬdPalindromic
       {
        System.out.print(number+" ");
        count++;
        if(count%10==0)
         System.out.println();
       }
     number++;
    }
  }

 public static boolean isPrime(int number) //�ˬd�O�_���
  {
   for(int i = 2;i<=number/2;i++)
    if(number%i==0)
      return false;
   
   return true;
  }
 
 public static boolean isPalindromic(int number) //�ˬd�O�_Palindromic 
  {
   int number2 = reverse(number);//�ˤ�

   if(number == number2)//�P�_�O�_�۵�
    return true;
   else
    return false;
  }

 public static int reverse(int number) //�ˤ�
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