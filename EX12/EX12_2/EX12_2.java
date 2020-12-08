//The Person and Student class

public class EX12_2
{
 public static void main(String args[])
  {
   Student[] student = new Student[5];//厩ネ皚
   
   student[0] = new Student(new Name("d",'f',"G"),"a");
   student[1] = new Student(new Name("d",'f',"D"),"a");
   student[2] = new Student(new Name("d",'f',"T"),"a");
   student[3] = new Student(new Name("d",'f',"A"),"a");
   student[4] = new Student(new Name("d",'f',"Z"),"a");

   sort(student); //逼
   printList(student);//陪ボ
   max(student); //т程
  }

 //逼-獁猨
 public static void sort(Comparable[] list)
  {
   while(true)
    {
     boolean t = true;

     for(int i=0;i<list.length-1;i++)//ぃ耞ㄢㄢユ传常玡
      {
       if(list[i].compareTo(list[i+1]) > 0)
        {
         Comparable temp = list[i];
         list[i] = list[i+1];
         list[i+1] = temp;
         t = false;
        }
      }
      
     if(t)
      break;
    }
  }
 
 //陪ボ皚
 public static void printList(Object[] object)
  {
   for(int i=0;i<object.length;i++)
    System.out.println(((Student)object[i]).toString());
  }

 //т程
 public static Comparable max(Comparable[] list)
  {
   Comparable max = list[0];

   for(int i=0;i<list.length;i++)//ぃ耞ㄢㄢユ传常玡
    {
     if(list[i].compareTo(max) > 0)
      {
       max = list[i];
      }
    }
   System.out.println(max.toString());
   return max;
  }
}