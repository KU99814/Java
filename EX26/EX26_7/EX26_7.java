//Execution time for sorting

public class EX26_7
{
 public static void main(String args[])
  {
   //����method
   testSort(50000);
   testSort(100000);
   testSort(150000);
   testSort(200000);
   testSort(250000);   
   testSort(300000);
  }

 //���olist���Ʀr
 public static void number(int[] list)
  {
   for(int i=0;i<list.length;i++)
    list[i] = (int)(Math.random()*list.length);//�H�����o�Ʀr �d��P���׳��q�קK����
  }

 //�������
 public static void testSort(int number)
  {
   int[] list = new int[number];//���Ƨ�list ��m���ռƦr
   int[] listCopy = new int[number];//���ե�list ��ڴ���

   number(list);//list���oint
   System.arraycopy(list,0,listCopy,0,list.length);//�ƻs����ե�list

   System.out.println("Array Size:"+number);//���ժ�list����
 
   //selection sort time
   System.out.println("Selection sort: "+selectionSort(listCopy));

   //�ƻs���Ƨ�list���s����
   System.arraycopy(list,0,listCopy,0,list.length);

   //insertion sort time
   System.out.println("Insertion sort: "+insertionSort(listCopy));
   
   System.arraycopy(list,0,listCopy,0,list.length);
   
   //bubble sort time
   System.out.println("Bubble sort: "+bubbleSort(listCopy));

   System.arraycopy(list,0,listCopy,0,list.length);
 
   //merge sort time
   System.out.println("Merge sort: "+mergeSort(listCopy));
   
   System.arraycopy(list,0,listCopy,0,list.length);

   //quick sort time
   System.out.println("Quick sort: "+quickSort(listCopy));

   System.arraycopy(list,0,listCopy,0,list.length);

   //heap sort time
   System.out.println("Heap sort: "+heapSort(listCopy));
  }

 //selection sort
 public static long selectionSort(int[] list)
  {
   long startTime = System.currentTimeMillis();//�}�l�ɶ�

   //�j��qn�}�l
   for(int i=list.length - 1;i>=1;i--)
    {
     int currentMax = list[0];//�H�Ĥ@�ӼƬ���l�̤j
     int currentMaxIndex = 0;//��l�̤j��index
     
     //��X�̤j����
     for(int j=1;j<=i;j++)
      {
       if(currentMax<list[j])
        {
         currentMax = list[j];
         currentMaxIndex = j;
        }
      }
     
     //�N�̤j���Ʃ��ثe��index
     if(currentMaxIndex != i)
      {
       list[currentMaxIndex] = list[i];
       list[i] = currentMax;
      }
    }

   long endTime = System.currentTimeMillis();//�����ɶ�
   return endTime - startTime;//��Ƭ۴��ڰ���ɶ�
  }

 //insertion sort
 public static long insertionSort(int[] list)
  {
   long startTime = System.currentTimeMillis();//�}�l�ɶ�

   for(int i=1;i<list.length;i++)
    {
     int currentElement = list[i];//�ثeindex��element
     int k;
     //���e�j�� �Y��n-1��element���j ���N��n��
     //����n<0��n-1���p
     for(k = i-1;k>=0&&list[k]>currentElement;k--)
      list[k+1] = list[k];
     
     list[k+1] = currentElement;//���Jelement
    }

   long endTime = System.currentTimeMillis();//�����ɶ�
   return endTime - startTime;//��Ƭ۴��ڰ���ɶ�
  }

 //bubble sort
 public static long bubbleSort(int[] list)
  {
   long startTime = System.currentTimeMillis();//�}�l�ɶ�

   boolean needNextPass = true;//�P�_�O�_�~��Ƨ�
   
   for(int k = 1;k<list.length && needNextPass;k++)
    {
     needNextPass = false;
     
     for(int i=0;i<list.length-k;i++)
      {
       //�Y���ݭn�洫��element �洫���~��i��U�@���Ƨ�
       if(list[i] > list[i+1])
        {
         int temp = list[i];
         list[i] = list[i+1];
         list[i+1] = temp;
         needNextPass = true;
        }
      }
    }

   long endTime = System.currentTimeMillis();//�����ɶ�
   return endTime - startTime;//��Ƭ۴��ڰ���ɶ�
  }

