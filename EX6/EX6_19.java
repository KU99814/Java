//以降幕法排列陣列

public class EX6_19
{
 public static void main(String args[])
  {
   int[] num = {5,8,6,7,3}; //設陣列

   System.out.print("The array is "); //顯示原先陣列
   for(int i=0;i<num.length;i++)
    System.out.print(num[i]+" ");

   deInsertionSort(num); //排序
   System.out.println();

   System.out.print("Now the array is "); //顯示排序後陣列
   for(int i=0;i<num.length;i++)
    System.out.print(num[i]+" ");
  }

//insert sort descrease
 public static void deInsertionSort(int[] list)
  {
   for(int i=1;i<list.length;i++) //從一開始
    {
     int currentElement = list[i]; //當前值
     int k;
     for(k=i-1;k>=0&&list[k]<currentElement;k--) //如果比當前值大 對調
      list[k+1] = list[k];

     list[k+1] = currentElement;
    }
  }
}