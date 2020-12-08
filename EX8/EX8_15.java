//Ordering the numbers

public class EX8_15
{
 public static void main(String args[])
  {
   int[] num = new int[args.length]; //轉換成數字

   for(int i=0;i<args.length;i++)
    num[i] = Integer.parseInt(args[i]);
   
   for(int i=0;i<num.length;i++) //排列 用selection sort
    {
     for(int j = i+1;j<num.length;j++)
      {
       if(num[i] > num[j])
        {
         int temp = num[i];
         num[i] = num[j];
         num[j] = temp;
        }
      }
    }

   System.out.print("The order is "); //輸出
   for(int i=0;i<num.length;i++)
    System.out.print(num[i] + " ");
  }
}