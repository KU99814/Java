//тぃ疭﹚计计程そ计

import java.util.Scanner;

public class EX6_14
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//块

   System.out.print("Enter a number of amount: "); //∕﹚计秖
   int amount = input.nextInt();
   
   if(amount == 0) //狦琌箂
    System.out.print("No number");
   else
    {
     int[] num = new int[amount]; //块计

     System.out.print("Enter "+amount+" numbers: ");
     for(int i=0;i<num.length;i++)
      num[i] = input.nextInt();

     int GCD = gcd(num);

     if(GCD>0)     
      System.out.print("The GCD is "+GCD); //陪ボ
     else
      System.out.print("The GCD is no exist");//
    }
  }

 public static int gcd(int... number)
  {
   int min = number[0]; //т程
   for(int i=1;i<number.length;i++)
    if(number[i]<min)
     min=number[i];

   //眖程计秨﹍тGCD
   while(0 < min)
    {
     boolean de = true;

     for(int i=0;i<number.length;i++) //笲衡
      {
       if(number[i]%min!=0) //狦埃ぃ荷 铬
        {
         de = false;
         break;
        }
      }

     if(de) //狦埃荷 盿
      return min;
     min--;//тぃ碞-1膥尿
    }

   return -1;
  }
}