import java.util.*;

public class EX10_3
{
 public static void main(String args[])
  {
   ArrayList list = new ArrayList();//陣列
   final int NUMBER_OF_PRIMES_PER_LINE = 8;//一行的個數
   int count = 0;//目前第幾個數
   int number = 3; //從3開始

   list.add(2);//先輸入第一個質數

   //顯示1000個質數   
   System.out.println("The print numbers less than 700000 are \n");
   
   while (number < 700000)
    {
     boolean isPrime = true;
     
     for(int i = 0;i <= (list.size()- 1);i++)             //從list中抽出數做比較
      {
       int divisor =((Integer) list.get(i)).intValue();    //將list.get()轉成Integer

       if(number% divisor == 0)
        {
         isPrime = false;                                   //是質數的話 true
         break;
        }
      }
 
     if(isPrime)
      {
       list.add(number);                                    //加入list中
      
       if(count % NUMBER_OF_PRIMES_PER_LINE == 0)
        {
         System.out.println(list.get(count)+" ");
        }
       else
        System.out.print(list.get(count) + " ");
       count++;
      }
     number++;
    }
  }
}