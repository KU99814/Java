//locker puzzle

public class EX6_33
{ 
 public static void main(String args[])
  {
   int[] lockers = new int[100]; //設陣列儲存置物櫃狀態 0關1開

   //初始狀態皆為關
   for(int i=0;i<lockers.length;i++)
    lockers[i] = 0;
  
   for(int i=0;i<lockers.length;i++) //開始操作 開關對調
      {
       //第n個學生開關每第n個鎖
       //計算n的因數 因數個數代表被幾個學生開
       //個數不為偶數則狀況改變
        lockers[i] = lockCount(i+1)%2;
      }
   
   for(int i=0;i<lockers.length;i++) //顯示每一個開關狀態
    {
     System.out.print(lockers[i]+" ");
     if((i+1)%10==0)
      System.out.println();
    }
   
   int count = 0;
   for(int i=0;i<lockers.length;i++) //計算幾個關閉
      {
       if(lockers[i] == 0)
        count++;
      }
   System.out.println("There has "+count+" closed"); //顯示

   System.out.print("The open locker is "); //顯示
   for(int i=0;i<lockers.length;i++)
      {
       if(lockers[i] == 1)
        System.out.print((i+1)+" ");
      }
  }

 public static int lockCount(int num)
  {
   int count = 0;
   //除1以外最小因數是2 因此除以2
   for(int i=1;i<=num/2;i++)
    {
     if(num%i==0)
      count++;
    }   

   return count+1;//自己也要算 所以回傳值加1
  }
}