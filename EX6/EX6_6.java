//�H�}�C�覡�x�s���

public class EX6_6
{
 public static void main(String args[])
  {
   int[] prime = new int[50]; //�s���ƪ��}�C
   int index = 0;//�ثe��ƭӼ�

   int number = 2;//�Ĥ@�Ӽ�
   while(true) //��X���
    {
     if(isPrime(number,index,prime))//�Y�O��� �[�J�}�C
      {
       prime[index] = number;
       index++;
      }
    
     if(index>=50)//��50�Ӹ��X
      break;
     number++;
    }

   System.out.println("The first prime number is "); //���
   for(int i=0;i<50;i++)
    {
     if(i%10==0 && i!=0)
      System.out.println();  
     System.out.print(prime[i]+" ");    
    }
  }

 //�ˬd�O�_���
 public static boolean isPrime(int n,int index, int[] prime)
  {
   if(n==1)//�Y�O1�h�_
    return false;

   int sqrt = (int)(Math.sqrt(n));//�Q����ƶ}�ڸ�

   for(int i=0;i<index;i++)
    {
     if(n%prime[i]==0)//�Y�Q�㰣�Y�_
      return false;
     
     if(prime[i]>sqrt)//�Y�ˬd�Ƥj��}�ڸ��ƫh���X
      break;
    }

   return true;
  }
}