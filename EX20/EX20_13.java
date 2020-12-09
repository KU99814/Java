//Finding the largest number in an array

import java.util.Scanner;

public class EX20_13
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J

   System.out.print("Enter a number of array's length: ");
   int l = input.nextInt();//��J�}�C��

   int[] a = new int[l];//�ŧi�}�C

   System.out.print("Enter numbers of the array: ");
   for(int i=0;i<l;i++)
    a[i] = input.nextInt();//��J�}�C�Ʀr

   System.out.print("The max number of array is "+max(a));//��̤ܳj��
  }

 //���j��X�̤j line search
 public static int max(int[] a)
  {
   return max(a,(a.length-1),0);
  }

 //recursive Helper Methods
 public static int max(int[] a,int high,int m)
  {
   if(a[high]>m)//��j�p
    m = a[high];
   
   if(high==0)//base case
    return m;
   else//���j�q�̤jindex��̤p
    {
     return max(a,high-1,m);
    }
  }
}