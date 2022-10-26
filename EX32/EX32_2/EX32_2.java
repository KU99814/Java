//Creating custom event sets and source components

public class EX32_2
{
 public static void main(String[] args)
  {
   MemoryWatch watch = new MemoryWatch();//記憶體檢視
   
   MemoryListener listener = new NewListener();//監聽

   watch.addMemoryListener(listener);//加入監聽
   watch.checkMemory();//檢查記憶體
  }

 //自定義監聽 
 static class NewListener implements MemoryListener
  {
   public void sufficientMemory(MemoryEvent e)
    {
     System.out.println("Memroy  sufficient");
    }

   public void insufficientMemory(MemoryEvent e)
    {
     System.out.println("Memroy  insufficient");
    }
  }
}