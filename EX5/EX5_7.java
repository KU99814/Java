//��J�~���M�����X�Ѽ�

import java.util.Scanner;

public class EX5_7
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in);//�ŧi��J
   
   System.out.print("Enter the month: ");//��J���
   int month = input.nextInt();

   System.out.print("Enter the year: ");//��J�~��
   int year = input.nextInt();

   //��ܸӤ�Ѽ�
   System.out.print("The days of the month are: "+getNumberOfDays(month,year));
  }

 //��ܤѼƪ�method
 public static int getNumberOfDays(int month,int year)
  {
   boolean Leapyear = (year %4 == 0 && year % 100 != 0) || (year % 400 == 0); //�P�_�O�_�|�~

   if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 ||
      month == 10 || month == 12) //�p�G�O1 3 5 7 8 10 12��� �^��31
    return 31;
   else if(month == 2)    //�p�G�O�G�� �P�_�O�_�|�~ �^��28��29
    {
     if(Leapyear)
      return 29;
     else
      return 28;
    }
   else   //��L����^��30
    return 30;
  }
}