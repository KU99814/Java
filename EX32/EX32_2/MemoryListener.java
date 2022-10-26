//記憶體監聽

public interface MemoryListener extends java.util.EventListener
{
 //大小足夠時事件
 public void sufficientMemory(MemoryEvent e);

 //大小不足時事件
 public void insufficientMemory(MemoryEvent e);
}