//Perfect Number

public class EX4_32
{
 public static void main(String args[])
  {
   for(int i = 2;i <= 10000;i++)
    {
     int sum = 0; //加總因數
     for(int j = 1;j< i;j++)
      {
       //找出i的因數
       if(i % j == 0)
        {
         sum += j;
        }
      }
     //如果符合完美數 輸出
     if(sum == i)
      {
       System.out.print(i+" ");
      }
    }
  }
}