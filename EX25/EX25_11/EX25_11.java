//Sorting using a heap

public class EX25_11
{
 public static void main(String args[])
  {
   Integer[] list = {8,9,2,3,4,1,5,6,7};//測試陣列

   //顯示一開始順序
   for(int i=0;i<list.length;i++)
    System.out.print(list[i]+" ");
   
   System.out.println();

   //排序
   sort(list);

   //顯示排序後順序
   for(int i=0;i<list.length;i++)
    System.out.print(list[i]+" ");
  }

 //使用heap排序
 public static <E extends Comparable<E>> void sort(E[] list)
  {
   Heap<E> heap = new Heap<E>(list);//將陣列放入heap作排序

   int i = 0;      
   
   //按heap裡的順序取代list
   while(heap.getSize()>0)
    {
     list[i] = heap.remove();//從heap最前面開始一一取代
     i++;
    }
  }
}