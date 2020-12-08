//找出Perfext number

public class EX5_15
{
 public static void main(String args[])
  {
   System.out.print("The perfect number is: ");
   //從一到一萬依序檢查
   for(int i = 2;i<=10000;i++)
    {
     if(isPerfect(i))
       System.out.print(i+" ");
    }
  }

 //檢測Perfext number 的method
 public static boolean isPerfect(int number)
  {
   int sum = 1;//加總的變數
   
   for(int i = 2;i<number;i++)
    {
     if(number%i==0) //如果是因數就相加
      {
       sum += i;
      }
    }
   //檢查是否相同
   if(sum == number)
    return true;
   else
    return false;
  }
} 
   