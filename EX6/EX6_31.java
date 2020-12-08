//用質因數分解求最小公倍數

import java.util.Scanner;

public class EX6_31
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//宣告輸入
 
   System.out.print("Enter the first number: "); //輸入第一個數
   int num1 = input.nextInt();

   System.out.print("Enter the second number: "); //輸入第二個數
   int num2 = input.nextInt();

   int PN = primeNumber(num1,num2); //算出最大的長度
   
   int[][] table1 = new int[PN][2]; //存放質因數的陣列 第二維為0是質數 1是質數個數
   int[][] table2 = new int[PN][2];
   
   getPrimeFactor(num1,table1); //存入質因數
   getPrimeFactor(num2,table2);

   int GCD = 1;//最大公因數
   
   //乘出最大公因數
   for(int i=0;i<table1.length;i++) 
    {
     for(int j=0;j<table2.length;j++)
      {
       if(table1[i][0] == table2[j][0]) //如果有相同質因數
        {
         if(table1[i][1] > table2[j][1]) //選出最小乘積的乘
          GCD*=(int)(Math.pow(table2[j][0],table2[j][1]));
         else 
          GCD*=(int)(Math.pow(table1[i][0],table1[i][1]));
         break;
        }
      }
    }
   int LCM = (num1*num2) /GCD;//兩數相乘再除以最大公因數
   System.out.print("The LCM of "+num1+" and "+num2+" is "+LCM); //顯示
  } 

 public static int primeNumber(int num1,int num2) //找出最多質因數個數
  {
   int list1 = 0;
   int list2 = 0;

   int max = 0;

   //已大的為停止基準
   if(num1>num2)
    max = num1;
   else
    max = num2;

   //比較質因數種類誰多
   for(int i=2;i<max+1;i++)
    {
     if(isPrime(i))
      {
       if(num1>=i && num1%i == 0)
        list1++;

       if(num1>=i && num2%i == 0)
        list2++;
      }
    }

   //回傳多的
   if(list1>list2)
    return list1;
   else
    return list2;
  }

 public static boolean isPrime(int num) //判斷是否質數
  {
   int divide = (int)Math.sqrt(num);//基準除數

   //若能整除則否
   for(int i=2;i<=divide;i++)
    {
     if(num%i==0)
      return false;
    }

   return true;
  }

 public static void getPrimeFactor(int num , int[][] table) //存入質因數
  {
   int k = 0; //第K個質因數
   for(int i=2;i<=num;i++)
    {
     if(isPrime(i) && num % i == 0)
      {
       table[k][0] = i; 
       while(true)
        {
         num /= i;
         table[k][1]++; //存入質因數個數
         if(num%i!=0)
          break;
        }
       k++;
      }
     if(num == 1)
      break;
    } 
  }
}
    
