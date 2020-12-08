//µØ¤óÄá¤ó¤¬´«

import java.util.Scanner;

public class EX5_8
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//«Å§i¿é¤J

   double C;//Äá¤ó·Å«×
   double F;//µØ¤ó·Å«×

   //¦Cªí
   System.out.println("Celsius\tFahrenheit\t Fahrenheit\t Celsius");

   //¥Î°j°é¨Ì§Ç¿é¥XÂà´«µ²ªG
   for(C = 40,F =120;C >= 31; C--,F -= 10)
    {
     System.out.println(C+" \t "+(double)((int)(celsiusToFahrenheit(C)*100))/100+"\t\t "+F+
                      " \t\t "+(double)((int)(fahrenheitToCelsius(F)*100))/100);//Åã¥Ü
    }
  }

 //Äá¤óÂàµØ¤óªºmethod
 public static double celsiusToFahrenheit(double c)
  {
   double f = (9.0/5)*c+32; //ºâ¦¡(Äá¤ó´«µØ¤ó)
   
   return f;
  }
 
 //µØ¤óÂàÄá¤óªºmethod
 public static double fahrenheitToCelsius(double f)
  {
   double c = (f-32)*(5/9.0);//µØ¤óÂàÄá¤ó
   
   return c;
  }
}