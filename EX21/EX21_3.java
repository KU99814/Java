//Generic selection sort

import java.util.*;

public class EX21_3
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//宣告輸入
 
   System.out.print("Enter the number of data: ");
   int num = input.nextInt(); //輸入陣列長度

   Integer[] array = new Integer[num];//宣告陣列
   System.out.print("Enter numbers: ");//輸入陣列
   for(int i=0;i<num;i++)
    array[i] = input.nextInt();
   
   EX21_3.<Integer>selectionSort(array);//陣列做排序
   System.out.println("The array after sort is: ");//顯示排序後結果
   for(int i=0;i<num;i++)
    System.out.print(array[i]+" ");
  }

 //選擇排序
 public static<E extends Comparable<E>> void selectionSort(E[] list)
  {
   for(int i=list.length-1;i>=1;i--)
    {
     E currentMax = list[0];//現在最大
     int currentMaxIndex = 0;//現在最大索引值
     
     //從最下面依序比較
     for(int j=1;j<=i;j++)
      {
       if(currentMax.compareTo(list[j])<0)//有更大值就替換 
        {
         currentMax = list[j];
         currentMaxIndex = j;
        }
      }

     if(currentMaxIndex != i)//如果最上面不是最大 互換
      {
       list[currentMaxIndex] = list[i];
       list[i] = currentMax;
      }
    }
  }
}  