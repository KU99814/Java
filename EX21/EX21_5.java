//Generic Maximum element in an array

import java.util.*;

public class EX21_5
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J
 
   System.out.print("Enter the number of data: ");
   int num = input.nextInt();//��J�}�C����

   Integer[] array = new Integer[num];//�ŧi�}�C
   System.out.print("Enter numbers: ");//��J�}�C
   for(int i=0;i<num;i++)
    array[i] = input.nextInt();
   
   int max = EX21_5.<Integer>max(array);//��X�̤j��
   System.out.println("The max number in array is "+max);//���
  }

 public static<E extends Comparable<E>> E max(E[] list)
  {
   E max = list[0];//�w�]�̤j��

   for(int i=1;i<list.length;i++)
    {
     if(max.compareTo(list[i])<0)//���
      max = list[i];
    }

   return max;//�^��
  }
}  