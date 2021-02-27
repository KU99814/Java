//Improving quick sort

import java.util.*;

public class EX26_4
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
 private static <E extends Comparable<E>> void quickSort(E[] list,int first,int last)
  {
    //check for empty or null array
    if (list == null || list.length == 0)
      return;
         
    if (first >= last)
     return;
     
   int mid = first+(last-first) / 2;//���o���index

   E pivot = list[mid];//���
   int low = first;//�p���Ǫ�index
   int high = last;//�j���Ǫ�index

   while(high >= low)
    {
     //����j�p ���pindex+1
     while(list[low].compareTo(pivot) < 0)
      low++;

     ////����j�p ���jindex-1
     while(list[high].compareTo(pivot) > 0)
      high--;
     
     //�洫element �T�O���䪺�p �k�䪺�j
     if(high >= low)
      {
       swap(list,low,high);
       low++;
       high--;
      }
    }
  
   //�}�C�����ⳡ�����j
   if (first < high)
    quickSort(list, first, high);
   if (last > low)
    quickSort(list, low, last);
  }

 //�洫�}�C��element
 public static <E extends Comparable<E>> void swap(E[] list,int n1,int n2)
  {
   E temp = list[n1];
   list[n1] = list[n2];
   list[n2] = temp;
  }

 //quick sort overload
 //�ϥ�comparator
 public static <E> void quickSort(E[] list,Comparator<? super E> comparator)
  {
   quickSort(list,0,list.length-1,comparator);
  }

 private static <E> void quickSort(E[] list,int first,int last,Comparator<? super E> comparator)
  {
   int mid = first + (last-first) / 2;

   E pivot = list[mid];
   int low = first;
   int high = last;

   while(high > low)
    {
     while(comparator.compare(list[low],pivot) < 0)
      low++;

     while(comparator.compare(list[high],pivot) > 0)
      high--;
     
     if(high >= low)
      {
       swap(list,low,high);
       low++;
       high--;
      }
    }

   if (first < high)
    quickSort(list,first,high,comparator);
   if (last > low)
    quickSort(list,low,last,comparator);
  }

 public static <E> void swap(E[] list,int n1,int n2)
  {
   E temp = list[n1];
   list[n1] = list[n2];
   list[n2] = temp;
  }
}