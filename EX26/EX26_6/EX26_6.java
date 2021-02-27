//Checking order

import java.util.*;

public class EX26_6
{
 public static void main(String args[])
  {
   //int
   int[] list1Unorder = {8,5,6,1,7,9,3,4,2};//非排序list
   int[] list1Ascendorder = {1,2,7,8,9,11,20};//升序list
   int[] list1Descendorder = {9,8,7,6,5,4,3,1};//降序list

   //double
   double[] list2Unorder = {8.3,5.5,6.7,1.1,7.8,7.1,3.2,4.2,3.3};//非排序list
   double[] list2Ascendorder = {1.2,1.3,1.7,8.9,9.5,11.2,20.3};//升序list
   double[] list2Descendorder = {9.7,8.7,7.7,7.6,6.5,4.1,3.2,1.4};//降序list

   //string
   String[] list3Unorder = {"B","F","E","X","A","E","H","Y"};//非排序list
   String[] list3Ascendorder = {"A","D","F","H","I","J","K","L"};//升序list
   String[] list3Descendorder = {"H","G","F","E","D","C","B","A"};//降序list

   //圓 object
   Circle [] list4Unorder = new Circle[10];//非排序list

   //創建非排序list
   for(int i=0;i<list4Unorder.length;i++)
    list4Unorder[i] = new Circle((int)(Math.random()*10));//隨機

   Circle [] list4Ascendorder = new Circle[10];//升序list

   //創建升序list
   for(int i=0;i<list4Ascendorder.length;i++)
    list4Ascendorder[i] = new Circle(i);

   Circle [] list4Descendorder = new Circle[10];//降序list

   //創建降序list
   for(int i=list4Descendorder.length-1,j=0;i>=0;i--,j++)
    list4Descendorder[i] = new Circle(j);

   //list1 int
   //unorder
   System.out.print("list:");
   for(int i=0;i<list1Unorder.length;i++)
    System.out.print(list1Unorder[i]+" ");
   System.out.println("is order? "+ordered(list1Unorder));

   //ascend
   System.out.print("list:");
   for(int i=0;i<list1Ascendorder.length;i++)
    System.out.print(list1Ascendorder[i]+" ");
   System.out.println("is ascendorder? "+ordered(list1Ascendorder));

   //descend
   System.out.print("list:");
   for(int i=0;i<list1Descendorder.length;i++)
    System.out.print(list1Descendorder[i]+" ");
   System.out.println("is descendorder? "+ordered(list1Descendorder,false));

   //list2 double
   //unorder
   System.out.print("list:");
   for(int i=0;i<list2Unorder.length;i++)
    System.out.print(list2Unorder[i]+" ");
   System.out.println("is order? "+ordered(list2Unorder));

   //ascend
   System.out.print("list:");
   for(int i=0;i<list2Ascendorder.length;i++)
    System.out.print(list2Ascendorder[i]+" ");
   System.out.println("is ascendorder? "+ordered(list2Ascendorder,false));

   //descend
   System.out.print("list:");
   for(int i=0;i<list2Descendorder.length;i++)
    System.out.print(list2Descendorder[i]+" ");
   System.out.println("is descendorder? "+ordered(list2Descendorder,true));

   //list3 string
   //unorder
   System.out.print("list:");
   for(int i=0;i<list3Unorder.length;i++)
    System.out.print(list3Unorder[i]+" ");
   System.out.println("is order? "+ordered(list3Unorder));

   //ascend
   System.out.print("list:");
   for(int i=0;i<list3Ascendorder.length;i++)
    System.out.print(list3Ascendorder[i]+" ");
   System.out.println("is ascendorder? "+ordered(list3Ascendorder));

   //descend
   System.out.print("list:");
   for(int i=0;i<list3Descendorder.length;i++)
    System.out.print(list3Descendorder[i]+" ");
   System.out.println("is descendorder? "+ordered(list3Descendorder,false));

   GeometricObjectComparator comparator = new GeometricObjectComparator();//宣告比較器

   //list4 circle object
   //unorder
   System.out.print("list:");
   for(int i=0;i<list4Unorder.length;i++)
    System.out.print(list4Unorder[i].getRadius()+" ");
   System.out.println("is order? "+ordered(list4Unorder,comparator));

   //ascend
   System.out.print("list:");
   for(int i=0;i<list4Ascendorder.length;i++)
    System.out.print(list4Ascendorder[i].getRadius()+" ");
   System.out.println("is ascendorder? "+ordered(list4Ascendorder,comparator));

   //descend
   System.out.print("list:");
   for(int i=0;i<list4Descendorder.length;i++)
    System.out.print(list4Descendorder[i].getRadius()+" ");
   System.out.println("is descendorder? "+ordered(list4Descendorder,comparator,false));
  }

