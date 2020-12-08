//�p��Linear search�Mbinary search�Ҫ�ɶ�

public class EX6_16
{
 public static void main(String args[])
  {
   int[] num = new int[100000]; //�гy�}�C
   for(int i=0;i<num.length;i++)
    num[i] = (int)(Math.random()*10000);

   int key = (int)(Math.random()*10000); //�n�䪺�ؼ�

   long startTime = System.currentTimeMillis(); //Linear search�}�l�ɶ�

   if(linearSearch(num,key)!=-1)
    System.out.println("The index of key number is "+linearSearch(num,key)); //Linear search�j�M
   else
    System.out.println("No conform number");

   long endTime = System.currentTimeMillis(); //Linear search�����ɶ�
   System.out.println("This speed of liner search "+
                      (endTime - startTime)+" millisecond"); //Linear search�Ҫ�ɶ�

   startTime = System.currentTimeMillis(); //insection sort�}�l�ɶ�
   
   insertionSort(num); //�Ѥp��j�ƦC

   endTime = System.currentTimeMillis(); //insertion sort�����ɶ�

   System.out.println("The speed of insertion sort is "+(endTime - startTime)+" millisecond");

   startTime = System.currentTimeMillis(); //binary search�}�l�ɶ�

   System.out.println("The index use binary search is "+binarySearch(num,key)); //binary search�j�M

   endTime = System.currentTimeMillis(); //binary search�����ɶ�
   System.out.println("This speed "+(endTime - startTime)+" millisecond"); //binary search�Ҫ�ɶ�
  }

 public static int linearSearch(int[] list,int key) //linear search
  {
   for(int i=0;i<list.length;i++)
    {
     if(key == list[i])
      return i;
    }

   return -1;
  }

 public static int binarySearch(int[] list,int key) //binary search
  {
   int low =0; //�U��
   int high = list.length-1; //�W��
   
   while(high>=low) 
    {
     int mid =(low+high)/2; //���� ��key���
     //�ھڤj�p�M�w���N�W��ΤU��
     if(key<list[mid])
      high = mid - 1;
     else if(key==list[mid])
      return mid;
     else
      low = mid +1;
    }

   return -low - 1;
  }

 public static void insertionSort(int[] list) //insertion sort
  {
   for(int i=1;i<list.length;i++)
    {
     int currentElement = list[i];
     int k;
     //�N�{�b���Ƹ�e�����Ƥ�� �p�G�e�����Ƹ��j �N���e���N����e�����ƬO���p��
     for(k=i-1;k>=0&&list[k]>currentElement;k--)
      list[k+1]=list[k];

     list[k+1]= currentElement;
    }
  }
}