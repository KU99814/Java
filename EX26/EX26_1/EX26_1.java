//Generic bubble sort

import java.util.*;

public class EX26_1
{
 public static void main(String args[])
  {
   //sort用
   int[] list1 = {8,5,6,1,7,9,3,4,2};//int list 比較大小
   String[] list2 = {"B","F","E","X","A","E","H","Y"};//string 比較順序
   Circle [] list3 = new Circle[10];//circle //比較圓面積

   //創建圓物件 隨機決定半徑
   for(int i=0;i<list3.length;i++)
    list3[i] = new Circle((int)(Math.random()*10));

   //顯示int list排序前順序
   System.out.print("The list1 before sort: ");
   for(int i=0;i<list1.length;i++)
    System.out.print(list1[i]+" ");

   bubblesort(list1);//排序
   
   //顯示int list排序後順序
   System.out.print("\nThe list1 after sort: ");
   for(int i=0;i<list1.length;i++)
    System.out.print(list1[i]+" ");

   //顯示string排序前順序
   System.out.print("\nThe list2 before sort: ");
   for(int i=0;i<list2.length;i++)
    System.out.print(list2[i]+" ");

   bubblesort(list2);//排序

   //顯示string排序後順序
   System.out.print("\nThe list2 after sort: ");
   for(int i=0;i<list2.length;i++)
    System.out.print(list2[i]+" ");

   //顯示circle排序前順序
   System.out.print("\nThe list3 before sort: ");
   for(int i=0;i<list3.length;i++)
    System.out.print(list3[i].getRadius()+" ");

   bubblesort(list3,new GeometricObjectComparator());//排序

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

 //bubble sort int
 public static void bubblesort(int[] list)
  {
   boolean needNextPass = true;//判斷是否需要排序

   //迴圈   
   for(int k = 1;k<list.length && needNextPass;k++)
    {
     needNextPass = false;//初始化為false
     
     //每次兩兩比較 若有交換過 下一輪繼續排序
     for(int i=0;i<list.length-k;i++)
      {
       if(list[i] > list[i+1])//若第i項>第i+1項
        {
         //交換
         int temp = list[i];
         list[i] = list[i+1];
         list[i+1] = temp;
         needNextPass = true;
        }
      }
    }
  }

 //bubble sort Object
 //排序方法同int 比較時使用compareTo
 public static <E extends Comparable<E>> void bubblesort(E[] list)
  {
   boolean needNextPass = true;
   
   for(int k = 1;k<list.length && needNextPass;k++)
    {
     needNextPass = false;
     
     for(int i=0;i<list.length-k;i++)
      {
       if(list[i].compareTo(list[i+1])>0)
        {
         E temp = list[i];
         list[i] = list[i+1];
         list[i+1] = temp;
         needNextPass = true;
        }
      }
    }
  }

 //bubble sort Object with comparator
 //排序方法同int 比較時使用Comparator.compareTo
 public static <E> void bubblesort(E[] list,Comparator<? super E> comparator)
  {
   boolean needNextPass = true;
   
   for(int k = 1;k<list.length && needNextPass;k++)
    {
     needNextPass = false;
     
     for(int i=0;i<list.length-k;i++)
      {
       if(comparator.compare(list[i],list[i+1])>0)
        {
         E temp = list[i];
         list[i] = list[i+1];
         list[i+1] = temp;
         needNextPass = true;
        }
      }
    }
  }
}