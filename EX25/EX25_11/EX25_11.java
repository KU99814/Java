//Sorting using a heap

public class EX25_11
{
 public static void main(String args[])
  {
   Integer[] list = {8,9,2,3,4,1,5,6,7};//���հ}�C

   //��ܤ@�}�l����
   for(int i=0;i<list.length;i++)
    System.out.print(list[i]+" ");
   
   System.out.println();

   //�Ƨ�
   sort(list);

   //��ܱƧǫᶶ��
   for(int i=0;i<list.length;i++)
    System.out.print(list[i]+" ");
  }

 //�ϥ�heap�Ƨ�
 public static <E extends Comparable<E>> void sort(E[] list)
  {
   Heap<E> heap = new Heap<E>(list);//�N�}�C��Jheap�@�Ƨ�

   int i = 0;      
   
   //��heap�̪����Ǩ��Nlist
   while(heap.getSize()>0)
    {
     list[i] = heap.remove();//�qheap�̫e���}�l�@�@���N
     i++;
    }
  }
}