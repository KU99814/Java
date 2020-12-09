//Generic Maximum element in an array

import java.util.*;

public class EX21_5
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
   
   int max = EX21_5.<Integer>max(array);//找出最大值
   System.out.println("The max number in array is "+max);//顯示
  }

 public static<E extends Comparable<E>> E max(E[] list)
  {
   E max = list[0];//預設最大值

   for(int i=1;i<list.length;i++)
    {
     if(max.compareTo(list[i])<0)//比較
      max = list[i];
    }

   return max;//回傳
  }
}  