//Finding numbers divisible by 5 and 6

public class EX4_10
{
 public static void main(String args[])
  {
   int count = 0; //計算輸出個數 以便輸出時排序
   for(int i = 100;i < 1001;i++) //從100到1000
    {
     if(i % 5 == 0 && i % 6 == 0) //如果可同時被5和6整除 輸出數字
      {
       System.out.print(i+" ");

       if(count ==9)//第十個數斷行
        {
         System.out.print("\n");
         count = 0;
        }
       else
        count++;
      }
    }
  }
}