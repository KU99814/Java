//Generic quick sort

import java.util.*;

public class EX26_3
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
 public static <E extends Comparable<E>> void quickSort(E[] list,int first,int last)
  {
   if(last > first)
    {
     int pivotIndex = partition(list,first,last);//基準點排序後index
     
     //以基準點為界 分兩半作遞迴
     quickSort(list,first,pivotIndex-1);
     quickSort(list,pivotIndex+1,last);
    }
  }

 //分割陣列 實際作排序的method
 private static <E extends Comparable<E>> int partition(E[] list,int first,int last)
  {
   E pivot = list[first];//選取最開頭index作基準
   int low = first + 1;//開始作挑選的index
   int high = last;//最後的index

   while(high > low)
    {
     //從左往右搜尋 比基準大或超過high跳出
     while(low <= high && list[low].compareTo(pivot) <= 0)
      low++;

     //從右往左搜尋 比基準小或超過low跳出
     while(low <= high && list[high].compareTo(pivot) > 0)
      high--;
     
     //交換element
     if(high > low)
      {
       E temp = list[high];
       list[high] = list[low];
       list[low] = temp;
      }
    }

   
   while(high >first && list[high].compareTo(pivot) >= 0)
      high--;
   
   //若較大 將基準與list[high]交換
   if(pivot.compareTo(list[high]) > 0)
      {
       list[first] = list[high];
       list[high] = pivot;
       return high;//回傳基準index
      }
   else
    return first;//回傳基準index
  }

 //quickSort overload
 //使用comparator
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
 //使用comparator
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