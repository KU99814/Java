//�ΰ}�C�ӭp�⥭���P�зǮt

public class EX6_11
{
 public static void main(String args[])
  {
   int[] number = {1,2,3,4,5,6,7,8,9,10}; //�]�}�C

   System.out.println("The mean is "+mean(number)); //���
   System.out.println("The deviation is "+deviation(number));
  }

 public static double deviation(double[] x) //�a�Jdouble��deviation
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

 public static double deviation(int[] x)//�a�Jint��deviation
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

 public static double mean(double[] x)//�a�Jdouble��mean
  {
   double average = 0;

   for(int i=0;i<x.length;i++)
    {
     average += x[i];
    }
   average/=x.length;
   return average; 
  }

 public static double mean(int[] x)//�a�Jint��mean
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