//tree interface

public interface Tree<E extends Comparable<E>>
{
 public boolean search(E e);//�j�Melement

 public boolean insert(E e);//���Jelement

 public boolean delete(E e);//�R��element

 public void inorder();//���������element

 public void postorder();//��������element

 public void preorder();//���e�����element

 public int getSize();//���o�j�p

 public boolean isEmpty();//�Ntree�M��

 public java.util.Iterator iterator();//���N
}