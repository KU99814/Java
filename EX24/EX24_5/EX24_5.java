//Implementing MyQueue using inheritance

public class EX24_5
{
 public static void main(String args[])
  {
   MyQueue<String> queue = new MyQueue<String>();//MyQueue測試

   //enqueue測試 放入element
   queue.enqueue("Tom");
   System.out.println("(1) "+ queue);

   queue.enqueue("John");
   System.out.println("(2) "+ queue);

   queue.enqueue("George");
   queue.enqueue("Michael");
   System.out.println("(3) "+ queue);

   //dequeue測試 顯示內容
   System.out.println("(4) "+ queue.dequeue());
   System.out.println("(5) "+ queue.dequeue());
   System.out.println("(6) "+ queue);
  }
}