public class MyStack
{
 private java.util.ArrayList list = new java.util.ArrayList();// �s��}�C

 //�غc�l
 public MyStack()
  {}
 
 //�P�_�O�_��
 public boolean isEmpty()   
  {
   return list.isEmpty();
  }
  
 //���o�j�p
 public int getSize()
  {
   return list.size();
  }

 //�^�ǳ���
 public Object peek()
  {
   return list.get(getSize()-1);
  }

 //���X
 public Object pop()
  {
   Object o = list.get(getSize()-1);
   list.remove(getSize() - 1);
   return o;
  }
 
 //��J
 public Object push(Object o)
  {
   list.add(o);
   return o;
  }

 //�j�M
 public int search(Object o)
  {
   return list.lastIndexOf(o);
  }

 //���
 public String toString()
  {
   return "stack: "+ list.toString();
  }
}
   