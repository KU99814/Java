//abstract tree

public abstract class AbstractTree<E> implements Tree<E>
{
 //���ǴM�X
 public void inorder()
  {}

 //��ǴM�X
 public void postorder()
  {}

 //�e�ǴM�X
 public void preorder()
  {}

 //�P�_tree�O�_����
 public boolean isEmpty()
  {
   return getSize() == 0;//�P�_�j�p
  }

 //���N
 public java.util.Iterator iterator()
  {
   return null;
  }
} 