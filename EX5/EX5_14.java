//璸衡计

import java.util.Scanner;

public class EX5_14
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //块

   System.out.print("Enter a integer: "); //计计计
   int i = input.nextInt();

   System.out.print("the series's sum is "+m(i));
  }

 //璸衡计method
 public static double m(int i)
  {
   double sum = 0; //羆
   int plus = 1; //タ璽计

   //4(1-1/3+1/5-1/7+1/9-...+1/2i-1-1/2i+1)
   for(double j = 1;j<=2*i+1;j+=2) //笲衡
    {
     double add = (1/j);
     add *= plus;//タ璽计
     sum += add;
     plus *= -1;//タ璽锣传
    }
   sum *= 4;
  
   return sum;
  }
}