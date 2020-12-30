//list interface

public interface MyList<E>
{
 public void add(E e);//�[�Jelement

 public void add(int index,E e);//��index�[�Jelement

 public void clear();//�M��list

 public boolean contains(E e);//�O�_�]�telement

 public E get(int index);//���oindex�W��element

 public int indexOf(E e);//����element��index

 public boolean isEmpty();//�O�_����

 public int lastIndexOf(E e);//element�̫�X�{��index

 public boolean remove(E e);//����element

 public E remove(int index);//�������windex��element

 public Object set(int index, E e);//���g���windex��element

 public boolean addAll(MyList otherList);//�[�JMyList���Ҧ�element

 public boolean removeAll(MyList otherList);//����MyList�����ۦPelement

 public boolean retainAll(MyList otherList);//�N���e���ۦP���O�d ���P���R��

 public int size();//MyList�j�p
}