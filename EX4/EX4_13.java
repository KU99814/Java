//Finding the largest n such that n2 < 30000

public class EX4_13
{
 public static void main(String args[])
  {
   int i = 1; //初始的數

   while(true)//找出滿足平方後最接近但小於30000的數
    {
     double n = Math.pow(i,2); //將i平方

     if(n>30000) //若大於30000 跳出
      {
       break;
      }
     i++;
    }
   
   //顯示i-1 因為i平方大於30000
   System.out.print("The largest n such that n2 < 30000 is "+(i-1));
  }
}