//linked list ��@

public class MyLinkedList<E> extends MyAbstractList<E>
{
 private Node<E> head,tail;//�Y��node

 //�غc�l
 public MyLinkedList()
  {}

 public MyLinkedList(E[] objects)
  {
   super(objects);
  }

 //���ohead node��element
 public E getFirst()
  {
   if(size == 0)//�p�G�j�p���s �^��null
    return null;
   else
    return head.element;
  }

 //���otail node��element
 public E getLast()
  {
   if(size ==0)//�p�G�j�p���s �^��null
    return null;
   else
    return tail.element;
  }

 //�[�J���Ĥ@��node
 public void addFirst(E e)
  {
   Node<E> newNode = new Node<E>(e);//�snode 

   newNode.next = head;//���V�쥻��head
   head = newNode;//���w���shead
   size++;//�j�p+1

   if(tail == null)//�u���@��node head = tail
    tail = head;
  }

 //�[���̫�@��node
 public void addLast(E e)
  {
   Node<E> newNode = new Node<E>(e);//�s��node
   
   //�u���@��node �snode = head = tail
   if(tail == null)
    {
     head = newNode;
     tail = head;
    }
   else//�Y�_ 
    {
     tail.next = newNode; //tail next ���V�snode
     tail = tail.next;//�snode�]��tail
    }

   size++;//�j�p+1
  }

 //�[�Jnode����windex
 public void add(int index,E e)
  {
   if(index ==0)//�Y���� addFirst
    addFirst(e);
   else if(index >= size)//�Y���w�̫�index addLast
    addLast(e);
   else//��L
    {
     Node<E> current = head;//�ثenode
     
     //�Nnode���ʨ���windex
     for(int i=1;i<index;i++)
      current = current.next;

     //���Xnext node
     Node<E> temp = current.next;

     current.next = new Node<E>(e);//current node next���V�snode
     (current.next).next = temp;//�snode���V��node
     size++;//�j�p�[1
    }
  }

 //�����̪�node
 public E removeFirst()
  {
   if(size==0)//�Ylist���� �^��null
    return null;
   else
    {
     //���Xhead node �ñNnext node���w��head
     Node<E> temp = head;
     head = head.next;
     size--;//�j�p-1

     //�Yhead��null tail��null
     if(head == null)
      tail = null;
     return temp.element;//�^�ǲ���node��element
    }
  }

 //�����̫᪺node
 public E removeLast()
  {
   //�Y����list �^��null
   if(size == 0)
    return null;
   else if(size == 1)//�Y�u���@��node
    {
     Node<E> temp = head;//���Xnode

     //�M��
     clear();
     return temp.element;//�^�ǲ���node��element
    }
   else//��L
    {
     Node<E> current = head;//�ثenode

     //���ʨ�̫�node���e�@��
     for(int i=0;i<size-2;i++)
      current = current.next;

     //�Ntail node���X current node�]��tail
     Node<E> temp = tail;
     tail = current;
     tail.next = null;
     size--;//�j�p-1
     return temp.element;//�^��
    }
  }

 //�������windex��node
 public E remove(int index)
  {
   if(index < 0 || index >= size)//���w�d��~ �^��null
    return null;
   else if(index ==0)//����head
    return removeFirst();
   else if(index == size-1)//����tail
    return removeLast();
   else
    {
     Node<E> previous = head;//�ثenode

     //���ʨ���windex�e�@node   
     for(int i=1;i<index;i++)
      previous = previous.next;
   
     //���X���wnode �N�ثenode next���V�ؼ�node next
     Node<E> current = previous.next;
     previous.next = current.next;
     size--;//�j�p-1
     return current.element;//�^�ǫ��wnode element
    }
  }

 //��ܸ�T
 public String toString()
  {
   StringBuilder result = new StringBuilder("[");//�^�Ǧr��
   
   if(head == null)//�Y�� �^�ǪŦr��
    return "";

   Node<E> current = head;//�ثenode
   
   //�@�䲾�� �@��Nelement�[��r��
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
   head = tail = null;//�N�Y���]��null
   size = 0;//�j�p�k�s
  }

 //�P�_�O�_�]�t
 public boolean contains(E e)
  {
   Node<E> current = head;//�ثenode �qhead�}�l

   //�̧ǲ��ʨçP�_element�O�_�۵�
   for(int i=0;i<size;i++)
    {
     if((current.element).equals(e))
      return true;
     
     current = current.next;
    }
   return false;
  }

 //���o���wnode��element
 public E get(int index)
  {
   Node<E> current = head;//�ثenode �qhead�}�l

   if(index>=size)//�Y���windex �j��size null
    return null;

   //���ʨ���windex
   for(int i=1;i<=index;i++)
    current = current.next;

   return current.element;//�^��element
  }

 //�P�_element index
 public int indexOf(E e)
  {
   Node<E> current = head;//�ثenode �qhead�}�l

   //�@�䲾�ʤ@��P�_
   for(int i=0;i<size;i++)
    {
     if((current.element).equals(e))
      return i;

     current = current.next;
    }

   return -1;//�䤣�쪺�� �^��-1
  }

 //�^��element�̫᪺index
 public int lastIndexOf(E e)
  {
   Node<E> current = head;//�ثenode �qhead�}�l
   int index = -1;//�_�lindex �Y�䤣��Y��-1

   //�qhead��tail �J��᭱��index��element�ۦP�Y���N
   for(int i=0;i<size;i++)
    {
     if((current.element).equals(e))
      index = i;

     current = current.next;
    }

   return index;//�^��
  }
 
 //���N���wnode��element
 public E set(int index,E e)
  {
   Node<E> current = head;//�ثenode �qhead�}�l

   if(index >=size || index < 0)//�Y�W�L ��null
    return null;
   
   //���ʨ���windex
   for(int i=1;i<=index;i++)
    current = current.next;

   E old = current.element;//��element
   current.element = e;//�Nnode�]�selement
   return old;//�^����element
  }
}