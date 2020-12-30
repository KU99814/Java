//實作array list

import java.util.*;

public class MyArrayList<E> extends MyAbstractList<E>
{
 public static final int INTITAL_CAPACITY = 16;//初始最大容量
 private E[] data = (E[]) new Object[INTITAL_CAPACITY]; //存放陣列

 //建構子
 public MyArrayList()
  {}

 public MyArrayList(E[] objects)
  {
   for(int i=0;i<objects.length;i++)
    add(objects[i]);
  }

 //增加element
 public void add(int index,E e)
  {
   ensureCapacity();//確認容量是否足夠
 
   //將list內指定index以後element右移一位
   for(int i=size -1;i >=index;i--)
    data[i+1] = data[i];

   data[index] = e;//將element加入指定index

   size++;//大小+1
  }

 //確認容量是否足夠並加大
 private void ensureCapacity()
  {
   if(size>=data.length)//若容量等於陣列長度 加大陣列長度
    {
     E[] newData = (E[])(new Object[data.length*2]);//新陣列 長度2倍
     System.arraycopy(data,0,newData,0,data.length);//複製舊的內容
     data = newData;//位址指向新陣列
    }
  }

 //清空陣列
 public void clear()
  {
   data = (E[])new Object[INTITAL_CAPACITY];//空陣列 長度為初始長度
   size = 0;//大小歸零
  }

 //判斷是否包含element
 public boolean contains(E e)
  {
   //若找到index 回傳true 否則false
   if(indexOf(e)>=0)
    return true;
   else   
    return false;
  }

 //回傳指定index之element
 public E get(int index)
  {
   return data[index];
  }

 //尋找element之index
 public int indexOf(E e)
  {
   for(int i=0;i<size;i++)
    {
     if(e.equals(data[i]))//若判斷相等 回傳目前index
      return i;
    }

   return -1;//找不到 回傳-1
  }

 //尋找element最後出現的index 
 public int lastIndexOf(E e)
  {
   //到過來從最後開始
   for(int i=size - 1;i>=0;i--)
    {
     if(e.equals(data[i]))//判斷是否相等 回傳index
      return i;
    }

   return -1;//找不到 回傳-1
  }

 //移除指定index之element
 public E remove(int index)
  {
   E e = data[index];//指定之element

   //將指定index後之element左移一位
   for(int j = index;j<size-1;j++)
    data[j] = data[j+1];

   data[size-1] = null;//最末位設空

   size--;//大小-1

   return e;//回傳移除之element
  }

 //取代指定的element
 public E set(int index,E e)
  {
   E old = data[index];//欲取代之element
   data[index] = e;//取代
   return old;//回傳舊element
  }

 //顯示物件資訊
 public String toString()
  {
   StringBuilder result = new StringBuilder("[");//顯示字串

   //將list內容加入字串   
   for(int i=0;i<size;i++)
    {
     result.append(data[i]);

     if(i < size - 1)//加入逗號間隔
      result.append(", ");
    }

   return result.toString() + "]";//回傳字串
  }
}