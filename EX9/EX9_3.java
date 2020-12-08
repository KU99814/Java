//The MyDouble class

import java.util.Scanner;

public class EX9_3
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J
   
   System.out.print("Enter a double number: ");
   double d1 = input.nextDouble(); //��Jdouble

   MyDouble MD1 = new MyDouble(d1);//�ŧiMyDouble

   System.out.println("the number in integer is: "+MD1.intValue());//��ܬ�int
   System.out.println("the number in integer is: "+MD1.doubleValue());//���double
   //�ର���w�����
   System.out.println("The 5.45 in 16 of specified radix is "+MyDouble.parseDouble("50.45",16));
   //�P�_�O�_�۵�
   System.out.println("Is equal to d1 ? "+MD1.equals(d1));
   System.out.print("Is equal to new MyDouble? "+MD1.equals(new MyDouble()));
  }
}

//�ۧ@double
class MyDouble
{
 private double value;//��

 //�غc�l
 public MyDouble()
  {
   value = 1.0;
  }

 public MyDouble(double value)
  {
   this.value = value;
  }

 //��Xint
 public int intValue()
  {
   return (int)(value);
  }

 //��Xdouble
 public double doubleValue()
  {
   return value;
  }

 //�N��r�ରdouble
 public static double parseDouble(String s,int radix)
  {
   String[] v = s.split("[.]");  //�H�p���I�@�ϧO
   double result = 0; //�^�ǭ�

   //�p���I�H�W
   for(int i=0;i<v[0].length();i++)
    {
     //���X���
     char c = v[0].charAt(i);
     int num = 0;
     if(c>='0' && c <='9')
      num = (int)(c-'0');
     else if(c>='A' && c <= 'Z')
      num = (int)(c-'A')+10;

     result += num*(int)(Math.pow(radix,(v[0].length()-1-i))); //�N���Ʈھڰ��1�ഫ
    }

   //�Y���p���I
   if(v.length>1)
    {
     double temp = 0;
     for(int i=0;i<v[1].length();i++)
      {
       char c = v[1].charAt(i);
       double num = 0;
       if(c>='0' && c <='9')
        num = (int)(c-'0');
       else if(c>='A' && c <= 'Z')
        num = (int)(c-'A')+10;
       temp += num*(Math.pow(radix,(-i-1)));//�p���I���H�t������
      } 
     result += temp;
    }
   
   return result;
  }

 //�P�_�O�_�۵�
 public boolean equals(double d)
  {
   return (value == d);
  }

 public boolean equals(MyDouble d)
  {
   return d.equals(value);
  }
} 