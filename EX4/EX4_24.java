//Summing a series

public class EX4_24
{
 public static void main(String args[])
  {
   double a = 1;//���l
   double b = 3; //����
   double sum = 0; //�`�M

   //�p�� 1/3+3/5+5/7+7/9+......+97/99
   for(a = 1;a<=97;a+=2)
    {
     sum+=(a/b);
     b+=2;
    }
   System.out.print("The sum is "+sum);
  }
}