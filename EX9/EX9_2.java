//The BMI class

import java.util.Scanner;

public class EX9_2
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J

   //��J�򥻸��
   System.out.print("Enter your name: ");
   String name = input.nextLine();//�m�W

   System.out.print("Enter your age: ");
   int age = input.nextInt();//�~��

   System.out.print("Enter your weight: ");
   double weight = input.nextDouble();//�魫

   System.out.print("Enter your height: ");
   double height = input.nextDouble();//����

   //��J�ĤG�H���
   System.out.print("Enter your name: ");
   String name2 = input.next();

   System.out.print("Enter your age: ");
   int age2 = input.nextInt();

   System.out.print("Enter your weight: ");
   double weight2 = input.nextDouble();

   System.out.print("Enter your feet: ");
   int feet = input.nextInt();

   System.out.print("Enter your inches: ");
   int inch = input.nextInt();

   //�פJ�򥻸��
   BMI bmi1 = new BMI(name,age,weight,height);
   BMI bmi2 = new BMI(name2,age2,weight2,feet,inch); 

   //���BMI
   System.out.println(bmi1.getName()+"'s BMI is "+bmi1.getBMI());
   System.out.print(bmi2.getName()+"'s BMI is "+bmi2.getBMI());
  }
}

//BMI
class BMI
{
 private String name;//�m�W
 private int age; //�~��
 private double weight;//�魫
 private double height;//����
 public final double KILOGRAMS_PER_POUND = 0.45359237; //�S�ऽ�筼��
 public final double METER_PER_INCH = 0.0254;//�T�ऽ�ح���

 //�غc�l
 public BMI(String name,int age,double weight,double height)
  {
   this.name = name;
   this.age = age;
   this.weight = weight;
   this.height = height;
  }

 public BMI(String name,double weight,double height)
  {
   this(name,20,weight,height);
  }

 public BMI(String name,int age,double weight,int feet,int inches)
  {
   this.name = name;
   this.age = age;
   this.weight = weight;
   height = (double)(feet*12 + inches);
  }

 public double getBMI() //�DBMI
  {
   double bmi = weight * KILOGRAMS_PER_POUND / 
                ((height * METER_PER_INCH) * (height * METER_PER_INCH));
   return Math.round(bmi * 100) / 100.0;
  }

 //�̷Ӻ�X��BMI�������骬�p
 public String getStatus()
  {
   double bmi = getBMI();
   if(bmi < 16)
    return "seriously underweight";
   else if(bmi < 18)
    return "underweight";
   else if(bmi < 24)
    return "normal weight";
   else if(bmi < 29)
    return "overweight";
   else if(bmi < 35)
    return "seriously overweight";
   else
    return "gravely overweight";
  }

 //���ofield
 public String getName()//�m�W
  {
   return name;
  }

 public int getAge()//�~��
  {
   return age;
  }

 public double getWeight()//�魫
  {
   return weight;
  }

 public double getHeight()//����
  {
   return height;
  }
}