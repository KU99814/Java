//�ؤ���󤬴� ��ܨ�p���I����

import java.util.*;
import java.text.*;

public class EX31_8
{
 public static void main(String args[])
  {
   double C;//���ū�
   double F;//�ؤ�ū�

   DecimalFormat df = new DecimalFormat("###.00");//�Ʀr�榡

   //�C��
   System.out.println("Celsius\tFahrenheit\t Fahrenheit\t Celsius");

   //�ΰj��̧ǿ�X�ഫ���G
   for(C = 40,F =120;C >= 31; C--,F -= 10)
    {
     System.out.println(C+" \t "+df.format(celsiusToFahrenheit(C))+"\t\t "+F+
                      " \t\t "+df.format(fahrenheitToCelsius(F)));//���
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