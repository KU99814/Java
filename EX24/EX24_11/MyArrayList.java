//array List implementing by extends java.util.AbstractList

public class MyArrayList<E> extends java.util.AbstractList<E>
{
 public static final int INTITAL_CAPACITY = 16;//��l�e�q
 private E[] data = (E[]) new Object[INTITAL_CAPACITY];//�s���ư}�C
 int size = 0;//�j�p

 //�غc�l
 public MyArrayList()
  {}

 public MyArrayList(E[] objects)
  {
   //�s�J���
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

 //�^�Ǥj�p
 public int size()
  {
   return size;
  }

 //�^�ǫ��windex��element
 public E get(int index)
  {
   return data[index];
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