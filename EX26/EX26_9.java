//radix sort

import java.util.*;

public class EX26_9
{
 public static void main(String args[])
  {
   int[] list = new int[1000000];//�Ƨǥ�sort

   //�H���ܼ�
   for(int i=0;i<list.length;i++)
    list[i] = (int)(Math.random()*10000000);
   
   long startTime = System.currentTimeMillis();//�}�l�ɶ�
   
   radixSort(list);//�Ƨ�

   long endTime = System.currentTimeMillis();//�����ɶ�
   long exTime = endTime - startTime;//����ɶ�

   System.out.print("exe time: "+exTime);//���
  }

 //radix sort
 public static void radixSort(int[] list)
  {
   ArrayList[] bucket = new ArrayList[10];//��mint��bulk

   //�Ы�arraylist object
   for(int i=0;i<bucket.length;i++)
    bucket[i] = new ArrayList();
   
   int blukCount = 0;//��m�Ʀr��bulk��
  
   int count = 0;//���

   //�Ƨǰj��
   while(true)
    {
     blukCount = 0;//�k�s
     int divide = (int)(Math.pow(10,count));//����

     for(int i=0;i<list.length;i++)
      {
       int num = list[i]/divide%10;//���o���
       bucket[num].add(list[i]);//�[�����bulk
      }
    
     int k=0;//list index
     for(int i=0;i<bucket.length;i++)
      {
       //�Y��bulk����element blukCount+1
       if(bucket[i].size()>0)
        blukCount++;

       //�Nelement���Ӧ��0~9�Marraylist�����ǩ�Jlist
       for(int j=0;j<bucket[i].size();j++)
        {
         list[k] = (Integer)(bucket[i].get(j));
         k++;
        }
       bucket[i].clear();//�M��
      }

     count++;//���+1
     //�Y�u���@��bulk��element �Ƨǧ���
     if(blukCount==1)
      break;
    }
  }
}     
           