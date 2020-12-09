//Generic insertion sort

import java.util.*;

public class EX21_4
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
   
   EX21_4.<Integer>insertionSort(array);//�}�C�Ƨ�
   System.out.println("The array after sort is: ");//��ܵ��G
   for(int i=0;i<num;i++)
    System.out.print(array[i]+" ");
  }

 //���J�Ƨ�
 public static <E extends Comparable<E>> void insertionSort(E[] list)
  {
   for(int i=1;i<list.length;i++)
    {
     E currentElement = list[i];//�ثe��
     int k;
     //��ثe�Ȩ̧Ǥ�� �Y��ثe�Ȥj ���e��
     for(k=i-1;k>=0 && list[k].compareTo(currentElement)>0;k--)
      {
       list[k+1] = list[k];
      }

     //���J���e�ƫ᪺�Ů�
     list[k+1] = currentElement;
    }
  }
}  