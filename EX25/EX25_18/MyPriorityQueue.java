//priority queue implemented by heap

import java.util.Comparator;

public class MyPriorityQueue<E>
{
 private Heap<E> heap;//儲存element

 private Comparator<? super E> comparator;//比較器

 //default
 public MyPriorityQueue(Comparator<? super E> comparator)
  {
   this.comparator = comparator;
   heap = new Heap<E>(comparator);
  }

 //放入element 
 public void enqueue(E newObject)
  {
   heap.add(newObject);
  }

 //放出element
 public E dequeue()
  {
   return heap.remove();
  }

 //大小
 public int getSize()
  {
   return heap.getSize();
  }
}