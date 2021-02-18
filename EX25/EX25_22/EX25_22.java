//Heap clone and equals

public class EX25_22
{
 public static void main(String args[])
  {
   Heap<Integer> heap = new Heap<Integer>(new Integer[]{8,9,2,3,4,1,5,6,7});//最初的heap
   Heap<Integer> heap2 = heap.clone();//複製的heap

   //判斷是否相等
   System.out.println("Check they are equals: "+heap.equals(heap2));
   System.out.println("remove one element from heap2");
   heap.remove();//移除element
   //再一次確認
   System.out.println("check again "+heap.equals(heap2));
  }
}