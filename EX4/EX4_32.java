//Perfect Number

public class EX4_32
{
 public static void main(String args[])
  {
   for(int i = 2;i <= 10000;i++)
    {
     int sum = 0; //羆计
     for(int j = 1;j< i;j++)
      {
       //тi计
       if(i % j == 0)
        {
         sum += j;
        }
      }
     //狦才Ч计 块
     if(sum == i)
      {
       System.out.print(i+" ");
      }
    }
  }
}