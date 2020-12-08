//Summing a series

public class EX4_24
{
 public static void main(String args[])
  {
   double a = 1;//分子
   double b = 3; //分母
   double sum = 0; //總和

   //計算 1/3+3/5+5/7+7/9+......+97/99
   for(a = 1;a<=97;a+=2)
    {
     sum+=(a/b);
     b+=2;
    }
   System.out.print("The sum is "+sum);
  }
}