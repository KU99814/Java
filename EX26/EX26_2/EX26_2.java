//Generic merge sort

import java.util.*;

public class EX26_2
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

   mergeSort(list1);//�Ƨ�

   //���int list�Ƨǫᶶ��
   System.out.print("\nThe list1 after sort: ");
   for(int i=0;i<list1.length;i++)
    System.out.print(list1[i]+" ");

   //���string�Ƨǫe����
   System.out.print("\nThe list2 before sort: ");
   for(int i=0;i<list2.length;i++)
    System.out.print(list2[i]+" ");

   mergeSort(list2);//�Ƨ�

   //���string�Ƨǫᶶ��
   System.out.print("\nThe list2 after sort: ");
   for(int i=0;i<list2.length;i++)
    System.out.print(list2[i]+" ");

   //���circle�Ƨǫe����
   System.out.print("\nThe list3 before sort: ");
   for(int i=0;i<list3.length;i++)
    System.out.print(list3[i].getRadius()+" ");

   mergeSort(list3,new GeometricObjectComparator());//�Ƨ�

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

 //merge sort object
 public static <E extends Comparable<E>> void mergeSort(E[] list)
  {
   //�Y�}�C���ץi����
   if(list.length>1)
    {
     //�W�b�����}�C
     E[] firstHalf = (E[])new Comparable[list.length/2];
     System.arraycopy(list,0,firstHalf,0,list.length/2);//�ƻs�W�b��
     mergeSort(firstHalf);//���j�ƧǤW�b��

     //�U�b�����}�C
     int secondHalfLength = list.length - list.length/2;//�U�b���}�lindex
     E[] secondHalf = (E[])new Comparable[secondHalfLength];
     System.arraycopy(list,list.length/2,secondHalf,0,secondHalfLength);//�ƻs�U�b��
     mergeSort(secondHalf);//���j�ƦC�U�b��

     //���X�ƧǦn���}�C
     E[] temp = merge(firstHalf,secondHalf);
     System.arraycopy(temp,0,list,0,temp.length);
    }
  }

 //���X���Ϊ��}�C
 private static <E extends Comparable<E>> E[] merge(E[] list1,E[] list2)
  {
   E[] temp = (E[])new Comparable[list1.length+list2.length];//�Ȧs���}�C

   int current1 = 0;//�W�b��index
   int current2 = 0;//�U�b��index
   int current3 = 0;//�s��}�C��index

   //����W�U��Ӱ}�C�ثeindex��object�j�p
   while(current1 < list1.length && current2 < list2.length)
    {
     //�Y�䤤�@����p �Nobject��J�Ȧs�}�C������index+1
     //�@���������䤤�@��W�L�̤jindex 
     if(list1[current1].compareTo(list2[current2])<0)
      temp[current3++] = list1[current1++];
     else
      temp[current3++] = list2[current2++];
    }

   //�N�ѤU����J�Ȧs�}�C��
   while(current1 < list1.length)
    temp[current3++] = list1[current1++];
   
   while(current2 < list2.length)
    temp[current3++] = list2[current2++];
   
   return temp;
  }

 //mergesort overload
 //�ϥ�Comparator���
 public static <E> void mergeSort(E[] list,Comparator<? super E> comparator)
  {
   if(list.length>1)
    {
     E[] firstHalf = (E[])new Object[list.length/2];
     System.arraycopy(list,0,firstHalf,0,list.length/2);
     mergeSort(firstHalf,comparator);

     int secondHalfLength = list.length - list.length/2;
     E[] secondHalf = (E[])new Object[secondHalfLength];
     System.arraycopy(list,list.length/2,secondHalf,0,secondHalfLength);
     mergeSort(secondHalf,comparator);

     E[] temp = merge(firstHalf,secondHalf,comparator);
     System.arraycopy(temp,0,list,0,temp.length);
    }
  }

 //merge overload
 //�ϥ�Comparator���
 private static <E> E[] merge(E[] list1,E[] list2,Comparator<? super E> comparator)
  {
   E[] temp = (E[])new Object[list1.length+list2.length];

   int current1 = 0;
   int current2 = 0;
   int current3 = 0;

   while(current1 < list1.length && current2 < list2.length)
    {
     if(comparator.compare(list1[current1],list2[current2])<0)
      temp[current3++] = list1[current1++];
     else
      temp[current3++] = list2[current2++];
    }

   while(current1 < list1.length)
    temp[current3++] = list1[current1++];
   
   while(current2 < list2.length)
    temp[current3++] = list2[current2++];
   
   return temp;
  }
}