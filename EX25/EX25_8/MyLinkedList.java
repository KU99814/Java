//linked list

public class MyLinkedList<E> extends MyAbstractList<E>
{
 private Node<E> head,tail;//�Y��node

 //default
 public MyLinkedList()
  {}

 public MyLinkedList(E[] objects)
  {
   super(objects);
  }

 //�^�ǲĤ@��element
 public E getFirst()
  {
   //�Ysize=0 �^��null
   if(size == 0)
    return null;
   else//�Y��node �^��head��element
    return head.element;
  }

 //�^�ǳ̫᪺element
 public E getLast()
  {
   //�Ysize=0 �^��null
   if(size ==0)
    return null;
   else  //�Y��node �^��head��element
    return tail.element;
  }

 //�[�J���Ĥ@��element
 public void addFirst(E e)
  {
   Node<E> newNode = new Node<E>(e);//�зsnode

   //�snode��next���Vhead
   newNode.next = head;
   head = newNode;//�snode�]��head
   size++;//�j�p+1

   //�Ytail���� 
   if(tail == null)
    tail = head;
  }

 //�[�J���̫᪺element
 public void addLast(E e)
  {
   Node<E> newNode = new Node<E>(e);//�зsnode
   
   //�Ytail���� �snode�]��head�B����tail
   if(tail == null)
    {
     head = newNode;
     tail = head;
    }
   else //�Y�_ �N�snode�]��tail��next
    {
     tail.next = newNode;
     tail = tail.next;
    }

   size++;//�j�p+1
  }

 //�[�Jelement
 public void add(int index,E e)
  {
   //�Yindex��0�γ̤j�� �����I�smethod
   if(index ==0)
    addFirst(e);
   else if(index >= size)
    addLast(e);
   else
    {
     Node<E> current = head;//�ثenode
     
     //�j�骽����windex-1
     for(int i=1;i<index;i++)
      current = current.next;

     
     Node<E> temp = current.next;//�Nindex��node�Ȧs
     current.next = new Node<E>(e);//�ثenode��next���w���snode
     (current.next).next = temp;//�snode��next�w���쥻index��node
     size++;//�j�p+1
    }
  }

 //����head
 public E removeFirst()
  {
   if(size==0)//�Ylist���� �^��null
    return null;
   else
    {
     Node<E> temp = head;//�Ȧshead
     head = head.next;//�Nnext���w��head
     size--;//�j�p-1
     if(head == null)//�Y�u���@��node tail�]�n��null
      tail = null;
     return temp.element;//�^�ǼȦsnode
    }
  }

 //����tail
 public E removeLast()
  {
   if(size == 0)//�Ylist���� �^��null
    return null;
   else if(size == 1)//�Y�u���@��node �Nhead�]�]��null
    {
     Node<E> temp = head;
     head = null;
     tail = null;
     size = 0;//�j�p�M��0
     return temp.element;//�^��element
    }
   else
    {
     Node<E> current = head;//�ثenode

     //���ʨ�tail�e�@��
     for(int i=0;i<size-2;i++)
      current = current.next;

          
     Node<E> temp = tail;//�Ȧstail
     tail = current;//�N�ثenode�]��tail
     tail.next = null;//�Ntail��next�]��null
     size--;//�j�p-1
     return temp.element;//�^��
    }
  }

 //�������windex��element
 public E remove(int index)
  {
   //�W�X�d�� �^��null
   if(index < 0 || index >= size)
    return null;
   //�����Y�� �I�smethod
   else if(index ==0)
    return removeFirst();
   else if(index == size-1)
    return removeLast();
   else
    {
     Node<E> previous = head;//�ؼФ��enode
   
     //���ʨ�index-1
     for(int i=1;i<index;i++)
      previous = previous.next;

      
     Node<E> current = previous.next;//�ؼ�node
     previous.next = current.next;//�N�ؼФ��enode��next�]���ؼ�node��next
     size--;//�j�p-1
     return current.element;//�^��
    }
  }

 //��ܸ�T
 public String toString()
  {
   StringBuilder result = new StringBuilder("[");//�^�Ǫ��r��
   
   if(head == null)//�Ylist���� �^��null
    return "";

   Node<E> current = head;//�ثenode

   //�Nnode��element�[�J�r��   
   for(int i=0;i<size;i++)
    {
     result.append(current.element);
     current = current.next;
     if(current != null)
      result.append(", ");
     else
      result.append("]");
    }

   return result.toString();//�^��
  }

 //�M��list
 public void clear()
  {
   head = tail = null;//�Ntail�Mhead�]��nill
   size = 0;//�j�p=0
  }

 //�P�_�O�_�]�telement
 public boolean contains(E e)
  {
   Node<E> current = head;//�ثenode

   //�j��@�@���
   for(int i=0;i<size;i++)
    {
     if((current.element).equals(e))//�P�_�O�_�۵�
      return true;
     
     current = current.next;//���ʨ�U�@node
    }
   return false;
  }

 //���oelement
 public E get(int index)
  {
   Node<E> current = head;//�ثenode

   //�p�G�W�X�d�� �^��null
   if(index>=size || index < 0)   
    return null;

   //���ʨ���windex
   for(int i=1;i<=index;i++)
    current = current.next;

   return current.element;//�^��
  }

 //��X���welement��index
 public int indexOf(E e)
  {
   Node<E> current = head;//�ثenode

   //�ΰj���X
   for(int i=0;i<size;i++)
    {
     if((current.element).equals(e))//�P�_�O�_�۵� 
      return i;//�p�G�O �^��index

     current = current.next;//���ʨ�U�@��
    }

   return -1;//�S���۵��� �^��-1
  }

 //��X���welement�̫᪺index
 public int lastIndexOf(E e)
  {
   Node<E> current = head;//�ثenode
   int index = -1;//�^�Ǫ�index

   //�ΰj���X
   for(int i=0;i<size;i++)
    {
     if((current.element).equals(e))//�P�_�O�_�۵� �J��᭱��index�N���N��
      index = i;

     current = current.next;//���ʨ�U�@��
    }

   return index;//�^��
  }
 
 //���ܫ��windex��element
 public E set(int index,E e)
  {
   Node<E> current = head;//�ثenode

   //�Ylist���� �^��null
   if(index >=size)
    return null;
 
   //���ʨ���windex  
   for(int i=1;i<=index;i++)
    current = current.next;

   Node<E> old = current;//�Ȧs��node
   current.element = e;//����element
   return old.element;//�^��
  }

 //�R�� �P����method
 public E delete(int index)
  {
   return remove(index);
  }

 //iterator �I�smethod
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

   //�P�_�O�_���U�@��
   public boolean hasNext()
    {
     //�H�ثeindex�@�P�_ �Y�p��size�^��true �_�hfalse
     if(current < size)
      return true;
     
     return false;
    }

   //�^��element
   public Object next()
    {
     return get(current++);//�^�ǨñN���windex+1
    }

   public void remove()
    {}
  }
}