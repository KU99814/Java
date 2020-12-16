//Execution time for prime numbers

public class EX23_6
{
 public static void main(String args[])
  {
   //顯示花費時間
   //23.4
   System.out.println("               8000000         10000000          12000000           14000000");
   System.out.println("Listing23.4      "+Listing23_4(8000000)+"            "+Listing23_4(10000000)+
                      "             "+Listing23_4(12000000)+"              "+Listing23_4(14000000));
   System.out.println("               16000000        18000000");
   System.out.println("                  "+Listing23_4(16000000)+"           "+Listing23_4(18000000));

   //23.5
   System.out.println("               8000000         10000000          12000000           14000000");   
   System.out.println("Listing23.5       "+Listing23_5(8000000)+"             "+Listing23_5(10000000)+
                      "              "+Listing23_5(12000000)+"               "+Listing23_5(14000000));
   System.out.println("               16000000        18000000");
   System.out.println("                   "+Listing23_5(16000000)+"            "+Listing23_5(18000000));

   //23.6
   System.out.println("               8000000         10000000          12000000           14000000"); 
   System.out.println("Listing23.6         "+Listing23_6(8000000)+"               "+Listing23_6(10000000)+
                      "               "+Listing23_6(12000000)+"                "+Listing23_6(14000000));
   System.out.println("               16000000        18000000");
   System.out.println("                    "+Listing23_6(16000000)+"             "+Listing23_6(18000000));    
  }

 //第一種方法
 public static long Listing23_4(int n)
  {
   long t0,t1;
   t0 = System.currentTimeMillis();//開始計時
   
   int count = 0;//質數數量
   int number = 2;//第一數

   //迴圈直到到達目標數
   while(number <= n)
    {
     boolean isPrime = true;
     
     //以相除找質數
     //除數最大到目前數的根號
     for(int divisor = 2;divisor <= (int)(Math.sqrt(number));divisor++)
      {
       if(number%divisor == 0)
        {
         isPrime = false;
         break;
        }
      }

     if(isPrime)
      count++;
     number++;
    }

   t1 = System.currentTimeMillis();//停止計時
   
   return (t1-t0);//回傳時間
  }
   
 //第二種方法    
 public static long Listing23_5(int n)
  {
   long t0,t1;
   t0 = System.currentTimeMillis();//計時開始

   java.util.List<Integer> list = new java.util.ArrayList<Integer>();//儲存質數list

   int count = 0;
   int number = 2;
   int squareRoot = 1;//根號

   while(number <= n)
    {
     boolean isPrime = true;//判斷質數

     if(squareRoot*squareRoot < number)
      squareRoot++;

     //迴圈 若list內的數小於squareRoot 判斷是否除數
     for(int k = 0;k < list.size() && list.get(k) <= squareRoot;k++)
      {
       if(number % list.get(k) == 0)
        {
         isPrime = false;
         break;
        }
      }

     if(isPrime)
      {
       count++;
       list.add(number);//若是質數 加入list
      }

     number++;
    }
   
   
   t1 = System.currentTimeMillis();
   
   return (t1-t0);//回傳時間
  }

 //第三方法
 public static long Listing23_6(int n)
  {
   long t0,t1;
   t0 = System.currentTimeMillis();

   boolean[] primes = new boolean[n+1];//質數篩選

   for(int i=0;i<primes.length;i++)
    primes[i] = true;

   for(int k=2;k<=n/k;k++)
    {
     if(primes[k])
      {
       for(int i=k;i<= n/k;i++)
        primes[k*i] = false;//k*i 不是質數
      }
    }

   int count = 0;//質數數量

   for(int i=2;i<primes.length;i++)
    {
     if(primes[i])
      count++;
    }

   t1 = System.currentTimeMillis();
   
   return (t1-t0);//回傳時間
  }
}
         