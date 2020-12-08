//倍增陣列容量

import java.util.Scanner;

public class EX6_15
{
 public static void main(String[] args)
  {
   Scanner input = new Scanner(System.in); //宣告輸入

   System.out.print("Enter the length of array: "); //輸入想要的長度
   int amount = input.nextInt();

   int[] array = new int[amount]; //存放數的陣列

   System.out.println("The array capacity is "+array.length); //顯示初始長度
   
   array = doubleCapacity(array); //倍增
   System.out.println("The double capacity is "+array.length); //顯示倍增長度
  }

 public static int[] doubleCapacity(int[] list) //倍增長度
  {
   int[] doubleArray = new int[list.length*2];//創新陣列 兩倍大小

   //將舊陣列數放入 
   for(int i=0;i<list.length;i++)
     doubleArray[i] = list[i];
   return doubleArray; //回傳空陣列 長度*2
  }
}
