//Execution time for sorting

public class EX26_7
{
 public static void main(String args[])
  {
   //測試method
   testSort(50000);
   testSort(100000);
   testSort(150000);
   testSort(200000);
   testSort(250000);   
   testSort(300000);
  }

 //取得list內數字
 public static void number(int[] list)
  {
   for(int i=0;i<list.length;i++)
    list[i] = (int)(Math.random()*list.length);//隨機取得數字 範圍同長度竟量避免重複
  }

 //執行測試
 public static void testSort(int number)
  {
   int[] list = new int[number];//未排序list 放置測試數字
   int[] listCopy = new int[number];//測試用list 實際測試

   number(list);//list取得int
   System.arraycopy(list,0,listCopy,0,list.length);//複製到測試用list

   System.out.println("Array Size:"+number);//測試的list長度
 
   //selection sort time
   System.out.println("Selection sort: "+selectionSort(listCopy));

   //複製未排序list重新測試
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
   long startTime = System.currentTimeMillis();//開始時間

   //迴圈從n開始
   for(int i=list.length - 1;i>=1;i--)
    {
     int currentMax = list[0];//以第一個數為初始最大
     int currentMaxIndex = 0;//初始最大數index
     
     //找出最大的數
     for(int j=1;j<=i;j++)
      {
       if(currentMax<list[j])
        {
         currentMax = list[j];
         currentMaxIndex = j;
        }
      }
     
     //將最大的數放到目前的index
     if(currentMaxIndex != i)
      {
       list[currentMaxIndex] = list[i];
       list[i] = currentMax;
      }
    }

   long endTime = System.currentTimeMillis();//結束時間
   return endTime - startTime;//兩數相減為實際執行時間
  }

 //insertion sort
 public static long insertionSort(int[] list)
  {
   long startTime = System.currentTimeMillis();//開始時間

   for(int i=1;i<list.length;i++)
    {
     int currentElement = list[i];//目前index的element
     int k;
     //往前迴圈 若第n-1項element較大 取代第n項
     //直到n<0或n-1較小
     for(k = i-1;k>=0&&list[k]>currentElement;k--)
      list[k+1] = list[k];
     
     list[k+1] = currentElement;//插入element
    }

   long endTime = System.currentTimeMillis();//結束時間
   return endTime - startTime;//兩數相減為實際執行時間
  }

 //bubble sort
 public static long bubbleSort(int[] list)
  {
   long startTime = System.currentTimeMillis();//開始時間

   boolean needNextPass = true;//判斷是否繼續排序
   
   for(int k = 1;k<list.length && needNextPass;k++)
    {
     needNextPass = false;
     
     for(int i=0;i<list.length-k;i++)
      {
       //若有需要交換的element 交換後繼續進行下一次排序
       if(list[i] > list[i+1])
        {
         int temp = list[i];
         list[i] = list[i+1];
         list[i+1] = temp;
         needNextPass = true;
        }
      }
    }

   long endTime = System.currentTimeMillis();//結束時間
   return endTime - startTime;//兩數相減為實際執行時間
  }

 //merge sort
 public static long mergeSort(int[] list)
  {
   long startTime = System.currentTimeMillis();//開始時間

   //直到長度為1為止 分割矩陣
   if(list.length>1)
    {
     //上半部分
     int[] firstHalf = new int[list.length/2];
     System.arraycopy(list,0,firstHalf,0,list.length/2);
     mergeSort(firstHalf);//遞迴

     //下半部分
     int secondHalfLength = list.length - list.length/2;//下半開始index
     int[] secondHalf = new int[secondHalfLength];
     System.arraycopy(list,list.length/2,secondHalf,0,secondHalfLength);
     mergeSort(secondHalf);//遞迴


     int[] temp = merge(firstHalf,secondHalf);//將兩個矩陣排序結合
     System.arraycopy(temp,0,list,0,temp.length);//取代原矩陣
    }

   long endTime = System.currentTimeMillis();//結束時間
   return endTime - startTime;//兩數相減為實際執行時間
  }

 //結合矩陣method
 private static int[] merge(int[] list1,int[] list2)
  {
   int[] temp = new int[list1.length+list2.length];

   int current1 = 0;//上半index
   int current2 = 0;//下半index
   int current3 = 0;//結合矩陣index

   //直到其中一邊index超過長度
   while(current1 < list1.length && current2 < list2.length)
    {
     //比較兩個矩陣目前index的element 將較小的放入結合矩陣
     if(list1[current1] < list2[current2])
      temp[current3++] = list1[current1++];
     else
      temp[current3++] = list2[current2++];
    }

   //將剩下沒放的element直接放入
   while(current1 < list1.length)
    temp[current3++] = list1[current1++];
   
   while(current2 < list2.length)
    temp[current3++] = list2[current2++];
   
   return temp;//回傳
  }

 //quick sort
 public static long quickSort(int[] list)
  {
   long startTime = System.currentTimeMillis();//開始時間

   quickSort(list,0,list.length-1);//call method

   long endTime = System.currentTimeMillis();//結束時間
   return endTime - startTime;//兩數相減為實際執行時間
  }

 //helper method
 public static void quickSort(int[] list,int first,int last)
  {
   if(last > first)
    {
     int pivotIndex = partition(list,first,last);//基準的index
     //以基準為界分兩部份繼續排序
     quickSort(list,first,pivotIndex-1);
     quickSort(list,pivotIndex+1,last);
    }
  }

 //分割並排序
 private static int partition(int[] list,int first,int last)
  {
   int pivot = list[first];//基準
   int low = first + 1;//前半起始index
   int high = last;//後半結尾index

   //將前半大於基準的element和後半小於基準的element互換
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
   
   //將基準移動到前半與後半交界
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
   long startTime = System.currentTimeMillis();//開始時間

   Heap heap = new Heap();//heap tree

   //放入heap中 會按照heap規則排序
   for(int i=0;i<list.length;i++)
    heap.add(list[i]);

   //按順序取代原list
   for(int i=list.length-1;i>=0;i--)
    list[i] = (Integer)(heap.remove());

   long endTime = System.currentTimeMillis();//結束時間
   return endTime - startTime;//兩數相減為實際執行時間
  }
}