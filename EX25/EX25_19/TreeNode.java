//tree node with parent node

public class TreeNode<E extends Comparable<E>>
{
 E element;//�s�񪫥�
 TreeNode<E> left;//���l��
 TreeNode<E> right;//�k�l��
 TreeNode<E> parent;//�� node

 //default
 public TreeNode(E e)
  {
   element = e;
  }
}