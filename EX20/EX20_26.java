//Amount from coins

import java.util.Scanner;

public class EX20_26
{
 public static void main(String args[]) throws IllegalArgumentException
  {
   Scanner input = new Scanner(System.in);//宣告輸入
   
   System.out.print("Enter the number of set: "); //輸入硬幣種類的數量
   int num = input.nextInt();

   int[] a = new int[num];

   System.out.print("Enter the set of cent: ");  //輸入硬幣種類
   for(int i=0;i<num;i++)
    {
     a[i] = input.nextInt();
    
     if(a[i]<0)
      throw new IllegalArgumentException("The number is negative");
    }

   linearSort(a);//從新排序 面額從小到大

   for(int i=0;i<num;i++)
    System.out.print(a[i]+" ");

   System.out.print("Enter a amount: "); //輸入總價
   int amount = input.nextInt();
   
   int[] coinCount = coin(amount,a,num-1); //以遞迴求出有幾種組合

   //求出最小組合
   int min = -1;
   for(int i=0;i<coinCount.length;i++)
    {
     if(coinCount[i]>min)
      min = coinCount[i];
    }
   if(min == -1) //若為負 則無組合
    System.out.print("No present");
   else
    {
     for(int i=0;i<coinCount.length;i++)
      {
       if(coinCount[i]<min&&coinCount[i]>0)
        min = coinCount[i];
      }
     System.out.print("THe minimum number of coins are "+min);//顯示最小硬幣數
    }
   
  }

 //sort
 public static void linearSort(int[] set)
  {
   for(int i=0;i<set.length-1;i++)
    {
     for(int j=i+1;j<set.length;j++)
      {
       if(set[i]>set[j])
        {
         int temp = set[i];
         set[i] = set[j];
         set[j] = temp;
        }
      }
    }
  }

 //遞迴 取得組合硬幣數
 public static int[] coin(int amount,int[] a,int length) throws IllegalArgumentException
  {
   int c = length;//硬幣陣列長度

   if(length==-1)//base case
    return new int[0];
   else //從面額最大開始減去 可得最小硬幣數
    {
     int count = 0;//硬幣數
     int nowAmount = amount;//總數
     while(nowAmount>0)//直到總數小於等於零
      {
       if(c<0)//若每有更小面額且餘額不為0 硬幣數設為-1
        {
         count = -1;
         break;
        }

       if(a[c]<0)
        {
         throw new IllegalArgumentException("The value is negative");
        }

       if(nowAmount>=a[c])//減去面額直到小於面額
        {
         nowAmount -= a[c];
         count++;
        }
       else
        c--;
      }
     
     try{
      int[] b = coin(amount,a,length-1);//遞迴取得較小面額硬幣數陣列
      int[] rb = new int[b.length+1];//加上這一次硬幣數的新陣列

      //加入新陣列
      for(int i=0;i<b.length;i++)
       rb[i] = b[i];
      rb[rb.length-1] = count;//加入這次硬幣數
      return rb;  //回傳
     }
     catch(IllegalArgumentException ex){ //例外
      System.out.println("There is not present");
     }
     return new int[0];
    }
  }
}