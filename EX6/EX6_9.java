//找出最大元素

public class EX6_9
{
 public static void main(String args[])
  { 
   int[] num = {10,22,4,5,10,-120,2,22}; //設陣列

   System.out.print("The largest element is "+largest(num)); //顯示
  }

 public static int largest(int[] array)
  {
   int max = array[0];
   for(int i=1;i<array.length;i++) //比較
    {
     if(array[i]>max)
      max=array[i];
    }
   return max;
  }
}
  