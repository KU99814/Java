//反轉陣列

public class EX6_12
{
 public static void main(String args[])
  {
   int[] num = {1,2,3,4,5}; //設陣列

   System.out.print("The original array: "); //顯示原先陣列
   for(int i=0;i<num.length;i++)
    System.out.print(num[i]+" ");
   System.out.println();
   
   reverse(num); //反轉

   System.out.print("The reverse array: "); //顯示反轉陣列
   for(int i=0;i<num.length;i++)
    System.out.print(num[i]+" ");
  }

 //逆轉陣列method
 public static void reverse(int[] array)
  {
   //起始index
   int high = array.length-1;//§À
   int low = 0;//ÀY

   //頭尾交接迴圈
   while(low<=high)
    {
     //頭尾交接
     int temp = array[low];
     array[low] = array[high];
     array[high] = temp;
     low++;
     high--;
    }   
  }
}
