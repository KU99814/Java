//Completing the implementation of MyLinkedList

public class EX24_12
{
 public static void main(String args[])
  {
   MyLinkedList<String> list = new MyLinkedList<String>();//linked list

   //add代刚
   list.add("America");
   System.out.println("(1) "+list);

   list.add(0,"Canada");
   System.out.println("(2) "+list);

   list.add("Russia");
   System.out.println("(3) "+list);

   //addFirst代刚
   list.addLast("France");
   System.out.println("(4) "+list);

   list.add(2,"Germany");
   System.out.println("(5) "+list);

   list.add(5,"Norway");
   System.out.println("(6) "+list);

   list.add(0,"Poland");
   System.out.println("(7) "+list);

   //remove代刚
   list.remove(0);
   System.out.println("(8) "+list);

   list.remove(2);
   System.out.println("(9) "+list);

   list.remove(list.size() - 1);
   System.out.println("(10) "+list);

   //琌
   System.out.println("contains America "+list.contains("America"));

   System.out.println("contains ROC "+list.contains("ROC"));

   //get代刚
   System.out.println("get 0 "+list.get(0));

   System.out.println("get 3 "+list.get(3));

   System.out.println("get 5 "+list.get(5));

   //indexOf代刚
   System.out.println("index of America "+list.indexOf("America"));

   System.out.println("index of ROC "+list.indexOf("ROC"));

   list.add("America");
   System.out.println("(11) "+list);

   //lastIndexOf代刚
   System.out.println("last index of America "+list.lastIndexOf("America"));

   System.out.println("last index of ROC "+list.lastIndexOf("ROC"));

   //set代刚
   list.set(4,"ROC");
   System.out.println("(12) "+list);

   //clear代刚
   list.clear();
   System.out.println("clear "+list);
  }
}