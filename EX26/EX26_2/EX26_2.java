//Generic merge sort

import java.util.*;

public class EX26_2
{
 public static void main(String args[])
  {
   //sort用
   Integer[] list1 = {8,5,6,1,7,9,3,4,2};//int list 比較大小
   String[] list2 = {"B","F","E","X","A","E","H","Y"};//string 比較順序
   Circle [] list3 = new Circle[10];//circle //比較圓面積

   //創建圓物件 隨機決定半徑
   for(int i=0;i<list3.length;i++)
    list3[i] = new Circle((int)(Math.random()*10));

   //顯示int list排序前順序
   System.out.print("The list1 before sort: ");
   for(int i=0;i<list1.length;i++)
    System.out.print(list1[i]+" ");

   mergeSort(list1);//排序

   //顯示int list排序後順序
   System.out.print("\nThe list1 after sort: ");
   for(int i=0;i<list1.length;i++)
    System.out.print(list1[i]+" ");

   //顯示string排序前順序
   System.out.print("\nThe list2 before sort: ");
   for(int i=0;i<list2.length;i++)
    System.out.print(list2[i]+" ");

   mergeSort(list2);//排序

   //顯示string排序後順序
   System.out.print("\nThe list2 after sort: ");
   for(int i=0;i<list2.length;i++)
    System.out.print(list2[i]+" ");

   //顯示circle排序前順序
   System.out.print("\nThe list3 before sort: ");
   for(int i=0;i<list3.length;i++)
    System.out.print(list3[i].getRadius()+" ");

   mergeSort(list3,new GeometricObjectComparator());//排序

   //顯示circle排序後順序
   System.out.print("\nThe list3 after sort: ");
   for(int i=0;i<list3.length;i++)
    System.out.print(list3[i].getRadius()+" ");
  }

 //geometric比較器
 static class GeometricObjectComparator implements Comparator<GeometricObject>
  {
   //default
   public GeometricObjectComparator()
    {}

   //比較
   public int compare(GeometricObject o1, GeometricObject o2)
    {
     return o1.compareTo(o2);
    }
  } 

 //merge sort object
 public static <E extends Comparable<E>> void mergeSort(E[] list)
  {
   //若陣列長度可分割
   if(list.length>1)
    {
     //上半部分陣列
     E[] firstHalf = (E[])new Comparable[list.length/2];
     System.arraycopy(list,0,firstHalf,0,list.length/2);//複製上半部
     mergeSort(firstHalf);//遞迴排序上半部

     //下半部分陣列
     int secondHalfLength = list.length - list.length/2;//下半部開始index
     E[] secondHalf = (E[])new Comparable[secondHalfLength];
     System.arraycopy(list,list.length/2,secondHalf,0,secondHalfLength);//複製下半部
     mergeSort(secondHalf);//遞迴排列下半部

     //結合排序好的陣列
     E[] temp = merge(firstHalf,secondHalf);
     System.arraycopy(temp,0,list,0,temp.length);
    }
  }

 //結合分割的陣列
 private static <E extends Comparable<E>> E[] merge(E[] list1,E[] list2)
  {
   E[] temp = (E[])new Comparable[list1.length+list2.length];//暫存的陣列

   int current1 = 0;//上半部index
   int current2 = 0;//下半部index
   int current3 = 0;//存放陣列的index

   //比較上下兩個陣列目前index的object大小
   while(current1 < list1.length && current2 < list2.length)
    {
     //若其中一邊較小 將object放入暫存陣列中並讓index+1
     //一直比較直到其中一邊超過最大index 
     if(list1[current1].compareTo(list2[current2])<0)
      temp[current3++] = list1[current1++];
     else
      temp[current3++] = list2[current2++];
    }

   //將剩下的放入暫存陣列中
   while(current1 < list1.length)
    temp[current3++] = list1[current1++];
   
   while(current2 < list2.length)
    temp[current3++] = list2[current2++];
   
   return temp;
  }

 //mergesort overload
 //使用Comparator比較
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
 //使用Comparator比較
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