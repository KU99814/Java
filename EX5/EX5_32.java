//Game:craps run in 10000 times
 
public class EX5_32
{
 static int win = 0;//贏的次數

 public static void main(String args[])
  {
   
   for(int i=0;i<10000;i++)
    craps();

   System.out.print("You win "+win);
  }

 public static void craps()
  {
   //模擬兩骰子
   int num1 = (int)(Math.random()*6)+1;
   int num2 = (int)(Math.random()*6)+1;
   int sum = num1+num2; //相加
   int point = 0; //平手時紀錄點數
     
   //System.out.println("You rolled "+num1+" + "+num2+" = "+(num1+num2));//顯示結果
     
   //勝利
   if(sum == 7 || sum == 11)
    {
    // System.out.println("You Win");
     win++;
    }
    //敗北
   /*else if(sum ==2 || sum == 3 || sum==12)
      System.out.println("You Lose");*/
   else//平手時狀況改變
    {
     point = sum;
     //System.out.println("point is "+point);
     while(true) //重複擲
      {
       num1 = (int)(Math.random()*6)+1;
       num2 = (int)(Math.random()*6)+1;
       sum = num1+num2;
       
       //System.out.println("You rolled "+num1+" + "+num2+" = "+(num1+num2));
       
       if(sum == 7) //敗北條件
        {
       //  System.out.println("You Lose");
         break;
        }
       else if(sum == point)  //勝利條件
        {
         //System.out.println("You Win");
         win++;
         break;
        }
      }
    }
  }
}