//Computing the greatest common divisor

import java.util.Scanner;

public class EX4_15
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //�ŧi��J
  
   System.out.print("Enter first integer: ");
   int n1 = input.nextInt(); //��J�Ĥ@�Ӽ�
   System.out.print("Enter second integer: ");
   int n2 = input.nextInt(); //��J�ĤG�Ӽ�
   
   int min = 0;

   //��X��Ƥ��p��
   if(n1 > n2)
    {
     min = n2;
    }
   else
    {
     min = n1;
    }

   //�H�j��C�C��p�����P�ɾ㰣���
   while(true)
    {
     if(n2 % min == 0 && n1 % min == 0)
      {
       break;
      }
     min--;
    }

   //��X���G
   System.out.println("The greatest common divisor for "+ n1 + " and "+n2+" is "+min);
  }
}
