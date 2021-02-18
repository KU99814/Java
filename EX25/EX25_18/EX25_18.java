//Generic PriorityQueue using Comparator

import java.util.Comparator;

public class EX25_18 {
  public static void main(String[] args) {
    MyPriorityQueue<Patient> queue =
      new MyPriorityQueue<Patient>(new PatientComparator());//PriorityQueue

    //放入element
    queue.enqueue(new Patient("John",2));
    queue.enqueue(new Patient("Jim",1));
    queue.enqueue(new Patient("Tim",5));
    queue.enqueue(new Patient("Cingy",7));

    //顯示
    while(queue.getSize()>0)
     System.out.println(queue.dequeue());
  }

 //patient 比較用object
 static class Patient implements Comparable
  {
   private String name;//姓名
   private int priority;//優先度

   //default
   public Patient(String name,int priority)
    {
     this.name = name;
     this.priority = priority;
    }
   
   //顯示資訊
   public String toString()
    {
     return name + "(priority:"+priority+")";
    }

   //比較
   public int compareTo(Object o)
    {
     return priority - ((Patient)o).priority;//優先度相減
    }

  }

 //patient比較器
 static class PatientComparator implements Comparator<Patient>
  {
   //default
   public PatientComparator()
    {}

   //比較
   public int compare(Patient o1, Patient o2)
    {
     return o1.compareTo(o2);
    }
  }
}