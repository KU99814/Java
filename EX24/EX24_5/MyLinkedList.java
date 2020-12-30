//linked list 實作

public class MyLinkedList<E> extends MyAbstractList<E>
{
 private Node<E> head,tail;//頭尾node

 //建構子
 public MyLinkedList()
  {}

 public MyLinkedList(E[] objects)
  {
   super(objects);
  }

 //取得head node的element
 public E getFirst()
  {
   if(size == 0)//如果大小為零 回傳null
    return null;
   else
    return head.element;
  }

 //取得tail node的element
 public E getLast()
  {
   if(size ==0)//如果大小為零 回傳null
    return null;
   else
    return tail.element;
  }

 //加入為第一個node
 public void addFirst(E e)
  {
   Node<E> newNode = new Node<E>(e);//新node 

   newNode.next = head;//指向原本的head
   head = newNode;//指定為新head
   size++;//大小+1

   if(tail == null)//只有一個node head = tail
    tail = head;
  }

 //加為最後一個node
 public void addLast(E e)
  {
   Node<E> newNode = new Node<E>(e);//新的node
   
   //只有一個node 新node = head = tail
   if(tail == null)
    {
     head = newNode;
     tail = head;
    }
   else//若否 
    {
     tail.next = newNode; //tail next 指向新node
     tail = tail.next;//新node設為tail
    }

   size++;//大小+1
  }

 //加入node到指定index
 public void add(int index,E e)
  {
   if(index ==0)//若為空 addFirst
    addFirst(e);
   else if(index >= size)//若指定最後index addLast
    addLast(e);
   else//其他
    {
     Node<E> current = head;//目前node
     
     //將node移動到指定index
     for(int i=1;i<index;i++)
      current = current.next;

     //取出next node
     Node<E> temp = current.next;

     current.next = new Node<E>(e);//current node next指向新node
     (current.next).next = temp;//新node指向舊node
     size++;//大小加1
    }
  }

 //移除最初node
 public E removeFirst()
  {
   if(size==0)//若list為空 回傳null
    return null;
   else
    {
     //取出head node 並將next node指定為head
     Node<E> temp = head;
     head = head.next;
     size--;//大小-1

     //若head為null tail為null
     if(head == null)
      tail = null;
     return temp.element;//回傳移除node的element
    }
  }

 //移除最後的node
 public E removeLast()
  {
   //若為空list 回傳null
   if(size == 0)
    return null;
   else if(size == 1)//若只有一個node
    {
     Node<E> temp = head;//取出node

     //清空
     clear();
     return temp.element;//回傳移除node的element
    }
   else//其他
    {
     Node<E> current = head;//目前node

     //移動到最後node的前一個
     for(int i=0;i<size-2;i++)
      current = current.next;

     //將tail node取出 current node設為tail
     Node<E> temp = tail;
     tail = current;
     tail.next = null;
     size--;//大小-1
     return temp.element;//回傳
    }
  }

 //移除指定index的node
 public E remove(int index)
  {
   if(index < 0 || index >= size)//指定範圍外 回傳null
    return null;
   else if(index ==0)//移除head
    return removeFirst();
   else if(index == size-1)//移除tail
    return removeLast();
   else
    {
     Node<E> previous = head;//目前node

     //移動到指定index前一node   
     for(int i=1;i<index;i++)
      previous = previous.next;
   
     //取出指定node 將目前node next指向目標node next
     Node<E> current = previous.next;
     previous.next = current.next;
     size--;//大小-1
     return current.element;//回傳指定node element
    }
  }

 //顯示資訊
 public String toString()
  {
   StringBuilder result = new StringBuilder("[");//回傳字串
   
   if(head == null)//若空 回傳空字串
    return "";

   Node<E> current = head;//目前node
   
   //一邊移動 一邊將element加到字串
   for(int i=0;i<size;i++)
    {
     result.append(current.element);
     current = current.next;
     if(current != null)
      result.append(", ");
     else
      result.append("]");
    }

   return result.toString();//回傳
  }

 //清空list
 public void clear()
  {
   head = tail = null;//將頭尾設為null
   size = 0;//大小歸零
  }

 //判斷是否包含
 public boolean contains(E e)
  {
   Node<E> current = head;//目前node 從head開始

   //依序移動並判斷element是否相等
   for(int i=0;i<size;i++)
    {
     if((current.element).equals(e))
      return true;
     
     current = current.next;
    }
   return false;
  }

 //取得指定node之element
 public E get(int index)
  {
   Node<E> current = head;//目前node 從head開始

   if(index>=size)//若指定index 大於size null
    return null;

   //移動到指定index
   for(int i=1;i<=index;i++)
    current = current.next;

   return current.element;//回傳element
  }

 //判斷element index
 public int indexOf(E e)
  {
   Node<E> current = head;//目前node 從head開始

   //一邊移動一邊判斷
   for(int i=0;i<size;i++)
    {
     if((current.element).equals(e))
      return i;

     current = current.next;
    }

   return -1;//找不到的話 回傳-1
  }

 //回傳element最後的index
 public int lastIndexOf(E e)
  {
   Node<E> current = head;//目前node 從head開始
   int index = -1;//起始index 若找不到即為-1

   //從head到tail 遇到後面的index中element相同即取代
   for(int i=0;i<size;i++)
    {
     if((current.element).equals(e))
      index = i;

     current = current.next;
    }

   return index;//回傳
  }
 
 //取代指定node的element
 public E set(int index,E e)
  {
   Node<E> current = head;//目前node 從head開始

   if(index >=size || index < 0)//若超過 傳null
    return null;
   
   //移動到指定index
   for(int i=1;i<=index;i++)
    current = current.next;

   E old = current.element;//舊element
   current.element = e;//將node設新element
   return old;//回傳舊element
  }
}