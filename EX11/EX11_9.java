//Finding the largest matching object between array

public class EX11_9
{
 public static void main(String args[])
  {
   //�ŧi���Integer class �}�C
   Integer[] a = new Integer[10];
   Integer[] b = new Integer[10];

   for(int i=0;i<10;i++)
    {
     a[i] =  i+1;//1~10
     b[i] = (int)(Math.random()*101);//�H��0~100
    }

   //�P�_�۵����Ƥ��̤j���� �Y�L �^��-1
   System.out.print("The largest integer is "+equals(a,b));
  }

 //�P�_�۵����Ƥ��̤j��
 public static Object equals(Comparable[] a,Comparable[] b)
  {
   Comparable max = -1;//�^�ǭ�

   for(int i=0;i<10;i++)
    {
     for(int j=0;j<10;j++)
      {
       if(a[i].compareTo(b[j]) == 0)//�Y���۵���
        {
         if(a[i].compareTo(max) > 0)//�Y�j��^�ǭ�
          max = a[i];//���N
        }
      }
    }
   
   return max;
  }
}