//Finding numbers divisible by 5 and 6

public class EX4_10
{
 public static void main(String args[])
  {
   int count = 0; //�p���X�Ӽ� �H�K��X�ɱƧ�
   for(int i = 100;i < 1001;i++) //�q100��1000
    {
     if(i % 5 == 0 && i % 6 == 0) //�p�G�i�P�ɳQ5�M6�㰣 ��X�Ʀr
      {
       System.out.print(i+" ");

       if(count ==9)//�ĤQ�Ӽ��_��
        {
         System.out.print("\n");
         count = 0;
        }
       else
        count++;
      }
    }
  }
}