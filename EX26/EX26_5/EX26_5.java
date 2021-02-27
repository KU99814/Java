//Generic heap sort

import java.util.*;

public class EX26_5
{
 public static void main(String args[])
  {
   //�����array
   Integer[] list1 = {2,3,2,5,6,1,-2,3,14,12};
   String[] list2 = {"B","F","E","X","A","E","H","Y"};

   Circle [] list3 = new Circle[10];

   //�Ыضꪫ��
   for(int i=0;i<list3.length;i++)
    list3[i] = new Circle((int)(Math.random()*10));

   //��ܱƧǫelist1
   System.out.print("\nThe list1 before sort: ");
   for(int i=0;i<list1.length;i++)
    System.out.print(list1[i]+" ");
   
   heapSort(list1);//�Ƨ�list1

   //��ܱƧǫ�list1
   System.out.print("\nThe list1 after sort: ");   
   for(int i=0;i<list1.length;i++)
    System.out.print(list1[i]+" ");

   //��ܱƧǫelist2
   System.out.print("\nThe list2 before sort: ");
   for(int i=0;i<list2.length;i++)
    System.out.print(list2[i]+" ");

   heapSort(list2);//�Ƨ�list2

   //��ܱƧǫ�list2
   System.out.print("\nThe list2 after sort: ");
   for(int i=0;i<list2.length;i++)
    System.out.print(list2[i]+" ");

   //�Ƨǫelist3
   System.out.print("\nThe list3 before sort: ");
   for(int i=0;i<list3.length;i++)
    System.out.print(list3[i].getRadius()+" ");

   heapSort(list3,new GeometricObjectComparator());//�Ƨ�

   //�Ƨǫ�list3
   System.out.print("\nThe list3 after sort: ");
   for(int i=0;i<list3.length;i++)
    System.out.print(list3[i].getRadius()+" ");
  }

 //geometric comparator
 static class GeometricObjectComparator implements Comparator<GeometricObject>
  {
   public GeometricObjectComparator()
    {}

   public int compare(GeometricObject o1, GeometricObject o2)
    {
     return o1.compareTo(o2);
    }
  } 

 //heap sort
 public static <E extends Comparable<E>> void heapSort(E[] list)
  {
   Heap<E> heap = new Heap<E>();//heap

   //�Nelement��Jheap�Ƨ�
   for(int i=0;i<list.length;i++)
    heap.add(list[i]);

   //�Nelement�����ǩ�^list
   for(int i=list.length-1;i>=0;i--)
    list[i] = (E)(heap.remove());
  }

 //heap sort using comparator
 public static <E> void heapSort(E[] list,Comparator<? super E> comparator)
  {
   HeapWithComparator heap = new HeapWithComparator(comparator);

   for(int i=0;i<list.length;i++)
    heap.add(list[i]);

   for(int i=list.length-1;i>=0;i--)
    list[i] = (E)(heap.remove());
  }
}