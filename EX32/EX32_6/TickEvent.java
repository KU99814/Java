public class TickEvent extends java.util.EventObject
{
 private long tickCount;//���榸��
 private long tickInterval;//���涡�j

 public TickEvent(Object source)
  {
   super(source);
  }

 //�^�ǰ��榸��
 public long getTickCount()
  {
   return tickCount;
  }

 //�]�w���榸��
 public long getTickInterval()
  {
   return tickInterval;
  }

 //�^�ǰ��涡�j
 public void setTickCount(long tickCount)
  {
   this.tickCount = tickCount;
  }

 //�]�w���涡�j
 public void setTickInterval(long tickInterval)
  {
   this.tickInterval = tickInterval;
  }
}