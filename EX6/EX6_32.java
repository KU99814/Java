//計算利率

import java.util.Scanner;

public class EX6_32
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//宣告輸入

   double[] rates = {0.10,0.15,0.27,0.30,0.35,0.386}; //利率
   int[][] brackets = {{6000,27950,67700,141250,307050}, 
                       {12000,46700,112850,171950,307050},
                       {6000,23350,56425,85975,153525},
                       {10000,37450,96700,156600,307050}}; //依造模式和金額大小分類算法

   System.out.println("0-single filer, 1-married jointly,");
   System.out.println("2-married separately, 3-heah of hoursehold");

   System.out.print("Enter the filling status: "); //輸入模式
   int k = input.nextInt();

   System.out.print("Enter the taxable income: "); //輸入金額
   int income = input.nextInt();

   int incomeTo = 0;

   //分類金額區間
   for(int index=0;index<brackets[k].length;index++) 
    {
     if(income > brackets[k][index])
      {
       incomeTo++;
      }
     else
      break;     
    }

   double tax = 0;

   System.out.println(incomeTo);
 
   //計算
   for(int i=0;i<incomeTo+1;i++)
    {
     if(i == 0)//頭
      tax += brackets[k][i]*rates[i];
     else if(i == incomeTo)//尾
      tax += (income - brackets[k][i-1])*rates[i];
     else//中間
      tax += (brackets[k][i] - brackets[k][i-1])*rates[i];
    }
 
   System.out.print("Tax is "+tax);
  }
}
       