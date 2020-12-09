//Catalan numbers

import java.util.Scanner;

public class EX20_10
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J

   System.out.print("Enter n: ");
   int n = input.nextInt();//��J�Ʀr
   
   if(n<0)//��J�p��s ���X�ҥ~
    throw new IllegalArgumentException("n is nagetive");
   else
    System.out.print("cn = "+catalan(n-1));//��ܵ��G
  }

 //�p��method
 public static int catalan(int n)
  {
   if(n==0)//base case
    return 1;
   else//���j�p��
    {
     int cn = 0;
     for(int i=0;i<=(n-1);i++)
      {
       cn += catalan(i)*catalan((n-1)-i);
      }
     return cn;
    }
  }
}