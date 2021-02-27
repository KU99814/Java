//Improving quick sort

import java.util.*;

public class EX26_4
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

   quickSort(list1);//排序

   //顯示int list排序後順序
   System.out.print("\nThe list1 after sort: ");
   for(int i=0;i<list1.length;i++)
    System.out.print(list1[i]+" ");

   //顯示string排序前順序
   System.out.print("\nThe list2 before sort: ");
   for(int i=0;i<list2.length;i++)
    System.out.print(list2[i]+" ");

   quickSort(list2);//排序

   //顯示string排序後順序
   System.out.print("\nThe list2 after sort: ");
   for(int i=0;i<list2.length;i++)
    System.out.print(list2[i]+" ");

   //顯示circle排序前順序
   System.out.print("\nThe list3 before sort: ");
   for(int i=0;i<list3.length;i++)
    System.out.print(list3[i].getRadius()+" ");

   quickSort(list3,new GeometricObjectComparator());//排序

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
     
   int mid = first+(last-first) / 2;//取得基準index

   E pivot = list[mid];//基準
   int low = first;//小於基準的index
   int high = last;//大於基準的index

   while(high >= low)
    {
     //比較大小 較小index+1
     while(list[low].compareTo(pivot) < 0)
      low++;

     ////比較大小 較大index-1
     while(list[high].compareTo(pivot) > 0)
      high--;
     
     //交換element 確保左邊的小 右邊的大
     if(high >= low)
      {
       swap(list,low,high);
       low++;
       high--;
      }
    }
  
   //陣列分成兩部分遞迴
   if (first < high)
    quickSort(list, first, high);
   if (last > low)
    quickSort(list, low, last);
  }

 //交換陣列中element
 public static <E extends Comparable<E>> void swap(E[] list,int n1,int n2)
  {
   E temp = list[n1];
   list[n1] = list[n2];
   list[n2] = temp;
  }

 //quick sort overload
 //使用comparator
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