//tree node

public class TreeNode<E extends Comparable<E>>
{
 E element;//�x�s��object
 TreeNode<E> left; //���l��
 TreeNode<E> right; //�k�l��

 //default
 public TreeNode(E e)
  {
   element = e;
  }
}