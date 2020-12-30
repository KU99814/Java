//��@array list

import java.util.*;

public class MyArrayList<E> extends MyAbstractList<E>
{
 public static final int INTITAL_CAPACITY = 16;//��l�̤j�e�q
 private E[] data = (E[]) new Object[INTITAL_CAPACITY]; //�s��}�C

 //�غc�l
 public MyArrayList()
  {}

 public MyArrayList(E[] objects)
  {
   for(int i=0;i<objects.length;i++)
    add(objects[i]);
  }

 //�W�[element
 public void add(int index,E e)
  {
   ensureCapacity();//�T�{�e�q�O�_����
 
   //�Nlist�����windex�H��element�k���@��
   for(int i=size -1;i >=index;i--)
    data[i+1] = data[i];

   data[index] = e;//�Nelement�[�J���windex

   size++;//�j�p+1
  }

 //�T�{�e�q�O�_�����å[�j
 private void ensureCapacity()
  {
   if(size>=data.length)//�Y�e�q����}�C���� �[�j�}�C����
    {
     E[] newData = (E[])(new Object[data.length*2]);//�s�}�C ����2��
     System.arraycopy(data,0,newData,0,data.length);//�ƻs�ª����e
     data = newData;//��}���V�s�}�C
    }
  }

 //�M�Ű}�C
 public void clear()
  {
   data = (E[])new Object[INTITAL_CAPACITY];//�Ű}�C ���׬���l����
   size = 0;//�j�p�k�s
  }

 //�P�_�O�_�]�telement
 public boolean contains(E e)
  {
   //�Y���index �^��true �_�hfalse
   if(indexOf(e)>=0)
    return true;
   else   
    return false;
  }

 //�^�ǫ��windex��element
 public E get(int index)
  {
   return data[index];
  }

 //�M��element��index
 public int indexOf(E e)
  {
   for(int i=0;i<size;i++)
    {
     if(e.equals(data[i]))//�Y�P�_�۵� �^�ǥثeindex
      return i;
    }

   return -1;//�䤣�� �^��-1
  }

 //�M��element�̫�X�{��index 
 public int lastIndexOf(E e)
  {
   //��L�ӱq�̫�}�l
   for(int i=size - 1;i>=0;i--)
    {
     if(e.equals(data[i]))//�P�_�O�_�۵� �^��index
      return i;
    }

   return -1;//�䤣�� �^��-1
  }

 //�������windex��element
 public E remove(int index)
  {
   E e = data[index];//���w��element

   //�N���windex�ᤧelement�����@��
   for(int j = index;j<size-1;j++)
    data[j] = data[j+1];

   data[size-1] = null;//�̥���]��

   size--;//�j�p-1

   return e;//�^�ǲ�����element
  }

 //���N���w��element
 public E set(int index,E e)
  {
   E old = data[index];//�����N��element
   data[index] = e;//���N
   return old;//�^����element
  }

 //��ܪ����T
 public String toString()
  {
   StringBuilder result = new StringBuilder("[");//��ܦr��

   //�Nlist���e�[�J�r��   
   for(int i=0;i<size;i++)
    {
     result.append(data[i]);

     if(i < size - 1)//�[�J�r�����j
      result.append(", ");
    }

   return result.toString() + "]";//�^�Ǧr��
  }
}