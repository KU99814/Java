//priority queue implemented by heap

import java.util.Comparator;

public class MyPriorityQueue<E>
{
 private Heap<E> heap;//�x�selement

 private Comparator<? super E> comparator;//�����

 //default
 public MyPriorityQueue(Comparator<? super E> comparator)
  {
   this.comparator = comparator;
   heap = new Heap<E>(comparator);
  }

 //��Jelement 
 public void enqueue(E newObject)
  {
   heap.add(newObject);
  }

 //��Xelement
 public E dequeue()
  {
   return heap.remove();
  }

 //�j�p
 public int getSize()
  {
   return heap.getSize();
  }
}