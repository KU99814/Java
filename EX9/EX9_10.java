//Game:The GuessDate class

import java.util.Scanner;

public class EX9_10
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //宣告輸入
   int date = 0;
   
   for(int i=0;i<5;i++) //出題
    {
     System.out.println("Is your birth date in Set "+(i+1)+"?");
     for(int j=0;j<4;j++) //顯示日期
      {
       for(int k=0;k<4;k++)
        System.out.print(GuessDate.getValue(i,j,k)+" ");
       System.out.println();
      }
     
     System.out.print("\nEnter 0 for no and 1 for yes: "); //回答
     int answer = input.nextInt();
    
     if(answer == 1) //如果有的話 
      date += GuessDate.getValue(i,0,0);
    }

   System.out.println("Your birth date is "+date); //顯示生日
  }
}


//猜謎class
class GuessDate
{
 private static int[][] set1 = {{ 1, 3, 5, 7},{ 9,11,13,15},
                                {17,19,21,23},{25,27,29,31}};
 private static int[][] set2 = {{ 2, 3, 6, 7},{10,11,13,15},
                                {18,19,22,23},{26,27,30,31}};
 private static int[][] set3 = {{ 4, 5, 6, 7},{ 12,13,14,15},
                                {20,21,22,23},{28,29,30,31}};
 private static int[][] set4 = {{ 8, 9,10,11},{12,13,14,15},
                                {24,25,26,27},{28,29,30,31}};
 private static int[][] set5 = {{16,17,18,19},{20,21,22,23},
                                {24,25,26,27},{28,29,30,31}};

 //建構子
 private GuessDate()
  {}

 //回傳需要的問題集中的數字
 public static int getValue(int k,int i,int j)
  {
   switch(k)
    {
     case 0:return set1[i][j];
     case 1:return set2[i][j];
     case 2:return set3[i][j];
     case 3:return set4[i][j];
     case 4:return set5[i][j];
     default: return 0;
    }
  }
}
    