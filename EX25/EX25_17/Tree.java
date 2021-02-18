//tree interface

public interface Tree<E extends Comparable<E>>
{
 public boolean search(E e);//搜尋element

 public boolean insert(E e);//插入element

 public boolean delete(E e);//刪除element

 public void inorder();//按中序顯示element

 public void postorder();//按後序顯示element

 public void preorder();//按前序顯示element

 public int getSize();//取得大小

 public boolean isEmpty();//將tree清空

 public java.util.Iterator iterator();//迭代
}