 //geometric 比較器
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

 //int
 //判斷是否排序 預設升序
 public static boolean ordered(int[] list)
  {
   return ordered(list,true);
  }

 //int
 //判斷是否排序 ascending判斷是否為升序
 public static boolean ordered(int[] list,boolean ascending)
  {
   //以升序與否決定如何判斷
   if(ascending)
    {
     for(int i=0;i<list.length-1;i++)
      {
       //遇到前項比後項大 回傳false
       if(list[i]>list[i+1])
        return false;
      }
    }
   else//若ascending為false 為降序
    {
     for(int i=0;i<list.length-1;i++)
      {
       //遇到前項比後項小 回傳false
       if(list[i]<list[i+1])
        return false;
      }
    }

   return true;
  }

 //double
 //判斷是否排序 預設降序
 public static boolean ordered(double[] list)
  {
   return ordered(list,true);
  }

 //double
 //判斷是否排序 descending判斷是否為降序
 public static boolean ordered(double[] list,boolean descending)
  {
   //以降序與否決定如何判斷
   if(descending)
    {
     for(int i=0;i<list.length-1;i++)
      {
       //遇到前項比後項小 回傳false
       if(list[i]<list[i+1])
        return false;
      }
    }
   else
    {
     for(int i=0;i<list.length-1;i++)
      {
       //遇到前項比後項大 回傳false
       if(list[i]>list[i+1])
       return false;
      }
    }

   return true;
  }

 //object
 //判斷是否排序 預設升序
 public static <E extends Comparable<E>> boolean ordered(E[] list)
  {
   return ordered(list,true);
  }

 //object
 //判斷是否排序 ascending判斷是否為升序
 public static <E extends Comparable<E>> boolean ordered(E[] list,boolean ascending)
  {
   //以升序與否決定如何判斷
   if(ascending)
    {
     for(int i=0;i<list.length-1;i++)
      {
       //遇到前項比後項大 回傳false
       if(list[i].compareTo(list[i+1])>0)
        return false;
      }
    }
   else
    {
     for(int i=0;i<list.length-1;i++)
      {
       //遇到前項比後項小 回傳false
       if(list[i].compareTo(list[i+1])<0)
        return false;
      }
    }

   return true;
  }

 //object using comparator
 //判斷是否排序 預設升序
 public static <E> boolean ordered(E[] list,Comparator<? super E> comparator)
  {
   return ordered(list,comparator,true);
  }

 //object using comparator
 //判斷是否排序 ascending判斷是否為升序
 public static <E> boolean ordered(E[] list,Comparator<? super E> comparator
                                                          ,boolean ascending)
  {
   //以升序與否決定如何判斷
   if(ascending)
    {
     for(int i=0;i<list.length-1;i++)
      {
       //遇到前項比後項大 回傳false
       if(comparator.compare(list[i],list[i+1])>0)
        return false;
      }
    }
   else
    {
     for(int i=0;i<list.length-1;i++)
      {
       //遇到前項比後項小 回傳false
       if(comparator.compare(list[i],list[i+1])<0)
        return false;
      }
    }

   return true;
  }
}