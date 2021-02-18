//list interface

public interface MyList<E>
{
 public void add(E e);//�[�Jelement

 public void add(int index,E e);//�[�Jelement����windex

 public void clear();//�M��list

 public boolean contains(E e);//�P�_�O�_�]�telement

 public E get(int index);//���o���windex��element

 public int indexOf(E e);//���o���welement�Ҧbindex

 public boolean isEmpty();//�P�_list�O�_����

 public int lastIndexOf(E e);//���oelement�̫�X�{index

 public boolean remove(E e);//����element

 public E remove(int index);//�������windex��element

 public Object set(int index, E e);//�ܧ���windex��element

 public boolean addAll(MyList otherList);//�N�t�@list���e�����[�J

 public boolean removeAll(MyList otherList);//�����t�@list���ۦP�����e

 public boolean retainAll(MyList otherList);//�u�O�d�Potherlist�ۦP��element

 public int size();//list�j�p
}