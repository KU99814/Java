//�p��ƦC

import java.util.Scanner;

public class EX5_14
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //�ŧi��J

   System.out.print("Enter a integer: "); //�ƤJ�ƦC����
   int i = input.nextInt();

   System.out.print("the series's sum is "+m(i));
  }

 //�p��ƦC��method
 public static double m(int i)
  {
   double sum = 0; //�[�`
   int plus = 1; //���t��

   //4(1-1/3+1/5-1/7+1/9-...+1/2i-1-1/2i+1)
   for(double j = 1;j<=2*i+1;j+=2) //�B��
    {
     double add = (1/j);
     add *= plus;//���H���t��
     sum += add;
     plus *= -1;//���t�ഫ
    }
   sum *= 4;
  
   return sum;
  }
}