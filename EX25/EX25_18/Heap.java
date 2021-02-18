//heap

import java.util.Comparator;

public class Heap<E>
{
 private java.util.ArrayList<E> list = new java.util.ArrayList<E>();//�x�s�}�C

 //default
 public Heap()
  {}

 private Comparator<? super E> comparator;//�����

 //default with comparator
 public Heap(Comparator<? super E> comparator) 
 {
  this.comparator = comparator;
 }
 
 public Heap(E[] objects)
  {
   for(int i=0;i<objects.length;i++)
    add(objects[i]);
  }

 
 public void add(E newObject)
  {
   list.add(newObject);//���Nelement�[�Jlist
   
   int currentIndex = list.size()-1;//�ثe��index
   
   //��parent node����j�p ����Ҧ�parent node�����j
   while(currentIndex > 0)
    {
     int parentIndex = (currentIndex-1)/2;//parent node��index
     
     //����j�p �Y���j�Y�洫 
     if(comparator.compare(list.get(currentIndex),list.get(parentIndex)) > 0)
      {
       E temp = list.get(currentIndex);
       list.set(currentIndex,list.get(parentIndex));
       list.set(parentIndex,temp);
      }
     else//�Y���p�Y���X�j��
      break;
     
     currentIndex = parentIndex;//parent index�ܬ��ثeindex
    }
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

     int maxIndex = leftChildIndex;//�̤p��index

     //��������knode�ֳ̤p
     if(rightChildIndex < list.size())
      {
       if(comparator.compare(list.get(maxIndex),list.get(rightChildIndex)) < 0)
        maxIndex = rightChildIndex;
      }
     
     //�Y�O��̤j�����٤p �洫
     if(comparator.compare(list.get(currentIndex),list.get(maxIndex)) < 0)
      {
       E temp = list.get(maxIndex);
       list.set(maxIndex,list.get(currentIndex));
       list.set(currentIndex,temp);
       currentIndex = maxIndex; 
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