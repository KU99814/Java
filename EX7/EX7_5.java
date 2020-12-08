//use GregorianCalendar

import java.util.*;

public class EX7_5
{
 public static void main(String args[])
  {
   GregorianCalendar GregorianCalendar1 = new GregorianCalendar();
   
   System.out.println("The year is "+GregorianCalendar1.get(GregorianCalendar.YEAR)); //year
   System.out.println("The month is "+(GregorianCalendar1.get(GregorianCalendar.MONTH)+1)); //month
   System.out.println("The day of month is "+GregorianCalendar1.get(GregorianCalendar.DAY_OF_MONTH)); //day

   GregorianCalendar1.setTimeInMillis(1234567898765L); //set the time
   System.out.println("The year is "+GregorianCalendar1.get(GregorianCalendar.YEAR));
   System.out.println("The month is "+(GregorianCalendar1.get(GregorianCalendar.MONTH)+1));
   System.out.println("The day of month is "+GregorianCalendar1.get(GregorianCalendar.DAY_OF_MONTH));
  }
}