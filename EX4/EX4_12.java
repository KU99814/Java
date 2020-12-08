//Finding the smallest n such that n2 < 12000

public class EX4_12
{
 public static void main(String args[])
  {
   int i = 1; //初始的數
   while(true)
    {
     double n = Math.pow(i,2); //將i平方
     if(n>12000) //如果大於12000 跳出迴圈
      {
       break;
      }
     i++;
    }
 
   System.out.print("The smallet n that n2 < 12000 is "+i);
  }
}