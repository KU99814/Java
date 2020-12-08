//氣泡排序法

public class EX6_18
{
 public static void main(String args[])
  {
   double[] num = {6.0,4.4,1.9,4.9,3.4,0.9,1.5}; //宣告陣列

   //顯示
   System.out.print("The array is ");
   for(int i=0;i<num.length;i++)
    System.out.print(num[i]+" ");
   
   System.out.println();

   //排序
   bubbleSort(num);

   //顯示排序後陣列
   System.out.print("Now the array is ");
   for(int i=0;i<num.length;i++)
    System.out.print(num[i]+" ");
  }

 //氣泡排序的method
 public static void bubbleSort(double[] list)
  {
   boolean flag = true; //偵測的flag
   double temp = 0; /* Temporary value for swapping two elements */
 
   for(int i = 0; i < list.length;i++)//因為每次排完最大數定在最右 故每次最後index-1
    {
     flag = true;

     //將相鄰兩個數依照遞增排列 直到整個數列完全遞增排列為止
     for (int j = 0; j<list.length -i -1;j++)
      {
       if (list[j] > list[j+1])
        {
         temp = list[j];
         list[j] = list[j + 1];
         list[j + 1] = temp;
         flag = false;
        } // end if
      } // end for j = ...
 
    if (flag == true)
     break; 
   } // end for i = ...
 }
}