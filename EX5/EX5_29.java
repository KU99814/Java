//Game:craps

public class EX5_29
{
 public static void main(String args[])
  {
   //模擬兩骰子   
   int num1 = (int)(Math.random()*6)+1;
   int num2 = (int)(Math.random()*6)+1;
   int sum = num1+num2;
   int point = 0;
   
   System.out.println("You rolled "+num1+" + "+num2+" = "+(num1+num2));
     
   if(sum == 7 || sum == 11) //勝利的情形
     System.out.print("You Win");
   else if(sum ==2 || sum == 3 || sum==12) //失敗的情形
    System.out.print("You Lose");
   else //除此之外
    {
     point = sum;
     System.out.println("point is "+point);
         
     while(true) //重複擲
      {
       num1 = (int)(Math.random()*6)+1;
       num2 = (int)(Math.random()*6)+1;
       sum = num1+num2;
       
       System.out.println("You rolled "+num1+" + "+num2+" = "+(num1+num2));
       
       if(sum == 7) //敗北條件
        {
         System.out.print("You Lose");
         break;
        }
       else if(sum == point)  //勝利條件
        {
         System.out.print("You Win");
         break;
        }
      }
    }
  }
}
