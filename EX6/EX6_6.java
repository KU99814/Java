//以陣列方式儲存質數

public class EX6_6
{
 public static void main(String args[])
  {
   int[] prime = new int[50]; //存放質數的陣列
   int index = 0;//目前質數個數

   int number = 2;//第一個數
   while(true) //找出質數
    {
     if(isPrime(number,index,prime))//若是質數 加入陣列
      {
       prime[index] = number;
       index++;
      }
    
     if(index>=50)//第50個跳出
      break;
     number++;
    }

   System.out.println("The first prime number is "); //顯示
   for(int i=0;i<50;i++)
    {
     if(i%10==0 && i!=0)
      System.out.println();  
     System.out.print(prime[i]+" ");    
    }
  }

 //檢查是否質數
 public static boolean isPrime(int n,int index, int[] prime)
  {
   if(n==1)//若是1則否
    return false;

   int sqrt = (int)(Math.sqrt(n));//被比較數開根號

   for(int i=0;i<index;i++)
    {
     if(n%prime[i]==0)//若被整除即否
      return false;
     
     if(prime[i]>sqrt)//若檢查數大於開根號數則跳出
      break;
    }

   return true;
  }
}