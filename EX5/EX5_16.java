//�@�~���Ѽ�

public class EX5_16
{
 public static void main(String args[])
  {
   //�q2001��2010�~
   for(int i = 2000;i<=2010;i++)
    System.out.println(i+"'s number of days are "+numberOfDaysInAYear(i));
  }

 //�^�Ǥ@�~�Ѽƪ�method
 public static int numberOfDaysInAYear(int year)
  {
   //�T�{�O�_�|�~
   if((year %4 == 0 && year % 100 != 0) || (year % 400 == 0))
    return 366;
   else 
    return 365;
  }
}