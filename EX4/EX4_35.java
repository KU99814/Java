//summation prove result is 24

public class EX4_35
{
 public static void main(String args[])
  {
   double sum = 0;

   // 1/(1+�ڸ�2)+1/(�ڸ�2+�ڸ�3)+...+1/(�ڸ�624+�ڸ�625)
   for(int i = 1;i<=624;i++)
    {
     double divisor = Math.sqrt(i)+Math.sqrt(i+1);
     sum += 1/divisor;
    }
   System.out.printf("%.0f",sum);
  }
}