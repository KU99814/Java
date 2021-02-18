//linked list

public class MyLinkedList<E> extends MyAbstractList<E>
{
 private Node<E> head,tail;//頭尾node

 //default
 public MyLinkedList()
  {}

 public MyLinkedList(E[] objects)
  {
   super(objects);
  }

 //回傳第一個element
 public E getFirst()
  {
   //若size=0 回傳null
   if(size == 0)
    return null;
   else//若有node 回傳head的element
    return head.element;
  }

 //回傳最後的element
 public E getLast()
  {
   //若size=0 回傳null
   if(size ==0)
    return null;
   else  //若有node 回傳head的element
    return tail.element;
  }

 //加入為第一個element
 public void addFirst(E e)
  {
   Node<E> newNode = new Node<E>(e);//創新node

   //新node的next指向head
   newNode.next = head;
   head = newNode;//新node設為head
   size++;//大小+1

   //若tail為空 
   if(tail == null)
    tail = head;
  }

 //加入為最後的element
 public void addLast(E e)
  {
   Node<E> newNode = new Node<E>(e);//創新node
   
   //若tail為空 新node設為head且等於tail
   if(tail == null)
    {
     head = newNode;
     tail = head;
    }
   else //若否 將新node設為tail的next
    {
     tail.next = newNode;
     tail = tail.next;
    }

   size++;//大小+1
  }

 //加入element
 public void add(int index,E e)
  {
   //若index為0或最大值 直接呼叫method
   if(index ==0)
    addFirst(e);
   else if(index >= size)
    addLast(e);
   else
    {
     Node<E> current = head;//目前node
     
     //迴圈直到指定index-1
     for(int i=1;i<index;i++)
      current = current.next;

     
     Node<E> temp = current.next;//將index的node暫存
     current.next = new Node<E>(e);//目前node的next指定為新node
     (current.next).next = temp;//新node的next定為原本index的node
     size++;//大小+1
    }
  }

 //移除head
 public E removeFirst()
  {
   if(size==0)//若list為空 回傳null
    return null;
   else
    {
     Node<E> temp = head;//暫存head
     head = head.next;//將next指定為head
     size--;//大小-1
     if(head == null)//若只有一個node tail也要為null
      tail = null;
     return temp.element;//回傳暫存node
    }
  }

 //移除tail
 public E removeLast()
  {
   if(size == 0)//若list為空 回傳null
    return null;
   else if(size == 1)//若只有一個node 將head也設為null
    {
     Node<E> temp = head;
     head = null;
     tail = null;
     size = 0;//大小清為0
     return temp.element;//回傳element
    }
   else
    {
     Node<E> current = head;//目前node

     //移動到tail前一個
     for(int i=0;i<size-2;i++)
      current = current.next;

          
     Node<E> temp = tail;//暫存tail
     tail = current;//將目前node設為tail
     tail.next = null;//將tail的next設為null
     size--;//大小-1
     return temp.element;//回傳
    }
  }

 //移除指定index的element
 public E remove(int index)
  {
   //超出範圍 回傳null
   if(index < 0 || index >= size)
    return null;
   //移除頭尾 呼叫method
   else if(index ==0)
    return removeFirst();
   else if(index == size-1)
    return removeLast();
   else
    {
     Node<E> previous = head;//目標之前node
   
     //移動到index-1
     for(int i=1;i<index;i++)
      previous = previous.next;

      
     Node<E> current = previous.next;//目標node
     previous.next = current.next;//將目標之前node的next設為目標node的next
     size--;//大小-1
     return current.element;//回傳
    }
  }

 //顯示資訊
 public String toString()
  {
   StringBuilder result = new StringBuilder("[");//回傳的字串
   
   if(head == null)//若list為空 回傳null
    return "";

   Node<E> current = head;//目前node

   //將node內element加入字串   
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
   head = tail = null;//將tail和head設為nill
   size = 0;//大小=0
  }

 //判斷是否包含element
 public boolean contains(E e)
  {
   Node<E> current = head;//目前node

   //迴圈一一比對
   for(int i=0;i<size;i++)
    {
     if((current.element).equals(e))//判斷是否相等
      return true;
     
     current = current.next;//移動到下一node
    }
   return false;
  }

 //取得element
 public E get(int index)
  {
   Node<E> current = head;//目前node

   //如果超出範圍 回傳null
   if(index>=size || index < 0)   
    return null;

   //移動到指定index
   for(int i=1;i<=index;i++)
    current = current.next;

   return current.element;//回傳
  }

 //找出指定element的index
 public int indexOf(E e)
  {
   Node<E> current = head;//目前node

   //用迴圈找出
   for(int i=0;i<size;i++)
    {
     if((current.element).equals(e))//判斷是否相等 
      return i;//如果是 回傳index

     current = current.next;//移動到下一個
    }

   return -1;//沒有相等的 回傳-1
  }

 //找出指定element最後的index
 public int lastIndexOf(E e)
  {
   Node<E> current = head;//目前node
   int index = -1;//回傳的index

   //用迴圈找出
   for(int i=0;i<size;i++)
    {
     if((current.element).equals(e))//判斷是否相等 遇到後面的index就取代掉
      index = i;

     current = current.next;//移動到下一個
    }

   return index;//回傳
  }
 
 //改變指定index的element
 public E set(int index,E e)
  {
   Node<E> current = head;//目前node

   //若list為空 回傳null
   if(index >=size)
    return null;
 
   //移動到指定index  
   for(int i=1;i<=index;i++)
    current = current.next;

   Node<E> old = current;//暫存舊node
   current.element = e;//改變element
   return old.element;//回傳
  }

 //刪除 同移除method
 public E delete(int index)
  {
   return remove(index);
  }

 //iterator 呼叫method
 public java.util.Iterator iterator()
  {
   return myLinkedListIterator();
  }

 //iterator
 public java.util.Iterator myLinkedListIterator()
  {
   return new MyLinkedListIterator();
  }

 //inner class iterator
 class MyLinkedListIterator implements java.util.Iterator
  {
   private int current = 0;

   //default
   public MyLinkedListIterator()
    {}

   //判斷是否有下一個
   public boolean hasNext()
    {
     //以目前index作判斷 若小於size回傳true 否則false
     if(current < size)
      return true;
     
     return false;
    }

   //回傳element
   public Object next()
    {
     return get(current++);//回傳並將指定index+1
    }

   public void remove()
    {}
  }
}