//Bogosort

import java.util.Random;

public class EX23_5
{
 static Random random = new Random();//�H��
 public static void main(String args[])
  {
   long[] count = new long[10];//list�ƧǦ���
   int[] num = new int[10];//�P����list�X�{����

   for(int i=0;i<10;i++)
    {
     count[i]=0;
     num[i] = 0;
    }

   //����25��
   for(int i=0;i<25;i++)
    {
     int length = random.nextInt(10)+1;//�H��list����

     int[] a = new int[length];//���հ}�C

     for(int j=0;j<length;j++)
      a[j] = random.nextInt(100)+1;//�[�J�H����

     count[length-1] += bogosort(a);//�Ƨ�
     num[length - 1]++;//�X�{+1��
    }

   //��ܨ�ƧǦ��\���������
   for(int i=0;i<10;i++)
    {
     if(count[i]!=0)
      System.out.println((i+1)+"'s average is "+(count[i]/num[i]));
    }
  }

 //bogosort
 public static long bogosort(int[] n)
  {
   long c = 0;//�^�Ǫ��ƧǦ���

   while(!inOrder(n))//�j�骽��Ƨǧ�
    {
     for (int i = 0; i < n.length; i++)
      {
       int swapPosition = random.nextInt(i + 1);//�H���M�windex
       //��ثeindex�洫
       int temp = n[i];
       n[i] = n[swapPosition];
       n[swapPosition] = temp;
      }
     c++;//���ƥ[1
    }
   
   return c;//�^��
  }

 //�ˬd�O�_�Ƨ�
 public static boolean inOrder(int[] n)
  {
   for (int i = 0; i < n.length-1; i++)
    {
     if (n[i] > n[i+1])
      return false;
    }
   return true;
  }
}