//Generic PriorityQueue using Comparator

import java.util.Comparator;

public class EX25_18 {
  public static void main(String[] args) {
    MyPriorityQueue<Patient> queue =
      new MyPriorityQueue<Patient>(new PatientComparator());//PriorityQueue

    //��Jelement
    queue.enqueue(new Patient("John",2));
    queue.enqueue(new Patient("Jim",1));
    queue.enqueue(new Patient("Tim",5));
    queue.enqueue(new Patient("Cingy",7));

    //���
    while(queue.getSize()>0)
     System.out.println(queue.dequeue());
  }

 //patient �����object
 static class Patient implements Comparable
  {
   private String name;//�m�W
   private int priority;//�u����

   //default
   public Patient(String name,int priority)
    {
     this.name = name;
     this.priority = priority;
    }
   
   //��ܸ�T
   public String toString()
    {
     return name + "(priority:"+priority+")";
    }

   //���
   public int compareTo(Object o)
    {
     return priority - ((Patient)o).priority;//�u���׬۴�
    }

  }

 //patient�����
 static class PatientComparator implements Comparator<Patient>
  {
   //default
   public PatientComparator()
    {}

   //���
   public int compare(Patient o1, Patient o2)
    {
     return o1.compareTo(o2);
    }
  }
}