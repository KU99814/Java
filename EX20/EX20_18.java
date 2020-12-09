//Tower of Hanoi count

import java.util.Scanner;

public class EX20_18
{
 static int count = 0;//method call計數
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//宣告輸入

   System.out.print("Enter number of disks: ");
   int n = input.nextInt();//輸入碟數

   System.out.println("The moves are: ");
   moveDisks(n,'A','B','C');//移動河內塔
   System.out.print("The number of move is "+count);//計算移動次數
  }

 //河內塔移動
 public static void moveDisks(int n,char fromTower,char toTower,char auxTower)
  {
   count++;//計數+1
   if(n==1)//base case
    {
     System.out.println("Move disk "+n+" from "+fromTower+" to "+toTower);//顯示
    }
   else
    {
     moveDisks(n-1,fromTower,auxTower,toTower);
     System.out.println("Move disk "+n+" from "+fromTower+" to "+toTower);//顯示
     moveDisks(n-1,auxTower,toTower,fromTower);
    }
  }
}