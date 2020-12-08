//summation prove result is 24

public class EX4_35
{
 public static void main(String args[])
  {
   double sum = 0;

   // 1/(1+根號2)+1/(根號2+根號3)+...+1/(根號624+根號625)
   for(int i = 1;i<=624;i++)
    {
     double divisor = Math.sqrt(i)+Math.sqrt(i+1);
     sum += 1/divisor;
    }
   System.out.printf("%.0f",sum);
  }
}