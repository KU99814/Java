//查看記憶體class

import java.util.*;
import java.awt.event.*;

public class MemoryWatch
{
 private ArrayList<MemoryListener> listenerList; //監聽事件list

 //大小上下限
 private long highLimit = 15511000;
 private long lowLimit = 15510600;

 public MemoryWatch(){}

 //檢查記憶體
 public void checkMemory()
  {
   processEvent(new MemoryEvent(this));
  }

 //加入監聽
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

 //移除監聽
 public synchronized void removeMemoryListener(MemoryListener listener)
  {
    if(listenerList!=null && listenerList.contains(listener))
    {
     listenerList.remove(listener);
    }
  }

 //執行監聽事件
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

     //判斷是否超過上限或不足下限
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
