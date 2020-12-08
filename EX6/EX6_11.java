//用陣列來計算平均與標準差

public class EX6_11
{
 public static void main(String args[])
  {
   int[] number = {1,2,3,4,5,6,7,8,9,10}; //設陣列

   System.out.println("The mean is "+mean(number)); //顯示
   System.out.println("The deviation is "+deviation(number));
  }

 public static double deviation(double[] x) //帶入double的deviation
  {
   double d = 0;
   double means = mean(x);

   for(int i=0;i<x.length;i++)
    {
     double d1 = x[i] -means;
     d += Math.pow(d1,2);
    }
   d /= (x.length-1);
   return Math.sqrt(d);
  }

 public static double deviation(int[] x)//帶入int的deviation
  {
   double d = 0;
   double means = mean(x);

   for(int i=0;i<x.length;i++)
    {
     double d1 = x[i] -means;
     d += Math.pow(d1,2);
    }
   d /= (x.length-1);
   return Math.sqrt(d);
  }

 public static double mean(double[] x)//帶入double的mean
  {
   double average = 0;

   for(int i=0;i<x.length;i++)
    {
     average += x[i];
    }
   average/=x.length;
   return average; 
  }

 public static double mean(int[] x)//帶入int的mean
  {
   double average = 0;

   for(int i=0;i<x.length;i++)
    {
     average += x[i];
    }
   average/=x.length;
   return average; 
  }
}