//Min-Heap

public class EX25_10
{
 public static void main(String args[])
  {
   Heap<Integer> heap = new Heap<Integer>(new Integer[]{8,9,2,3,4,1,5,6,7});//建立heap

   //顯示排序
   while(heap.getSize()>0)
    System.out.print(heap.remove() + " ");
  }
}