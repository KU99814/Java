//�O����ƥ�

public class MemoryEvent extends java.util.EventObject
{
 public MemoryEvent(Object object)
  {
   super(object);
  }

 //�žl�O����j�p
 public long freeMemory()
  {
   Runtime runtime = Runtime.getRuntime();
   
   return runtime.freeMemory();
  }

 //�����O����j�p
 public long totalMemory()
  {
   Runtime runtime = Runtime.getRuntime();
   
   return runtime.totalMemory();
  }
}