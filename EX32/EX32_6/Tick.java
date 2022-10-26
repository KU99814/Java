import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Tick
{
 private int tickCount = 0;					//執行次數
 private int tickInterval = 100;				//執行間隔
 private int maxInterval = 5000;				//最大執行間隔
 private int minInterval = 1;					//最小執行間隔
 private long step = 0;						//增減間隔
 private TickEvent event = new TickEvent(this);		//執行事件
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

 //回傳執行次數
 public int getTickCount()
  {
   return tickCount;
  }

 //設定執行次數
 public void setTickCount(int tickCount)
  {
   this.tickCount = tickCount;
  }

 //回傳值行間隔
 public int getTickInterval()
  {
   return tickInterval;
  }

 //設定執行間隔
 public void setTickInterval(int tickInterval)
  {
   this.tickInterval = tickInterval;
   timer.setDelay(tickInterval);
  }

 //回傳最大值行間隔
 public int getMaxInterval()
  {
   return maxInterval;
  }

 //設定最大執行間隔
 public void setMaxInterval(int maxInterval)
  {
   this.maxInterval = maxInterval;
  }

 //回傳最小值行間隔
 public int getMinInterval()
  {
   return minInterval;
  }

 //設定最小執行間隔
 public void setMinInterval(int minInterval)
  {
   this.minInterval = minInterval;
  }

 //回傳增減間隔
 public long getStep()
  {
   return step;
  }

 //設定增減間隔
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