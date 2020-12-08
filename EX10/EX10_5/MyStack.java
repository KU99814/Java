public class MyStack
{
 private java.util.ArrayList list = new java.util.ArrayList();// 存放陣列

 //建構子
 public MyStack()
  {}
 
 //判斷是否空
 public boolean isEmpty()   
  {
   return list.isEmpty();
  }
  
 //取得大小
 public int getSize()
  {
   return list.size();
  }

 //回傳頂端
 public Object peek()
  {
   return list.get(getSize()-1);
  }

 //取出
 public Object pop()
  {
   Object o = list.get(getSize()-1);
   list.remove(getSize() - 1);
   return o;
  }
 
 //放入
 public Object push(Object o)
  {
   list.add(o);
   return o;
  }

 //搜尋
 public int search(Object o)
  {
   return list.lastIndexOf(o);
  }

 //顯示
 public String toString()
  {
   return "stack: "+ list.toString();
  }
}
   