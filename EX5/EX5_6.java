//排成三角型

import java.util.Scanner;

public class EX5_6
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //宣告輸入

   System.out.print("Enter a number of lines: "); //輸入行數
   int number = input.nextInt();

   displzyPattern(number);  //顯示
  }

 //顯示金字塔的method
 /*
           1
         2 1
       3 2 1
   ...
  */
 public static void displzyPattern(int n)
  {
   //r = row c = cloumn
   for(int r = 1;r<=n;r++)  //校正
    {
     for(int c=n;c>=1;c--)
      {
       if(c-r>0) //顯示空格
        {
         if(c>=10)
          System.out.print("  ");
         else
          System.out.print(" ");
        }
       else //行數與顯示數字相同時開始顯示數字
        System.out.print(c);
       
       System.out.print(" ");
      }
     System.out.println();
    }
  }
}