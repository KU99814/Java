//Generic binary search

import java.util.*;

public class EX21_2
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J
 
   System.out.print("Enter the number of data: ");
   int num = input.nextInt();//��J�}�C����

   Integer[] array = new Integer[num];//�ŧi�}�C
   System.out.print("Enter numbers: ");//��J�}�C�Ʀr �����Ǳq�p��j
   for(int i=0;i<num;i++)
    array[i] = input.nextInt();
   
   System.out.print("Enter the key you want to find: ");
   Integer key = input.nextInt();//��J�n�M�䪺�Ʀr
   
   int index = EX21_2.<Integer>binarySearch(array,key)+1; //���G���j�M
   System.out.print("The key is in "+index);
  }

 //�G���j�M
 public static <E extends Comparable<E>> int binarySearch(E[] list,E key)
  {
   int low = 0;//�C��

   int high = list.length - 1;//����

   //�p�G���C�S����e
   while(high>=low)
    {
     int mid = (low+high)/2;//����

     //����O�_����key extends Comparable�ҥH�ϥ�compareTo���
     if(key.compareTo(list[mid])<0)
      high = mid-1;
     else if(key.compareTo(list[mid])==0)
      return mid;
     else
      low = mid +1;
    }

   return -low-1;//�S�����^�ǭt��
  }
}  