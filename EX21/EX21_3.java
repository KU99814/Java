//Generic selection sort

import java.util.*;

public class EX21_3
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J
 
   System.out.print("Enter the number of data: ");
   int num = input.nextInt(); //��J�}�C����

   Integer[] array = new Integer[num];//�ŧi�}�C
   System.out.print("Enter numbers: ");//��J�}�C
   for(int i=0;i<num;i++)
    array[i] = input.nextInt();
   
   EX21_3.<Integer>selectionSort(array);//�}�C���Ƨ�
   System.out.println("The array after sort is: ");//��ܱƧǫᵲ�G
   for(int i=0;i<num;i++)
    System.out.print(array[i]+" ");
  }

 //��ܱƧ�
 public static<E extends Comparable<E>> void selectionSort(E[] list)
  {
   for(int i=list.length-1;i>=1;i--)
    {
     E currentMax = list[0];//�{�b�̤j
     int currentMaxIndex = 0;//�{�b�̤j���ޭ�
     
     //�q�̤U���̧Ǥ��
     for(int j=1;j<=i;j++)
      {
       if(currentMax.compareTo(list[j])<0)//����j�ȴN���� 
        {
         currentMax = list[j];
         currentMaxIndex = j;
        }
      }

     if(currentMaxIndex != i)//�p�G�̤W�����O�̤j ����
      {
       list[currentMaxIndex] = list[i];
       list[i] = currentMax;
      }
    }
  }
}  