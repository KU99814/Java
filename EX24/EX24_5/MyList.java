//list interface

public interface MyList<E>
{
 public void add(E e);//加入element

 public void add(int index,E e);//按index加入element

 public void clear();//清空list

 public boolean contains(E e);//是否包含element

 public E get(int index);//取得index上之element

 public int indexOf(E e);//對應element之index

 public boolean isEmpty();//是否為空

 public int lastIndexOf(E e);//element最後出現的index

 public boolean remove(E e);//移除element

 public E remove(int index);//移除指定index的element

 public Object set(int index, E e);//重寫指定index的element

 public boolean addAll(MyList otherList);//加入MyList的所有element

 public boolean removeAll(MyList otherList);//移除MyList中的相同element

 public boolean retainAll(MyList otherList);//將內容中相同的保留 不同的刪除

 public int size();//MyList大小
}