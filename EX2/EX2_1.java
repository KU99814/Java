//convent the dollars between us and HK 

import java.util.Scanner;

public class EX2_1
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J
   
   double UsDollar; //����
   double HkDollar; //���

   System.out.print("Enter Us dollars:");
   UsDollar = input.nextDouble(); //��J����
       
   HkDollar = UsDollar*7.7807; //���H����I����
   
   System.out.print("\nThe US dollars convent to Hong Kong dollars are:"+HkDollar); //��X���G

   System.out.print("\nEnter Hong Kong dollars:");
   HkDollar = input.nextDouble(); //��J���

   UsDollar = HkDollar/7.7807; //���H�����I����

   System.out.print("\nThe Hong Kong dollars convent to US dollars are:"+UsDollar); //��X���G
  }
}

   
   