//array List implementing by extends java.util.AbstractList

public class MyArrayList<E> extends java.util.AbstractList<E>
{
 public static final int INTITAL_CAPACITY = 16;//初始容量
 private E[] data = (E[]) new Object[INTITAL_CAPACITY];//存放資料陣列
 int size = 0;//大小

 //建構子
 public MyArrayList()
  {}

 public MyArrayList(E[] objects)
  {
   //存入資料
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

 //回傳大小
 public int size()
  {
   return size;
  }

 //回傳指定index之element
 public E get(int index)
  {
   return data[index];
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