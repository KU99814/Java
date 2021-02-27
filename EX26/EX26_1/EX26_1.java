//Generic bubble sort

import java.util.*;

public class EX26_1
{
 public static void main(String args[])
  {
   //sort��
   int[] list1 = {8,5,6,1,7,9,3,4,2};//int list ����j�p
   String[] list2 = {"B","F","E","X","A","E","H","Y"};//string �������
   Circle [] list3 = new Circle[10];//circle //����ꭱ�n

   //�Ыضꪫ�� �H���M�w�b�|
   for(int i=0;i<list3.length;i++)
    list3[i] = new Circle((int)(Math.random()*10));

   //���int list�Ƨǫe����
   System.out.print("The list1 before sort: ");
   for(int i=0;i<list1.length;i++)
    System.out.print(list1[i]+" ");

   bubblesort(list1);//�Ƨ�
   
   //���int list�Ƨǫᶶ��
   System.out.print("\nThe list1 after sort: ");
   for(int i=0;i<list1.length;i++)
    System.out.print(list1[i]+" ");

   //���string�Ƨǫe����
   System.out.print("\nThe list2 before sort: ");
   for(int i=0;i<list2.length;i++)
    System.out.print(list2[i]+" ");

   bubblesort(list2);//�Ƨ�

   //���string�Ƨǫᶶ��
   System.out.print("\nThe list2 after sort: ");
   for(int i=0;i<list2.length;i++)
    System.out.print(list2[i]+" ");

   //���circle�Ƨǫe����
   System.out.print("\nThe list3 before sort: ");
   for(int i=0;i<list3.length;i++)
    System.out.print(list3[i].getRadius()+" ");

   bubblesort(list3,new GeometricObjectComparator());//�Ƨ�

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

 //bubble sort int
 public static void bubblesort(int[] list)
  {
   boolean needNextPass = true;//�P�_�O�_�ݭn�Ƨ�

   //�j��   
   for(int k = 1;k<list.length && needNextPass;k++)
    {
     needNextPass = false;//��l�Ƭ�false
     
     //�C������� �Y���洫�L �U�@���~��Ƨ�
     for(int i=0;i<list.length-k;i++)
      {
       if(list[i] > list[i+1])//�Y��i��>��i+1��
        {
         //�洫
         int temp = list[i];
         list[i] = list[i+1];
         list[i+1] = temp;
         needNextPass = true;
        }
      }
    }
  }

 //bubble sort Object
 //�ƧǤ�k�Pint ����ɨϥ�compareTo
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
 //�ƧǤ�k�Pint ����ɨϥ�Comparator.compareTo
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