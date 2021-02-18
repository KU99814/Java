//array list��@

import java.util.*;

public class MyArrayList<E> extends MyAbstractList<E>
{
 public static final int INTITAL_CAPACITY = 16;//��l�j�p
 private E[] data = (E[]) new Object[INTITAL_CAPACITY];//�s���ư}�C 

 //default
 public MyArrayList()
  {}

 public MyArrayList(E[] objects)
  {
   for(int i=0;i<objects.length;i++)
    add(objects[i]);
  }

 //�[�Jelement����windex
 public void add(int index,E e)
  {
   ensureCapacity();//�T�{�}�C�j�p����
 
   //�N���windex����element���Ჾ
   for(int i=size -1;i >=index;i--)
    data[i+1] = data[i];

   //�Nelement��J���windex
   data[index] = e;

   size++;//�j�p+1
  }

 //�T�{�}�C�j�p�O�_����
 private void ensureCapacity()
  {
   //�p�G�}�C�j�p�w��
   if(size>=data.length)
    {
     //�Ч�j���s�}�C
     E[] newData = (E[])(new Object[data.length*2]);
     //�N���e�ƻs��s�}�C
     System.arraycopy(data,0,newData,0,data.length);
     data = newData;
    }
  }

 //�M��list
 public void clear()
  {
   //�Х��s�ťհ}�C
   data = (E[])new Object[INTITAL_CAPACITY];
   size = 0;//�j�p�]��
  }

 //�P�_�O�_�]�telement
 public boolean contains(E e)
  {
   //�ΰj����
   for(int i=0;i<size;i++)
    {
     if(e.equals(data[i]))
      return true;
    }
   
   return false;
  }

 //���o���windex��element
 public E get(int index)
  {
   return data[index];
  }

 //���o���welement��index
 public int indexOf(E e)
  {
   //�ΰj���X 
   for(int i=0;i<size;i++)
    {
     //�Y���۵�element �^��index
     if(e.equals(data[i]))
      return i;
    }

   return -1;//�Y�L �^��-1
  }

  //��Xelement�̫�X�{��index
  public int lastIndexOf(E e)
  {
   //�q�̫�@�Ӷ}�l�j�M
   for(int i=size - 1;i>=0;i--)
    {
     //�۵����ܦ^��index
     if(e.equals(data[i]))
      return i;
    }

   return -1;//�Y�L�۵��^��-1
  }

 //����element
 public E remove(int index)
  {
   //���ŧi�selelemtz��J�n����element
   E e = data[index];

   //�N���windex�᪺element���e��
   for(int j = index;j<size-1;j++)
    data[j] = data[j+1];

   data[size-1] = null;//�̫�@�ӳ]����

   size--;//�j�p-1

   return e;//�^��element
  }

 //�R�� �P����
 public E delete(int index)
  {
   return remove(index);
  }

 //�ܧ���windex��element
 public E set(int index,E e)
  {
   E old = data[index];//�x�s��element
   data[index] = e;//�]���selement
   return old;//�^����element
  }

 //�^��iterator �I�smyArrayListIterator()
 public java.util.Iterator iterator()
  {
   return myArrayListIterator();
  }

 //�^��iterator
 public java.util.Iterator myArrayListIterator()
  {
   return new MyArrayListIterator();
  }

 //inner class iterator
 class MyArrayListIterator implements java.util.Iterator
  {
   private int current = 0;

   public MyArrayListIterator()
    {}
    
  /* public void inorder()
    {
     for(int i=0;i<size;i++)
      {
       list.add(data[i]);
      }
    }*/

   //�P�_�O�_���U�@��
   public boolean hasNext()
    {
     //�Y�ثeindex�p��size �^��true
     if(current < size)
      return true;
     
     return false;
    }

   //�^��element
   public Object next()
    {
     return data[current++];//�^�ǥثeindex �M��current+1
    }

   public void remove()
    {}
  }

 //��ܸ�T
 public String toString()
  {
   StringBuilder result = new StringBuilder("[");//��ܪ��r��

   //�Nelement�[�J�r��   
   for(int i=0;i<size;i++)
    {
     result.append(data[i]);

     if(i < size - 1)
      result.append(", ");
    }

   //�^��
   return result.toString() + "]";
  }
}