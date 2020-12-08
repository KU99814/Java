//bean game

import java.util.Scanner;

public class EX6_29
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //宣告輸入

   System.out.print("Enter the number of balls to drop: "); //輸入球數
   int ball = input.nextInt();

   System.out.print("Enter the number of slots in the bean machine: "); //輸入槓行數
   int slot = input.nextInt();
   int[] slots = new int[slot+1]; //slot代表行 行數+1等於洞數
   
   for(int i=0;i<ball;i++)
    {
     int path = 0;//路徑 最後落入的槽
     for(int j=0;j<slot;j++)
      {
       int via = (int)(Math.random()*2); //以隨機方法決定左右
       path += via; //左+0 右加一
       if(via == 0) //顯示左右
        System.out.print("L");
       else
        System.out.print("R");
      }
     slots[path]++; //放入球
     System.out.println();
    }

   int high = 0;//堆積高度

   for(int i=0;i<slots.length;i++)
    {
     if(slots[i]>high)
      high = slots[i];
    }
   
   for(int i=high;i>0;i--) //顯示球的結果
    {
     for(int j=0;j<slots.length;j++)
      {
       if(slots[j]==(i))//若球數等於高度 顯示並減1
        {
         System.out.print("0");
         slots[j]--;
        }
       else
        System.out.print(" ");
      }
     System.out.println();
    } 
  }
}   
