import java.util.*;

public class EX10_3
{
 public static void main(String args[])
  {
   ArrayList list = new ArrayList();//�}�C
   final int NUMBER_OF_PRIMES_PER_LINE = 8;//�@�檺�Ӽ�
   int count = 0;//�ثe�ĴX�Ӽ�
   int number = 3; //�q3�}�l

   list.add(2);//����J�Ĥ@�ӽ��

   //���1000�ӽ��   
   System.out.println("The print numbers less than 700000 are \n");
   
   while (number < 700000)
    {
     boolean isPrime = true;
     
     for(int i = 0;i <= (list.size()- 1);i++)             //�qlist����X�ư����
      {
       int divisor =((Integer) list.get(i)).intValue();    //�Nlist.get()�নInteger

       if(number% divisor == 0)
        {
         isPrime = false;                                   //�O��ƪ��� true
         break;
        }
      }
 
     if(isPrime)
      {
       list.add(number);                                    //�[�Jlist��
      
       if(count % NUMBER_OF_PRIMES_PER_LINE == 0)
        {
         System.out.println(list.get(count)+" ");
        }
       else
        System.out.print(list.get(count) + " ");
       count++;
      }
     number++;
    }
  }
}