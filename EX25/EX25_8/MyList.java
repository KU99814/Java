//list interface

public interface MyList<E>
{
 public void add(E e);//加入element

 public void add(int index,E e);//加入element到指定index

 public void clear();//清空list

 public boolean contains(E e);//判斷是否包含element

 public E get(int index);//取得指定index的element

 public int indexOf(E e);//取得指定element所在index

 public boolean isEmpty();//判斷list是否為空

 public int lastIndexOf(E e);//取得element最後出現index

 public boolean remove(E e);//移除element

 public E remove(int index);//移除指定index的element

 public Object set(int index, E e);//變更指定index的element

 public boolean addAll(MyList otherList);//將另一list內容全部加入

 public boolean removeAll(MyList otherList);//移除另一list中相同的內容

 public boolean retainAll(MyList otherList);//只保留與otherlist相同的element

 public int size();//list大小
}