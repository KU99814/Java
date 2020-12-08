// find the three highest score

import java.util.Scanner;

public class EX4_9
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//宣告輸入
  
   System.out.print("Enter the student number: ");
   int num = input.nextInt(); //輸入學生數

   //前三高分
   int max1 = 0; 
   int max2 = 0;
   int max3 = 0;

   for(int i = 0;i<num;i++)//依學生數執行
    {
     System.out.print("Enter the "+(i+1)+"student's score: ");
     int score = input.nextInt();
      
     //比較是否前三高分並排序
     if(score > max1)//比最高分高
      {
       max3 = max2;
       max2 = max1;
       max1 = score;
      }

     else if(score > max2)//比第二高分高
      {
       max3 = max2;
       max2 = score;
      }

     else if(score > max3)//比第三高分高
      {
       max3 = score;
      }
   
    }
   
   //輸出結果
   System.out.println("The highest score is: " + max1);
   System.out.println("The second-highest score is: " + max2);
   System.out.println("The third-highest score is: " + max3);
  }
}     