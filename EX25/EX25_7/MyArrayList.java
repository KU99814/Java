//array list實作

import java.util.*;

public class MyArrayList<E> extends MyAbstractList<E>
{
 public static final int INTITAL_CAPACITY = 16;//初始大小
 private E[] data = (E[]) new Object[INTITAL_CAPACITY];//存放資料陣列 

 //default
 public MyArrayList()
  {}

 public MyArrayList(E[] objects)
  {
   for(int i=0;i<objects.length;i++)
    add(objects[i]);
  }

 //加入element到指定index
 public void add(int index,E e)
  {
   ensureCapacity();//確認陣列大小足夠
 
   //將指定index之後element往後移
   for(int i=size -1;i >=index;i--)
    data[i+1] = data[i];

   //將element放入指定index
   data[index] = e;

   size++;//大小+1
  }

 //確認陣列大小是否足夠
 private void ensureCapacity()
  {
   //如果陣列大小已滿
   if(size>=data.length)
    {
     //創更大的新陣列
     E[] newData = (E[])(new Object[data.length*2]);
     //將內容複製到新陣列
     System.arraycopy(data,0,newData,0,data.length);
     data = newData;
    }
  }

 //清空list
 public void clear()
  {
   //創全新空白陣列
   data = (E[])new Object[INTITAL_CAPACITY];
   size = 0;//大小設為
  }

 //判斷是否包含element
 public boolean contains(E e)
  {
   //用迴圈比對
   for(int i=0;i<size;i++)
    {
     if(e.equals(data[i]))
      return true;
    }
   
   return false;
  }

 //取得指定index的element
 public E get(int index)
  {
   return data[index];
  }

 //取得指定element的index
 public int indexOf(E e)
  {
   //用迴圈找出 
   for(int i=0;i<size;i++)
    {
     //若有相等element 回傳index
     if(e.equals(data[i]))
      return i;
    }

   return -1;//若無 回傳-1
  }

  //找出element最後出現的index
  public int lastIndexOf(E e)
  {
   //從最後一個開始搜尋
   for(int i=size - 1;i>=0;i--)
    {
     //相等的話回傳index
     if(e.equals(data[i]))
      return i;
    }

   return -1;//若無相等回傳-1
  }

 //移除element
 public E remove(int index)
  {
   //先宣告新elelemtz放入要移除element
   E e = data[index];

   //將指定index後的element往前移
   for(int j = index;j<size-1;j++)
    data[j] = data[j+1];

   data[size-1] = null;//最後一個設為空

   size--;//大小-1

   return e;//回傳element
  }

 //刪除 同移除
 public E delete(int index)
  {
   return remove(index);
  }

 //變更指定index的element
 public E set(int index,E e)
  {
   E old = data[index];//儲存舊element
   data[index] = e;//設為新element
   return old;//回傳舊element
  }

 //回傳iterator 呼叫myArrayListIterator()
 public java.util.Iterator iterator()
  {
   return myArrayListIterator();
  }

 //回傳iterator
 public java.util.Iterator myArrayListIterator()
  {
   return new MyArrayListIterator();
  }

 //inner class iterator
 class MyArrayListIterator implements java.util.Iterator
  {
   private int current = 0;

   public MyArrayListIterator()
    {}
    
  /* public void inorder()
    {
     for(int i=0;i<size;i++)
      {
       list.add(data[i]);
      }
    }*/

   //判斷是否有下一個
   public boolean hasNext()
    {
     //若目前index小於size 回傳true
     if(current < size)
      return true;
     
     return false;
    }

   //回傳element
   public Object next()
    {
     return data[current++];//回傳目前index 然後current+1
    }

   public void remove()
    {}
  }

 //顯示資訊
 public String toString()
  {
   StringBuilder result = new StringBuilder("[");//顯示的字串

   //將element加入字串   
   for(int i=0;i<size;i++)
    {
     result.append(data[i]);

     if(i < size - 1)
      result.append(", ");
    }

   //回傳
   return result.toString() + "]";
  }
}