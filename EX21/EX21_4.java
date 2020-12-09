//Generic insertion sort

import java.util.*;

public class EX21_4
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//宣告輸入
 
   System.out.print("Enter the number of data: ");
   int num = input.nextInt();//輸入陣列長度

   Integer[] array = new Integer[num];//宣告陣列
   System.out.print("Enter numbers: ");//輸入陣列
   for(int i=0;i<num;i++)
    array[i] = input.nextInt();
   
   EX21_4.<Integer>insertionSort(array);//陣列排序
   System.out.println("The array after sort is: ");//顯示結果
   for(int i=0;i<num;i++)
    System.out.print(array[i]+" ");
  }

 //插入排序
 public static <E extends Comparable<E>> void insertionSort(E[] list)
  {
   for(int i=1;i<list.length;i++)
    {
     E currentElement = list[i];//目前值
     int k;
     //跟目前值依序比較 若比目前值大 往前排
     for(k=i-1;k>=0 && list[k].compareTo(currentElement)>0;k--)
      {
       list[k+1] = list[k];
      }

     //插入往前排後的空格
     list[k+1] = currentElement;
    }
  }
}  