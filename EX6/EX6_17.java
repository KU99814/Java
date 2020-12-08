//讓陣列右移

public class EX6_17
{
 public static void main(String args[])
  {
   int[] num = {1,2,3,4,5};

   System.out.print("The array is "); //顯示初始陣列
   for(int i=0;i<num.length;i++)
    System.out.print(num[i]+" ");
   
   System.out.println();
   shiftRight(num);
   System.out.print("Now the array is "); //顯示右移後陣列
   for(int i=0;i<num.length;i++)
    System.out.print(num[i]+" ");
  }

 public static void shiftRight(int[] list)
  {
   int temp = list[list.length-1]; //儲存最尾index的數

   for(int i=list.length-1;i>=1;i--) //右移
    list[i] = list[i-1];
   
   list[0] = temp; //把尾數移到頭
  }
}
