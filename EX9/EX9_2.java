//The BMI class

import java.util.Scanner;

public class EX9_2
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//宣告輸入

   //輸入基本資料
   System.out.print("Enter your name: ");
   String name = input.nextLine();//姓名

   System.out.print("Enter your age: ");
   int age = input.nextInt();//年齡

   System.out.print("Enter your weight: ");
   double weight = input.nextDouble();//體重

   System.out.print("Enter your height: ");
   double height = input.nextDouble();//身高

   //輸入第二人資料
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

   //匯入基本資料
   BMI bmi1 = new BMI(name,age,weight,height);
   BMI bmi2 = new BMI(name2,age2,weight2,feet,inch); 

   //顯示BMI
   System.out.println(bmi1.getName()+"'s BMI is "+bmi1.getBMI());
   System.out.print(bmi2.getName()+"'s BMI is "+bmi2.getBMI());
  }
}

//BMI
class BMI
{
 private String name;//姓名
 private int age; //年齡
 private double weight;//體重
 private double height;//身高
 public final double KILOGRAMS_PER_POUND = 0.45359237; //磅轉公斤乘數
 public final double METER_PER_INCH = 0.0254;//吋轉公尺乘數

 //建構子
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

 public double getBMI() //求BMI
  {
   double bmi = weight * KILOGRAMS_PER_POUND / 
                ((height * METER_PER_INCH) * (height * METER_PER_INCH));
   return Math.round(bmi * 100) / 100.0;
  }

 //依照算出的BMI分類身體狀況
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

 //取得field
 public String getName()//姓名
  {
   return name;
  }

 public int getAge()//年齡
  {
   return age;
  }

 public double getWeight()//體重
  {
   return weight;
  }

 public double getHeight()//身高
  {
   return height;
  }
}