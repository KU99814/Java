//�ؤ���󤬴�

import java.util.Scanner;

public class EX5_8
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J

   double C;//���ū�
   double F;//�ؤ�ū�

   //�C��
   System.out.println("Celsius\tFahrenheit\t Fahrenheit\t Celsius");

   //�ΰj��̧ǿ�X�ഫ���G
   for(C = 40,F =120;C >= 31; C--,F -= 10)
    {
     System.out.println(C+" \t "+(double)((int)(celsiusToFahrenheit(C)*100))/100+"\t\t "+F+
                      " \t\t "+(double)((int)(fahrenheitToCelsius(F)*100))/100);//���
    }
  }

 //�����ؤ�method
 public static double celsiusToFahrenheit(double c)
  {
   double f = (9.0/5)*c+32; //�⦡(��󴫵ؤ�)
   
   return f;
  }
 
 //�ؤ������method
 public static double fahrenheitToCelsius(double f)
  {
   double c = (f-32)*(5/9.0);//�ؤ������
   
   return c;
  }
}