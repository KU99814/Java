//找出陣列中重複的數

import java.util.Scanner;

public class EX6_5
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //宣告輸入
   int[] num = new int[11];      //存放的陣列

   System.out.print("Enter number:");
   for(int i=0;i<11;i++) //輸入數字
    {     
     num[i] = input.nextInt();
    }

   int[] duplicate = new int[11]; //存放第一次出現過的數的陣列
   int dupIndex = 0; //出現過一次的數的個數

   //找出出現過一次的數
   for(int i=0;i<11;i++)
    {
     if(!search(num[i],dupIndex,duplicate))//如果沒找到 加入
      {
       duplicate[dupIndex] = num[i];
       dupIndex++;
      }
    }

    //若重複數陣列數等於輸入陣列數 代表沒有重複
    if(dupIndex==11)
     System.out.print("There is no duplicate");
    else
     {
      System.out.print("There are duplicate numbers:"); //顯示重複的數
      
      for(int i=0;i<dupIndex;i++)//重複數陣列作loop
       {
        boolean check = false;//檢查是否出現過
      
        for(int j=0;j<11;j++)
         {
          if(num[j]==duplicate[i])//若等於出現過的數再作判斷
           {
            if(check)//前面出現過一次 即顯示
             {
              System.out.print(num[j]+" ");
              break;
             }
            else //出現第一次時 轉為true
             check = true;
           }
         }
       }
     }
  }

 //搜尋是否存在陣列
 public static boolean search(int key,int index,int[] num)
  {
   for(int i=0;i<index;i++)
    {
     if(num[i]==key)
      {
       return true; //若有回傳true
      }
    }     
   
   return false;//若無回傳false
  }
}