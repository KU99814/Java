//�o�{Emirp

public class EX5_26
{
 public static void main(String args[])
  {
   int count = 0;
   int number = 2;//��l����
   while(count <100) 
    {
     if(isPrime(number)) //�ˬd�O�_���
      if(isEmirp(number)) //�ˬd�O�_Emirp
       {
        System.out.print(number+" "); //�Y�O�N���
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

 public static boolean isEmirp(int number) //�ˬd�O�_Emirp
  {
   int number2 = reverse(number);//�N�Ʀr����
   if(isPrime(number2))//�ˬd�O�_��ƥH�λP��ƬO�_�ۦP
    return true;
   else
    return false;
  }
 
 public static int reverse(int number) //�ˤ�
  {
   int re = 0;//�^�ǭ�
   while(true)
    {
     re*=10; //�����i�@��
     re += number%10; 
     number/=10; //���k�i�@��
     if(number==0)
      break;
    }
   return re;
  }
}