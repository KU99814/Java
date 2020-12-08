//head or tail

public class EX4_23
{
 public static void main(String args[])
  {
   int head = 0; //正面次數
   int tail = 0; //反面次數
   
   for(int i = 0;i<1000000;i++) //進行1百萬次
    {
     int coin = (int)(Math.random()*2); //以隨機0或1模擬硬幣正反面
      
     if(coin == 1)
      head++;
     else if(coin == 0)
      tail++;
    }
   
   System.out.print("The head has "+head+" the tail has "+tail);
  }
}
  