 //merge sort
 public static long mergeSort(int[] list)
  {
   long startTime = System.currentTimeMillis();//�}�l�ɶ�

   //������׬�1���� ���ίx�}
   if(list.length>1)
    {
     //�W�b����
     int[] firstHalf = new int[list.length/2];
     System.arraycopy(list,0,firstHalf,0,list.length/2);
     mergeSort(firstHalf);//���j

     //�U�b����
     int secondHalfLength = list.length - list.length/2;//�U�b�}�lindex
     int[] secondHalf = new int[secondHalfLength];
     System.arraycopy(list,list.length/2,secondHalf,0,secondHalfLength);
     mergeSort(secondHalf);//���j


     int[] temp = merge(firstHalf,secondHalf);//�N��ӯx�}�Ƨǵ��X
     System.arraycopy(temp,0,list,0,temp.length);//���N��x�}
    }

   long endTime = System.currentTimeMillis();//�����ɶ�
   return endTime - startTime;//��Ƭ۴��ڰ���ɶ�
  }

 //���X�x�}method
 private static int[] merge(int[] list1,int[] list2)
  {
   int[] temp = new int[list1.length+list2.length];

   int current1 = 0;//�W�bindex
   int current2 = 0;//�U�bindex
   int current3 = 0;//���X�x�}index

   //����䤤�@��index�W�L����
   while(current1 < list1.length && current2 < list2.length)
    {
     //�����ӯx�}�ثeindex��element �N���p����J���X�x�}
     if(list1[current1] < list2[current2])
      temp[current3++] = list1[current1++];
     else
      temp[current3++] = list2[current2++];
    }

   //�N�ѤU�S��element������J
   while(current1 < list1.length)
    temp[current3++] = list1[current1++];
   
   while(current2 < list2.length)
    temp[current3++] = list2[current2++];
   
   return temp;//�^��
  }

 //quick sort
 public static long quickSort(int[] list)
  {
   long startTime = System.currentTimeMillis();//�}�l�ɶ�

   quickSort(list,0,list.length-1);//call method

   long endTime = System.currentTimeMillis();//�����ɶ�
   return endTime - startTime;//��Ƭ۴��ڰ���ɶ�
  }

 //helper method
 public static void quickSort(int[] list,int first,int last)
  {
   if(last > first)
    {
     int pivotIndex = partition(list,first,last);//��Ǫ�index
     //�H��Ǭ��ɤ��ⳡ���~��Ƨ�
     quickSort(list,first,pivotIndex-1);
     quickSort(list,pivotIndex+1,last);
    }
  }

 //���ΨñƧ�
 private static int partition(int[] list,int first,int last)
  {
   int pivot = list[first];//���
   int low = first + 1;//�e�b�_�lindex
   int high = last;//��b����index

   //�N�e�b�j���Ǫ�element�M��b�p���Ǫ�element����
   while(high > low)
    {
     while(low <= high && list[low] <= pivot)
      low++;

     while(low <= high && list[high] > pivot)
      high--;
     
     if(high > low)
      {
       int temp = list[high];
       list[high] = list[low];
       list[low] = temp;
      }
    }

   while(high >first && list[high] >= pivot)
    high--;
   
   //�N��ǲ��ʨ�e�b�P��b���
   if(pivot > list[high])
    {
     list[first] = list[high];
     list[high] = pivot;
     return high;
    }
   else
    return first;
  }

 //heap sort
 public static long heapSort(int[] list)
  {
   long startTime = System.currentTimeMillis();//�}�l�ɶ�

   Heap heap = new Heap();//heap tree

   //��Jheap�� �|����heap�W�h�Ƨ�
   for(int i=0;i<list.length;i++)
    heap.add(list[i]);

   //�����Ǩ��N��list
   for(int i=list.length-1;i>=0;i--)
    list[i] = (Integer)(heap.remove());

   long endTime = System.currentTimeMillis();//�����ɶ�
   return endTime - startTime;//��Ƭ۴��ڰ���ɶ�
  }
}