//abstract list class

public abstract class MyAbstractList<E> implements MyList<E>
{
 protected int size = 0;//內容大小

 //default
 protected MyAbstractList()
  {}

 protected MyAbstractList(E[] objects)
  {
   for(int i=0;i<objects.length;i++)
    add(objects[i]);
  }

 //加入element
 public void add(E e)
  {
   add(size,e);
  }

 //判斷是否為空
 public boolean isEmpty()
  {
   return size==0;
  }

 //回傳list大小
 public int size()
  {
   return size;
  }

 //移除element
 public boolean remove(E e)
  {
   //若內部有相同element 移除
   if(indexOf(e) >= 0)
    {
     remove(indexOf(e));
     return true;//回傳true
    }

   //若無 回傳false
   else
    return false;
  }

 //將otherlist內容全部加入
 public boolean addAll(MyList otherList)
  {
   //若otherlist不為空
   if(!otherList.isEmpty())
    {
     //迴圈將內容全部加入
     for(int i=0;i<otherList.size();i++)
      add((E)otherList.get(i));

     return true;//回傳true
    }
   
   //若為空 回傳false
   else
    return false;
  }


 //將與otherlist內容相同element全部移除
 public boolean removeAll(MyList otherList)
  {
   //若otherlist不為空
   if(!otherList.isEmpty())
    {
     //迴圈取出全部element 
     for(int i=0;i<otherList.size();i++)
      {
       //移除存在於list中之element
       while(remove((E)otherList.get(i)))
        {}
      }
     return true;//回傳 true
    }

   //若為空 回傳false
   else
    return false;
  }

 //將不在otherlist中的element移除
 public boolean retainAll(MyList otherList)
  {
   //若other1ist不為空
   if(!otherList.isEmpty())
    {
     //迴圈尋訪 將兩個list中element一一比對
     for(int i=0;i<size;i++)
      {
       boolean retain = false;//判斷是否包含
       for(int j=0;j<otherList.size();j++)
        {
         if(contains((E)otherList.get(i)))
          retain = true;
        }

       //若不包含 移除element       
       if(!retain)
        {
         remove(i);
         i--;
        }
      }   
     return true;//回傳true
    }
 
   //若為空 回傳false
   else
    return false;
  }
}  