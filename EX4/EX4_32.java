//Perfect Number

public class EX4_32
{
 public static void main(String args[])
  {
   for(int i = 2;i <= 10000;i++)
    {
     int sum = 0; //�[�`�]��
     for(int j = 1;j< i;j++)
      {
       //��Xi���]��
       if(i % j == 0)
        {
         sum += j;
        }
      }
     //�p�G�ŦX������ ��X
     if(sum == i)
      {
       System.out.print(i+" ");
      }
    }
  }
}