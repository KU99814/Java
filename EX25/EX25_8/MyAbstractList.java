//abstract list class

public abstract class MyAbstractList<E> implements MyList<E>
{
 protected int size = 0;//���e�j�p

 //default
 protected MyAbstractList()
  {}

 protected MyAbstractList(E[] objects)
  {
   for(int i=0;i<objects.length;i++)
    add(objects[i]);
  }

 //�[�Jelement
 public void add(E e)
  {
   add(size,e);
  }

 //�P�_�O�_����
 public boolean isEmpty()
  {
   return size==0;
  }

 //�^��list�j�p
 public int size()
  {
   return size;
  }

 //����element
 public boolean remove(E e)
  {
   //�Y�������ۦPelement ����
   if(indexOf(e) >= 0)
    {
     remove(indexOf(e));
     return true;//�^��true
    }

   //�Y�L �^��false
   else
    return false;
  }

 //�Notherlist���e�����[�J
 public boolean addAll(MyList otherList)
  {
   //�Yotherlist������
   if(!otherList.isEmpty())
    {
     //�j��N���e�����[�J
     for(int i=0;i<otherList.size();i++)
      add((E)otherList.get(i));

     return true;//�^��true
    }
   
   //�Y���� �^��false
   else
    return false;
  }


 //�N�Potherlist���e�ۦPelement��������
 public boolean removeAll(MyList otherList)
  {
   //�Yotherlist������
   if(!otherList.isEmpty())
    {
     //�j����X����element 
     for(int i=0;i<otherList.size();i++)
      {
       //�����s�b��list����element
       while(remove((E)otherList.get(i)))
        {}
      }
     return true;//�^�� true
    }

   //�Y���� �^��false
   else
    return false;
  }

 //�N���botherlist����element����
 public boolean retainAll(MyList otherList)
  {
   //�Yother1ist������
   if(!otherList.isEmpty())
    {
     //�j��M�X �N���list��element�@�@���
     for(int i=0;i<size;i++)
      {
       boolean retain = false;//�P�_�O�_�]�t
       for(int j=0;j<otherList.size();j++)
        {
         if(contains((E)otherList.get(i)))
          retain = true;
        }

       //�Y���]�t ����element       
       if(!retain)
        {
         remove(i);
         i--;
        }
      }   
     return true;//�^��true
    }
 
   //�Y���� �^��false
   else
    return false;
  }
}  