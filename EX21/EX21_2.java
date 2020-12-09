//Generic binary search

import java.util.*;

public class EX21_2
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//宣告輸入
 
   System.out.print("Enter the number of data: ");
   int num = input.nextInt();//輸入陣列長度

   Integer[] array = new Integer[num];//宣告陣列
   System.out.print("Enter numbers: ");//輸入陣列數字 按順序從小到大
   for(int i=0;i<num;i++)
    array[i] = input.nextInt();
   
   System.out.print("Enter the key you want to find: ");
   Integer key = input.nextInt();//輸入要尋找的數字
   
   int index = EX21_2.<Integer>binarySearch(array,key)+1; //做二元搜尋
   System.out.print("The key is in "+index);
  }

 //二元搜尋
 public static <E extends Comparable<E>> int binarySearch(E[] list,E key)
  {
   int low = 0;//低位

   int high = list.length - 1;//高位

   //如果高低沒有交叉
   while(high>=low)
    {
     int mid = (low+high)/2;//中位

     //比較是否等於key extends Comparable所以使用compareTo比較
     if(key.compareTo(list[mid])<0)
      high = mid-1;
     else if(key.compareTo(list[mid])==0)
      return mid;
     else
      low = mid +1;
    }

   return -low-1;//沒有找到回傳負值
  }
}  