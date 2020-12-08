//計算Linear search和binary search所花時間

public class EX6_16
{
 public static void main(String args[])
  {
   int[] num = new int[100000]; //創造陣列
   for(int i=0;i<num.length;i++)
    num[i] = (int)(Math.random()*10000);

   int key = (int)(Math.random()*10000); //要找的目標

   long startTime = System.currentTimeMillis(); //Linear search開始時間

   if(linearSearch(num,key)!=-1)
    System.out.println("The index of key number is "+linearSearch(num,key)); //Linear search搜尋
   else
    System.out.println("No conform number");

   long endTime = System.currentTimeMillis(); //Linear search結束時間
   System.out.println("This speed of liner search "+
                      (endTime - startTime)+" millisecond"); //Linear search所花時間

   startTime = System.currentTimeMillis(); //insection sort開始時間
   
   insertionSort(num); //由小到大排列

   endTime = System.currentTimeMillis(); //insertion sort結束時間

   System.out.println("The speed of insertion sort is "+(endTime - startTime)+" millisecond");

   startTime = System.currentTimeMillis(); //binary search開始時間

   System.out.println("The index use binary search is "+binarySearch(num,key)); //binary search搜尋

   endTime = System.currentTimeMillis(); //binary search結束時間
   System.out.println("This speed "+(endTime - startTime)+" millisecond"); //binary search所花時間
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
   int low =0; //下位
   int high = list.length-1; //上位
   
   while(high>=low) 
    {
     int mid =(low+high)/2; //中位 跟key比較
     //根據大小決定取代上位或下位
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
     //將現在的數跟前面的數比較 如果前面的數較大 就往前取代直到前面的數是較小的
     for(k=i-1;k>=0&&list[k]>currentElement;k--)
      list[k+1]=list[k];

     list[k+1]= currentElement;
    }
  }
}