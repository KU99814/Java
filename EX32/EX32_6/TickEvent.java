public class TickEvent extends java.util.EventObject
{
 private long tickCount;//執行次數
 private long tickInterval;//執行間隔

 public TickEvent(Object source)
  {
   super(source);
  }

 //回傳執行次數
 public long getTickCount()
  {
   return tickCount;
  }

 //設定執行次數
 public long getTickInterval()
  {
   return tickInterval;
  }

 //回傳執行間隔
 public void setTickCount(long tickCount)
  {
   this.tickCount = tickCount;
  }

 //設定執行間隔
 public void setTickInterval(long tickInterval)
  {
   this.tickInterval = tickInterval;
  }
}