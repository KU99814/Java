//implementing Queue 

public class MyQueue<E> extends MyLinkedList<E>
{
 //放入element
 public void enqueue(E e)
  {
   addFirst(e);//放入為第一個node
  }

 //放出element
 public E dequeue()
  {
   return removeLast();//移除最後一個element
  }

 //顯示內容大小
 public int getSize()
  {
   return size;
  }
}