//Generic quick sort

import java.util.*;

public class EX26_3
{
 public static void main(String args[])
  {
   //sort��
   Integer[] list1 = {8,5,6,1,7,9,3,4,2};//int list ����j�p
   String[] list2 = {"B","F","E","X","A","E","H","Y"};//string �������
   Circle [] list3 = new Circle[10];//circle //����ꭱ�n

   //�Ыضꪫ�� �H���M�w�b�|
   for(int i=0;i<list3.length;i++)
    list3[i] = new Circle((int)(Math.random()*10));

   //���int list�Ƨǫe����
   System.out.print("The list1 before sort: ");
   for(int i=0;i<list1.length;i++)
    System.out.print(list1[i]+" ");

   quickSort(list1);//�Ƨ�

   //���int list�Ƨǫᶶ��
   System.out.print("\nThe list1 after sort: ");
   for(int i=0;i<list1.length;i++)
    System.out.print(list1[i]+" ");

   //���string�Ƨǫe����
   System.out.print("\nThe list2 before sort: ");
   for(int i=0;i<list2.length;i++)
    System.out.print(list2[i]+" ");

   quickSort(list2);//�Ƨ�

   //���string�Ƨǫᶶ��
   System.out.print("\nThe list2 after sort: ");
   for(int i=0;i<list2.length;i++)
    System.out.print(list2[i]+" ");

   //���circle�Ƨǫe����
   System.out.print("\nThe list3 before sort: ");
   for(int i=0;i<list3.length;i++)
    System.out.print(list3[i].getRadius()+" ");

   quickSort(list3,new GeometricObjectComparator());//�Ƨ�

   //���circle�Ƨǫᶶ��
   System.out.print("\nThe list3 after sort: ");
   for(int i=0;i<list3.length;i++)
    System.out.print(list3[i].getRadius()+" ");
  }

 //geometric�����
 static class GeometricObjectComparator implements Comparator<GeometricObject>
  {
   //default
   public GeometricObjectComparator()
    {}

   //���
   public int compare(GeometricObject o1, GeometricObject o2)
    {
     return o1.compareTo(o2);
    }
  }

 //quick sort Object
 public static <E extends Comparable<E>> void quickSort(E[] list)
  {
   quickSort(list,0,list.length-1);//recursive helper method
  }

 //quick sort recursive helper method
 public static <E extends Comparable<E>> void quickSort(E[] list,int first,int last)
  {
   if(last > first)
    {
     int pivotIndex = partition(list,first,last);//����I�Ƨǫ�index
     
     //�H����I���� ����b�@���j
     quickSort(list,first,pivotIndex-1);
     quickSort(list,pivotIndex+1,last);
    }
  }

 //���ΰ}�C ��ڧ@�ƧǪ�method
 private static <E extends Comparable<E>> int partition(E[] list,int first,int last)
  {
   E pivot = list[first];//����̶}�Yindex�@���
   int low = first + 1;//�}�l�@�D�諸index
   int high = last;//�̫᪺index

   while(high > low)
    {
     //�q�����k�j�M ���Ǥj�ζW�Lhigh���X
     while(low <= high && list[low].compareTo(pivot) <= 0)
      low++;

     //�q�k�����j�M ���Ǥp�ζW�Llow���X
     while(low <= high && list[high].compareTo(pivot) > 0)
      high--;
     
     //�洫element
     if(high > low)
      {
       E temp = list[high];
       list[high] = list[low];
       list[low] = temp;
      }
    }

   
   while(high >first && list[high].compareTo(pivot) >= 0)
      high--;
   
   //�Y���j �N��ǻPlist[high]�洫
   if(pivot.compareTo(list[high]) > 0)
      {
       list[first] = list[high];
       list[high] = pivot;
       return high;//�^�ǰ��index
      }
   else
    return first;//�^�ǰ��index
  }

 //quickSort overload
 //�ϥ�comparator
 public static <E> void quickSort(E[] list,Comparator<? super E> comparator)
  {
   quickSort(list,0,list.length-1,comparator);
  }

 public static <E> void quickSort(E[] list,int first,int last,Comparator<? super E> comparator)
  {
   if(last > first)
    {
     int pivotIndex = partition(list,first,last,comparator);
     quickSort(list,first,pivotIndex-1,comparator);
     quickSort(list,pivotIndex+1,last,comparator);
    }
  }

 //partition overload
 //�ϥ�comparator
 private static <E> int partition(E[] list,int first,int last,Comparator<? super E> comparator)
  {
   E pivot = list[first];
   int low = first + 1;
   int high = last;

   while(high > low)
    {
     while(low <= high && comparator.compare(list[low],pivot) <= 0)
      low++;

     while(low <= high && comparator.compare(list[high],pivot) > 0)
      high--;
     
     if(high > low)
      {
       E temp = list[high];
       list[high] = list[low];
       list[low] = temp;
      }
    }

   while(high >first && comparator.compare(list[high],pivot) >= 0)
      high--;
   
   if(comparator.compare(pivot,list[high]) > 0)
      {
       list[first] = list[high];
       list[high] = pivot;
       return high;
      }
   else
    return first;
  }
}