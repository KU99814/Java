//Game:craps

public class EX5_29
{
 public static void main(String args[])
  {
   //�������l   
   int num1 = (int)(Math.random()*6)+1;
   int num2 = (int)(Math.random()*6)+1;
   int sum = num1+num2;
   int point = 0;
   
   System.out.println("You rolled "+num1+" + "+num2+" = "+(num1+num2));
     
   if(sum == 7 || sum == 11) //�ӧQ������
     System.out.print("You Win");
   else if(sum ==2 || sum == 3 || sum==12) //���Ѫ�����
    System.out.print("You Lose");
   else //�������~
    {
     point = sum;
     System.out.println("point is "+point);
         
     while(true) //�����Y
      {
       num1 = (int)(Math.random()*6)+1;
       num2 = (int)(Math.random()*6)+1;
       sum = num1+num2;
       
       System.out.println("You rolled "+num1+" + "+num2+" = "+(num1+num2));
       
       if(sum == 7) //�ѥ_����
        {
         System.out.print("You Lose");
         break;
        }
       else if(sum == point)  //�ӧQ����
        {
         System.out.print("You Win");
         break;
        }
      }
    }
  }
}
