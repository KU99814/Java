//Finding numbers divisible by 5 or 7 ,but not both

public class EX4_11
{
 public static void main(String args[])
  {
   int count = 0; //計算輸出個數 換排用
   for(int i = 100;i<1001;i++)//從100到1000
    {
     if(i%5==0 ^ i%7==0) //被5或7但不被兩者整除
      {
       if(count > 9)
        {
         System.out.print("\n");
         count = 0;
        }
       System.out.print(i+" ");
       count++;
      }
    }
  }
}