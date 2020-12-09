//Finding the largest number in an array

import java.util.Scanner;

public class EX20_13
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//块

   System.out.print("Enter a number of array's length: ");
   int l = input.nextInt();//块皚计

   int[] a = new int[l];//皚

   System.out.print("Enter numbers of the array: ");
   for(int i=0;i<l;i++)
    a[i] = input.nextInt();//块皚计

   System.out.print("The max number of array is "+max(a));//陪ボ程
  }

 //患癹т程 line search
 public static int max(int[] a)
  {
   return max(a,(a.length-1),0);
  }

 //recursive Helper Methods
 public static int max(int[] a,int high,int m)
  {
   if(a[high]>m)//ゑ
    m = a[high];
   
   if(high==0)//base case
    return m;
   else//患癹眖程index程
    {
     return max(a,high-1,m);
    }
  }
}