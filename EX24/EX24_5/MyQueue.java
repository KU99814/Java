//implementing Queue 

public class MyQueue<E> extends MyLinkedList<E>
{
 //��Jelement
 public void enqueue(E e)
  {
   addFirst(e);//��J���Ĥ@��node
  }

 //��Xelement
 public E dequeue()
  {
   return removeLast();//�����̫�@��element
  }

 //��ܤ��e�j�p
 public int getSize()
  {
   return size;
  }
}