//��XPerfext number

public class EX5_15
{
 public static void main(String args[])
  {
   System.out.print("The perfect number is: ");
   //�q�@��@�U�̧��ˬd
   for(int i = 2;i<=10000;i++)
    {
     if(isPerfect(i))
       System.out.print(i+" ");
    }
  }

 //�˴�Perfext number ��method
 public static boolean isPerfect(int number)
  {
   int sum = 1;//�[�`���ܼ�
   
   for(int i = 2;i<number;i++)
    {
     if(number%i==0) //�p�G�O�]�ƴN�ۥ[
      {
       sum += i;
      }
    }
   //�ˬd�O�_�ۦP
   if(sum == number)
    return true;
   else
    return false;
  }
} 
   