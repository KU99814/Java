//The Person and Student class

public class EX12_2
{
 public static void main(String args[])
  {
   Student[] student = new Student[5];//�ǥͰ}�C
   
   student[0] = new Student(new Name("d",'f',"G"),"a");
   student[1] = new Student(new Name("d",'f',"D"),"a");
   student[2] = new Student(new Name("d",'f',"T"),"a");
   student[3] = new Student(new Name("d",'f',"A"),"a");
   student[4] = new Student(new Name("d",'f',"Z"),"a");

   sort(student); //�Ƨ�
   printList(student);//���
   max(student); //��̤j
  }

 //�Ƨ�-�w�j
 public static void sort(Comparable[] list)
  {
   while(true)
    {
     boolean t = true;

     for(int i=0;i<list.length-1;i++)//���_���洫����j�����b�e��
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
 
 //��ܰ}�C
 public static void printList(Object[] object)
  {
   for(int i=0;i<object.length;i++)
    System.out.println(((Student)object[i]).toString());
  }

 //��̤j
 public static Comparable max(Comparable[] list)
  {
   Comparable max = list[0];

   for(int i=0;i<list.length;i++)//���_���洫����j�����b�e��
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