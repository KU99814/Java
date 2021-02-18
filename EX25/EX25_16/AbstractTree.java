//abstract tree

public abstract class AbstractTree<E> implements Tree<E>
{
 //中序尋訪
 public void inorder()
  {}

 //後序尋訪
 public void postorder()
  {}

 //前序尋訪
 public void preorder()
  {}

 //判斷tree是否為空
 public boolean isEmpty()
  {
   return getSize() == 0;//判斷大小
  }

 //迭代
 public java.util.Iterator iterator()
  {
   return null;
  }
} 