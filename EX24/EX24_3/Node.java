//double linked list node

public class Node<E>
{
 E element;//內容
 Node<E> prev;//前一node
 Node<E> next;//後一node

 //建構子
 public Node(E e)
  {
   element = e;
  }
} 