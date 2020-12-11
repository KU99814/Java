//Compare sorting performance

import java.util.*;

public class EX22_5
{
 public static void main(String args[])
  {
   ArrayList<Integer> list1 = new ArrayList<Integer>();//�ŧilist

   //�[�Jelement
   for(int i = 0;i<100000;i++)
    list1.add(i);

   Collections.shuffle(list1,new Random(10000));//����

   //��ܦU�ӭp��ɶ�   
   System.out.println("Time for Collection.Sort is "+getCollectionTime(list1));//Arraylist

   System.out.println("Time for Tree set is "+getTreeSetTime());//TreeSet

   System.out.println("Time for Priority Queue is "+getPriorityQueueTime());//Priority Queue
  }

 //arrayList�Ƨǵo���ɶ�
 public static long getCollectionTime(ArrayList<Integer> l)
  {
   long starttime = System.currentTimeMillis();//�}�l�ɶ�
   
   Collections.sort(l);//�Ƨ�
   
   long endtime = System.currentTimeMillis();//�����ɶ�
   
   return endtime - starttime;//�^�Ǫ�O�ɶ�
  }

 //Treeset��O�ɶ�
 public static long getTreeSetTime()
  {
   ArrayList<Integer> list = new ArrayList<Integer>();//�ŧi�}�C

   for(int i = 0;i<100000;i++)//��Jelement
    list.add(i);

   Collections.shuffle(list,new Random(10000));//����

   Collection<Integer> set = new TreeSet<Integer>();//�ŧitreeset

   long starttime = System.currentTimeMillis();//�}�l�ɶ�
   
   for(int element: list)//�[�Jelement
    set.add(element);

   for(int element: list)//����element
    set.remove(element);
   
   long endtime = System.currentTimeMillis();//�����ɶ�
   
   return endtime - starttime;//�^�Ǫ�O�ɶ�
  }

 //PriorityQueue�ɶ�
 public static long getPriorityQueueTime()
  {
   ArrayList<Integer> list = new ArrayList<Integer>();//�ŧi�}�C

   //�[�Jelement
   for(int i = 0;i<100000;i++)
    list.add(i);

   Collections.shuffle(list,new Random(10000));//����

   PriorityQueue<Integer> pq = new PriorityQueue<Integer>();//�ŧiPriorityQueue

   long starttime = System.currentTimeMillis();//�}�l�ɶ�
   
   for(int element: list)//��J
    pq.offer(element);

   for(int element: list)//����
    pq.remove();
   
   long endtime = System.currentTimeMillis();//�����ɶ�
   
   return endtime - starttime;//�^�Ǫ�O�ɶ�
  }
}