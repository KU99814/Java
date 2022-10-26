//Creating custom event sets and source components

public class EX32_2
{
 public static void main(String[] args)
  {
   MemoryWatch watch = new MemoryWatch();//�O�����˵�
   
   MemoryListener listener = new NewListener();//��ť

   watch.addMemoryListener(listener);//�[�J��ť
   watch.checkMemory();//�ˬd�O����
  }

 //�۩w�q��ť 
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