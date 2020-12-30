//abstract class list

public abstract class MyAbstractList<E> implements MyList<E>
{
 protected int size = 0;//大小

 //建構子
 protected MyAbstractList()
  {}

 protected MyAbstractList(E[] objects)
  {
   for(int i=0;i<objects.length;i++)
    add(objects[i]);
  }

 //增加element
 public void add(E e)
  {
   add(size,e);
  }

 //判斷是否空
 public boolean isEmpty()
  {
   return size==0;
  }

 //回傳大小
 public int size()
  {
   return size;
  }

 //移除element
 public boolean remove(E e)
  {
   if(indexOf(e) >= 0)//判斷是否存在element 若是 indexOf大於等於0 
    {
     //移除並回傳true
     remove(indexOf(e));
     return true;
    }

   else//若無刪除 回傳false
    return false;
  }

 //將MyList內容全部加入 
 public boolean addAll(MyList otherList)
  {
   if(!otherList.isEmpty())//判斷是否為空
    {
     //若非空 迴圈全部加入
     for(int i=0;i<otherList.size();i++)
      add((E)otherList.get(i));

     return true;//回傳true
    }
   else//若空 回傳false
    return false;
  }

 //移除全部與otherList相同的element
 public boolean removeAll(MyList otherList)
  {
   boolean change = false;//判斷是否變更

   if(!otherList.isEmpty())//尋訪所有element
    {
     for(int i=0;i<otherList.size();i++)
      {
       while(remove((E)otherList.get(i)))//若有相同的element 移除
        {
         change = true;//有移除 改為true
        }
      }
    }

   return change;//回傳是否變更
  }

 //保留相同的element 刪去不同的element
 public boolean retainAll(MyList otherList)
  {
   boolean change = false;//判斷是否變更

   //若otherList不為空 尋訪
   if(!otherList.isEmpty())
    {
     for(int i=0;i<size;i++)
      {
       if(otherList.indexOf((E)get(i))<0)//若在otherList中找不到 移除
        {
         remove(get(i));
         change = true;//已變更 設true
        }
      }
    }   
   
   return change;//回傳是否變更
  }
}  