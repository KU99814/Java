//Game:craps run in 10000 times
 
public class EX5_32
{
 static int win = 0;//Ĺ������

 public static void main(String args[])
  {
   
   for(int i=0;i<10000;i++)
    craps();

   System.out.print("You win "+win);
  }

 public static void craps()
  {
   //�������l
   int num1 = (int)(Math.random()*6)+1;
   int num2 = (int)(Math.random()*6)+1;
   int sum = num1+num2; //�ۥ[
   int point = 0; //����ɬ����I��
     
   //System.out.println("You rolled "+num1+" + "+num2+" = "+(num1+num2));//��ܵ��G
     
   //�ӧQ
   if(sum == 7 || sum == 11)
    {
    // System.out.println("You Win");
     win++;
    }
    //�ѥ_
   /*else if(sum ==2 || sum == 3 || sum==12)
      System.out.println("You Lose");*/
   else//����ɪ��p����
    {
     point = sum;
     //System.out.println("point is "+point);
     while(true) //�����Y
      {
       num1 = (int)(Math.random()*6)+1;
       num2 = (int)(Math.random()*6)+1;
       sum = num1+num2;
       
       //System.out.println("You rolled "+num1+" + "+num2+" = "+(num1+num2));
       
       if(sum == 7) //�ѥ_����
        {
       //  System.out.println("You Lose");
         break;
        }
       else if(sum == point)  //�ӧQ����
        {
         //System.out.println("You Win");
         win++;
         break;
        }
      }
    }
  }
}