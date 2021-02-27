//Checking order

import java.util.*;

public class EX26_6
{
 public static void main(String args[])
  {
   //int
   int[] list1Unorder = {8,5,6,1,7,9,3,4,2};//�D�Ƨ�list
   int[] list1Ascendorder = {1,2,7,8,9,11,20};//�ɧ�list
   int[] list1Descendorder = {9,8,7,6,5,4,3,1};//����list

   //double
   double[] list2Unorder = {8.3,5.5,6.7,1.1,7.8,7.1,3.2,4.2,3.3};//�D�Ƨ�list
   double[] list2Ascendorder = {1.2,1.3,1.7,8.9,9.5,11.2,20.3};//�ɧ�list
   double[] list2Descendorder = {9.7,8.7,7.7,7.6,6.5,4.1,3.2,1.4};//����list

   //string
   String[] list3Unorder = {"B","F","E","X","A","E","H","Y"};//�D�Ƨ�list
   String[] list3Ascendorder = {"A","D","F","H","I","J","K","L"};//�ɧ�list
   String[] list3Descendorder = {"H","G","F","E","D","C","B","A"};//����list

   //�� object
   Circle [] list4Unorder = new Circle[10];//�D�Ƨ�list

   //�ЫثD�Ƨ�list
   for(int i=0;i<list4Unorder.length;i++)
    list4Unorder[i] = new Circle((int)(Math.random()*10));//�H��

   Circle [] list4Ascendorder = new Circle[10];//�ɧ�list

   //�Ыؤɧ�list
   for(int i=0;i<list4Ascendorder.length;i++)
    list4Ascendorder[i] = new Circle(i);

   Circle [] list4Descendorder = new Circle[10];//����list

   //�Ыح���list
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

   GeometricObjectComparator comparator = new GeometricObjectComparator();//�ŧi�����

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

 //geometric �����
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

 //int
 //�P�_�O�_�Ƨ� �w�]�ɧ�
 public static boolean ordered(int[] list)
  {
   return ordered(list,true);
  }

 //int
 //�P�_�O�_�Ƨ� ascending�P�_�O�_���ɧ�
 public static boolean ordered(int[] list,boolean ascending)
  {
   //�H�ɧǻP�_�M�w�p��P�_
   if(ascending)
    {
     for(int i=0;i<list.length-1;i++)
      {
       //�J��e����ᶵ�j �^��false
       if(list[i]>list[i+1])
        return false;
      }
    }
   else//�Yascending��false ������
    {
     for(int i=0;i<list.length-1;i++)
      {
       //�J��e����ᶵ�p �^��false
       if(list[i]<list[i+1])
        return false;
      }
    }

   return true;
  }

 //double
 //�P�_�O�_�Ƨ� �w�]����
 public static boolean ordered(double[] list)
  {
   return ordered(list,true);
  }

 //double
 //�P�_�O�_�Ƨ� descending�P�_�O�_������
 public static boolean ordered(double[] list,boolean descending)
  {
   //�H���ǻP�_�M�w�p��P�_
   if(descending)
    {
     for(int i=0;i<list.length-1;i++)
      {
       //�J��e����ᶵ�p �^��false
       if(list[i]<list[i+1])
        return false;
      }
    }
   else
    {
     for(int i=0;i<list.length-1;i++)
      {
       //�J��e����ᶵ�j �^��false
       if(list[i]>list[i+1])
       return false;
      }
    }

   return true;
  }

 //object
 //�P�_�O�_�Ƨ� �w�]�ɧ�
 public static <E extends Comparable<E>> boolean ordered(E[] list)
  {
   return ordered(list,true);
  }

 //object
 //�P�_�O�_�Ƨ� ascending�P�_�O�_���ɧ�
 public static <E extends Comparable<E>> boolean ordered(E[] list,boolean ascending)
  {
   //�H�ɧǻP�_�M�w�p��P�_
   if(ascending)
    {
     for(int i=0;i<list.length-1;i++)
      {
       //�J��e����ᶵ�j �^��false
       if(list[i].compareTo(list[i+1])>0)
        return false;
      }
    }
   else
    {
     for(int i=0;i<list.length-1;i++)
      {
       //�J��e����ᶵ�p �^��false
       if(list[i].compareTo(list[i+1])<0)
        return false;
      }
    }

   return true;
  }

 //object using comparator
 //�P�_�O�_�Ƨ� �w�]�ɧ�
 public static <E> boolean ordered(E[] list,Comparator<? super E> comparator)
  {
   return ordered(list,comparator,true);
  }

 //object using comparator
 //�P�_�O�_�Ƨ� ascending�P�_�O�_���ɧ�
 public static <E> boolean ordered(E[] list,Comparator<? super E> comparator
                                                          ,boolean ascending)
  {
   //�H�ɧǻP�_�M�w�p��P�_
   if(ascending)
    {
     for(int i=0;i<list.length-1;i++)
      {
       //�J��e����ᶵ�j �^��false
       if(comparator.compare(list[i],list[i+1])>0)
        return false;
      }
    }
   else
    {
     for(int i=0;i<list.length-1;i++)
      {
       //�J��e����ᶵ�p �^��false
       if(comparator.compare(list[i],list[i+1])<0)
        return false;
      }
    }

   return true;
  }
}