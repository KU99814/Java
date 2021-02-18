//tree node with parent node

public class TreeNode<E extends Comparable<E>>
{
 E element;//存放物件
 TreeNode<E> left;//左子樹
 TreeNode<E> right;//右子樹
 TreeNode<E> parent;//親 node

 //default
 public TreeNode(E e)
  {
   element = e;
  }
}