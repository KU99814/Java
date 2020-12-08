//reversing the numbers enters

import java.util.Scanner;

public class EX6_1
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //块

   int[] num = new int[5]; //计皚

   System.out.print("Enter five numbers: ");
   for(int i=0;i<5;i++)
    num[i] = input.nextInt(); //盢计ㄌ计皚

   System.out.print("THe origion series is: ");//陪ボ腁玡计
   for(int i=0;i<5;i++)
    System.out.print(num[i]+" ");

   
   reverse(num);

   System.out.print("\nTHe reverse series is: ");//陪ボ腁计
   for(int i=0;i<5;i++)
    System.out.print(num[i]+" ");
  }

 //盢计腁method
 public static void reverse(int[] num)
  {
   //皚index
   int low = 0;//繷
   int high = num.length-1;//Ю
   
   //癹伴腁
   while(true)
   {
    //璝繷Юindexユ 铬癹伴
    if(high<=low)
     break;
    
    //跑计ユ传
    int temp = num[low];
    num[low] = num[high];
    num[high] = temp;

    //繷ЮindexΜ罽
    high--;
    low++;
   }
  }
}