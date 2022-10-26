import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Tick
{
 private int tickCount = 0;					//���榸��
 private int tickInterval = 100;				//���涡�j
 private int maxInterval = 5000;				//�̤j���涡�j
 private int minInterval = 1;					//�̤p���涡�j
 private long step = 0;						//�W��j
 private TickEvent event = new TickEvent(this);		//����ƥ�
 private ArrayList<TickListener> tickListenerList;
 private javax.swing.Timer timer;

 //constructor
 public Tick()
  {
   this(100,5000,1,0);
  }

 public Tick(int tickInterval,int maxInterval,int minInterval,long step)
  {
   this.tickInterval = tickInterval;
   this.maxInterval = maxInterval;
   this.minInterval = minInterval;
   this.step = step;
   timer = new javax.swing.Timer(tickInterval,new TimerListener());
  }

 public void resume()
  {
   timer.start();
  }
 
 public void suspend()
  {
   timer.stop();
  }

 private class TimerListener implements ActionListener
  {
   public void actionPerformed(ActionEvent e)
    {
     if(step!=0)
      {
       tickInterval += step;
       timer.setDelay(tickInterval);
      }

     if(tickInterval>maxInterval || tickInterval<minInterval)
      {
       return;
      }
     
     tickCount++;
     
     event.setTickCount(tickCount);
     event.setTickInterval(tickInterval);
     
     processEvent(event);
    }
  }

 //�^�ǰ��榸��
 public int getTickCount()
  {
   return tickCount;
  }

 //�]�w���榸��
 public void setTickCount(int tickCount)
  {
   this.tickCount = tickCount;
  }

 //�^�ǭȦ涡�j
 public int getTickInterval()
  {
   return tickInterval;
  }

 //�]�w���涡�j
 public void setTickInterval(int tickInterval)
  {
   this.tickInterval = tickInterval;
   timer.setDelay(tickInterval);
  }

 //�^�ǳ̤j�Ȧ涡�j
 public int getMaxInterval()
  {
   return maxInterval;
  }

 //�]�w�̤j���涡�j
 public void setMaxInterval(int maxInterval)
  {
   this.maxInterval = maxInterval;
  }

 //�^�ǳ̤p�Ȧ涡�j
 public int getMinInterval()
  {
   return minInterval;
  }

 //�]�w�̤p���涡�j
 public void setMinInterval(int minInterval)
  {
   this.minInterval = minInterval;
  }

 //�^�ǼW��j
 public long getStep()
  {
   return step;
  }

 //�]�w�W��j
 public void setStep(int step)
  {
   this.step = step;
  }

 public synchronized void addTickListener(TickListener l)
  {
   if(tickListenerList == null)
    {
     tickListenerList = new ArrayList<TickListener>(2);
    }

   if(!tickListenerList.contains(l))
    {
     tickListenerList.add(l);
    }
  }
 
 public synchronized void removeTickListener(TickListener l)
  {
   if(tickListenerList != null && !tickListenerList.contains(l))
    {
     tickListenerList.remove(l);
    }
  }

 private void processEvent(TickEvent e)
  {
   ArrayList list;

   synchronized(this){
    if(tickListenerList == null)
     {
      return;
     }
    list = (ArrayList)tickListenerList.clone();

    for(int i = 0;i<list.size();i++)
     {
      TickListener listener = (TickListener)list.get(i);
      
      listener.handleTick(e);
     }
   }
  }
}