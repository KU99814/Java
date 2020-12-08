//Conversion from miles to kilometers

public class EX4_4
{
 public static void main(String args[])
  {
   System.out.print("Miles\t\tKilometers"); //顯示浬與對照公里
   
   for(int i = 1;i<11;i++)
    {
     double kilo = i * 1.609 ; //浬轉換公里
     System.out.print("\n" + i +"\t\t" +kilo);
    }
  }
}