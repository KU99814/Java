//用method計算平均

public class EX6_8
{
 public static void main(String args[])
  {
   int first = average(new int[]{1,2,3,4,5,6}); //第一個int的method
   double second = average(new double[]{6.0,404,1.9,2.9,3.4,3.5});//第二個double的method
   
   System.out.println("The first average is "+first);
   System.out.println("The second average is "+second);
  }

 //int得平均
 public static int average(int[] array)
  {
   int total = 0;//加總

   //相加
   for(int i=0;i<array.length;i++)
    total+=array[i];
   
   //除以個數平均
   total/=array.length;
   return total; //回傳
  }

 //double的平均
 public static double average(double[] array)
  {
   double total = 0; //加總

   //相加
   for(int i=0;i<array.length;i++)
    total+=array[i];
   
   //除以個數平均
   total/=array.length;
   return total; //回傳
  }
}