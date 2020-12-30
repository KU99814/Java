//abstract class list

public abstract class MyAbstractList<E> implements MyList<E>
{
 protected int size = 0;//�j�p

 //�غc�l
 protected MyAbstractList()
  {}

 protected MyAbstractList(E[] objects)
  {
   for(int i=0;i<objects.length;i++)
    add(objects[i]);
  }

 //�W�[element
 public void add(E e)
  {
   add(size,e);
  }

 //�P�_�O�_��
 public boolean isEmpty()
  {
   return size==0;
  }

 //�^�Ǥj�p
 public int size()
  {
   return size;
  }

 //����element
 public boolean remove(E e)
  {
   if(indexOf(e) >= 0)//�P�_�O�_�s�belement �Y�O indexOf�j�󵥩�0 
    {
     //�����æ^��true
     remove(indexOf(e));
     return true;
    }

   else//�Y�L�R�� �^��false
    return false;
  }

 //�NMyList���e�����[�J 
 public boolean addAll(MyList otherList)
  {
   if(!otherList.isEmpty())//�P�_�O�_����
    {
     //�Y�D�� �j������[�J
     for(int i=0;i<otherList.size();i++)
      add((E)otherList.get(i));

     return true;//�^��true
    }
   else//�Y�� �^��false
    return false;
  }

 //���������PotherList�ۦP��element
 public boolean removeAll(MyList otherList)
  {
   boolean change = false;//�P�_�O�_�ܧ�

   if(!otherList.isEmpty())//�M�X�Ҧ�element
    {
     for(int i=0;i<otherList.size();i++)
      {
       while(remove((E)otherList.get(i)))//�Y���ۦP��element ����
        {
         change = true;//������ �אּtrue
        }
      }
    }

   return change;//�^�ǬO�_�ܧ�
  }

 //�O�d�ۦP��element �R�h���P��element
 public boolean retainAll(MyList otherList)
  {
   boolean change = false;//�P�_�O�_�ܧ�

   //�YotherList������ �M�X
   if(!otherList.isEmpty())
    {
     for(int i=0;i<size;i++)
      {
       if(otherList.indexOf((E)get(i))<0)//�Y�botherList���䤣�� ����
        {
         remove(get(i));
         change = true;//�w�ܧ� �]true
        }
      }
    }   
   
   return change;//�^�ǬO�_�ܧ�
  }
}  