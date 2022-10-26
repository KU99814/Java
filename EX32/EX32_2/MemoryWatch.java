//�d�ݰO����class

import java.util.*;
import java.awt.event.*;

public class MemoryWatch
{
 private ArrayList<MemoryListener> listenerList; //��ť�ƥ�list

 //�j�p�W�U��
 private long highLimit = 15511000;
 private long lowLimit = 15510600;

 public MemoryWatch(){}

 //�ˬd�O����
 public void checkMemory()
  {
   processEvent(new MemoryEvent(this));
  }

 //�[�J��ť
 public synchronized void addMemoryListener(MemoryListener listener)
  {
   if(listenerList==null)
    {
     listenerList = new ArrayList<MemoryListener>();
    }

   if(!listenerList.contains(listener))
    {
     listenerList.add(listener);
    }
  }

 //������ť
 public synchronized void removeMemoryListener(MemoryListener listener)
  {
    if(listenerList!=null && listenerList.contains(listener))
    {
     listenerList.remove(listener);
    }
  }

 //�����ť�ƥ�
 private void processEvent(MemoryEvent event)
  {
   ArrayList list;
   
   synchronized(this)
    {
     if(listenerList==null) return;
     list = (ArrayList)listenerList.clone();
    }

   for(int i=0;i<list.size();i++)
    {
     MemoryListener listener = (MemoryListener)list.get(i);

     //�P�_�O�_�W�L�W���Τ����U��
     if(event.freeMemory()>highLimit)
      {
       listener.sufficientMemory(event);
      }
     if(event.freeMemory()<lowLimit)
      {
       listener.insufficientMemory(event);
      }
    }
  }
}
