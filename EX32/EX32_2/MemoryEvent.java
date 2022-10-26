//記憶體事件

public class MemoryEvent extends java.util.EventObject
{
 public MemoryEvent(Object object)
  {
   super(object);
  }

 //空餘記憶體大小
 public long freeMemory()
  {
   Runtime runtime = Runtime.getRuntime();
   
   return runtime.freeMemory();
  }

 //全部記憶體大小
 public long totalMemory()
  {
   Runtime runtime = Runtime.getRuntime();
   
   return runtime.totalMemory();
  }
}