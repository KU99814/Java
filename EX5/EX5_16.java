//一年的天數

public class EX5_16
{
 public static void main(String args[])
  {
   //從2001到2010年
   for(int i = 2000;i<=2010;i++)
    System.out.println(i+"'s number of days are "+numberOfDaysInAYear(i));
  }

 //回傳一年天數的method
 public static int numberOfDaysInAYear(int year)
  {
   //確認是否閏年
   if((year %4 == 0 && year % 100 != 0) || (year % 400 == 0))
    return 366;
   else 
    return 365;
  }
}