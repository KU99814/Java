//tree node

public class TreeNode<E extends Comparable<E>>
{
 E element;//儲存的object
 TreeNode<E> left; //左子樹
 TreeNode<E> right; //右子樹

 //default
 public TreeNode(E e)
  {
   element = e;
  }
}