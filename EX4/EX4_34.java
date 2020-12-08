//rock,scissor,paper

import java.util.Scanner;

public class EX4_34
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //宣告輸入
   int comWin = 0; //電腦贏次數
   int useWin = 0; //玩家贏次數
   
   while(true)
    {
     int com = (int)(Math.random()*3);//隨機產生0~2 代表剪刀石頭布

     System.out.print("Enter a number of 0 for rock,1 for scissor and 2 for paper: ");
     int use = input.nextInt(); //輸入使用者出的
     
     //比勝負
     int race = com - use;//結果

     System.out.println("com:"+com+" use:"+use);//雙方出的

     if(race==-1 || race == 2)
      {
       System.out.println("com win"); 
       comWin++;
      }

     else if(race ==1 || race == -2)
      {
       System.out.println("user win"); 
       useWin++;
      }     

     if(comWin == 2 || useWin == 2)//有人兩勝就跳出
      break;
    }
   //顯示勝負
   if(comWin == 2)
    System.out.print("the winner is computer");
   else if(useWin == 2)
    System.out.print("the winner is user");
  }
}
