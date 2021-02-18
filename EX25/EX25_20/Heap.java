//Heap implement

public class Heap<E extends Comparable>
{
 private java.util.ArrayList<E> list = new java.util.ArrayList<E>();//�x�s�}�C

 //default
 public Heap()
  {}
 
 public Heap(E[] objects)
  {
   for(int i=0;i<objects.length;i++)
    add(objects[i]);
  }

 //�[�Jelement
 public void add(E newObject)
  {
   list.add(newObject);//���Nelement�[�Jlist
   
   int currentIndex = list.size()-1;//�ثe��index
   
   //��parent node����j�p ����Ҧ�parent node�����p
   while(currentIndex > 0)
    {
     int parentIndex = (currentIndex-1)/2;//parent node��index

     //����j�p �Y���p�Y�洫     
     if(list.get(currentIndex).compareTo(list.get(parentIndex)) > 0)
      {
       E temp = list.get(currentIndex);
       list.set(currentIndex,list.get(parentIndex));
       list.set(parentIndex,temp);
      }
     else//�Y���j�Y���X�j��
      break;
     
     currentIndex = parentIndex;//parent index�ܬ��ثeindex
    }
  }

 //���o���welement
 public E get(int index)
  {
   return list.get(index);
  }
 
 //����element
 public E remove()
  {
   if(list.size()==0)//�Y�𬰪� �^��null
    return null;
   //�����ɱqroot�}�l
   E removedObject = list.get(0);//�^��element
   list.set(0,list.get(list.size() - 1));//�N�̫᪺node�Proot�洫
   list.remove(list.size()-1);//����root

   int currentIndex = 0;//�ثeindex

   //���s����j�p �Ƨ�heap
   while(currentIndex < list.size())
    {
     //���k�l��index
     int leftChildIndex = 2*currentIndex + 1;
     int rightChildIndex = 2*currentIndex + 2;

     //�Y�S���l�� ���X
     if(leftChildIndex >= list.size())
      break;

     int minIndex = leftChildIndex;//�̤p��index

     //��������knode�ֳ̤p
     if(rightChildIndex < list.size())
      {
       if(list.get(minIndex).compareTo(list.get(rightChildIndex)) < 0)
        minIndex = rightChildIndex;
      }
     
     //�Y�O��̤p�����٤j �洫
     if(list.get(currentIndex).compareTo(list.get(minIndex)) < 0)
      {
       E temp = list.get(minIndex);
       list.set(minIndex,list.get(currentIndex));
       list.set(currentIndex,temp);
       currentIndex = minIndex; 
      }
     else//�Y�w�g�O�̤p ���X
      break;
    }
   
   return removedObject;//�^��
  }

 //�^�Ǥj�p
 public int getSize()
  {
   return list.size();
  }
}