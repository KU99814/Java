//�^����������

import java.util.Scanner;

public class EX5_9
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //�ŧi��J

   System.out.println("Miles\t\tkilometer\t|\tkilometer\t\tMiles");     //���
   
   for(double i=1;i<=10;i++)
    System.out.println(i+"\t\t"+MToK(i)+"\t\t|\t"+(20+5*(i-1))+"\t\t\t"+KToM(20+5*(i-1)));
  }

 public static double MToK(double mile)   //�^��������
  {
   double k = mile/1.609;          //�B��
   k = (int)(k*10000);         //����ĥ|��
   
   k/=10000;
   
   return k;
  }

 public static double KToM(double kilometer)   //�������^��
  {
   double m = kilometer*1.609;
   m = (int)(m*1000);           //����ĤT��
   m/=1000;
   
   return m;
  }
}

   
   
