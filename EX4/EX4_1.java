//Conversion from inches to centimeters

public class EX4_1
{
 public static void main(String args[])
  {
   System.out.print("inches\t\tcentimeters");
 
   //�H�j��̧���ܭ^�T���ഫ������  
   for(int i = 1;i<200;i+=2)//��ܩ_��
    {
     double centimeter = i * 2.54 ;
     System.out.printf("\n%d\t\t%10.2f",i,centimeter);
    }
  }
}