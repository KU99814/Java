//Display calendars use dialog box

import javax.swing.JOptionPane;

public class EX7_6
{
 public static void main(String args[])
  {
   String theYear = JOptionPane.showInputDialog("Enter full year(e.g, 2001): "); //��J�~��
   int year = Integer.parseInt(theYear);
   
   String theMonth = JOptionPane.showInputDialog("Enter month in number between 1 and 12: "); // ��J���
   int month = Integer.parseInt(theMonth);

   String output = ""; //��X

   output += printMonthTitle(year,month); //�[�J��� �~�� �P��
   output += printMonthBody(year,month);  //�[�J��l
   
   JOptionPane.showMessageDialog(null,output); //���
  }

 static String printMonthTitle(int year,int month) //�~�� ��� �P��
  {
   String output = "";
   output += "         "+ getMonthName(month)+" "+year+"\n";
   output += "-------------------------------------\n";
   output += " Sun Mon Tue Wed Thu Fri Sat\n";

   return output;
  }

 static String getMonthName(int month) //���
  {
   String monthName = null;
   
   switch (month)
    {
     case 1: monthName = "January"; break;
     case 2: monthName = "February"; break;
     case 3: monthName = "March"; break;
     case 4: monthName = "April"; break;
     case 5: monthName = "May"; break;
     case 6: monthName = "June"; break;
     case 7: monthName = "July"; break;
     case 8: monthName = "August"; break;
     case 9: monthName = "September"; break;
     case 10: monthName = "October"; break;
     case 11: monthName = "November"; break;
     case 12: monthName = "December";
    }

   return monthName;
  }

 static String printMonthBody(int year,int month) //��l
  {
   int startDay = getStartDay(year,month);
   int numberOfDaysInMonth = getNumberOfDaysInMonth(year, month);
   String output = "";
   
   int i = 0;
   for(i=0;i<startDay;i++) //�}�l����l
    {
     if(i == 0)
      output += "       ";
     else
      output += "        ";
    }
 
   for(i=1;i<=numberOfDaysInMonth;i++) //��J��l
    {
     if(i < 10)
      {
       output += "     " + i;
       if(i==9)
        output += " ";
      }
     else
      output += "   " + i;
     
     if((i + startDay)%7==0)
      output += "\n";
    }
   output += "\n";
   return output;
  }

 static int getStartDay(int year,int month) //���D�q�P���X�}�l
  {
   final int START_DAY_JAN_1_1800 = 3;
   
   int totalNumberOfDays = getTotalNumberOfDays(year,month);
   
   return (totalNumberOfDays + START_DAY_JAN_1_1800)%7;
  }

 static int getTotalNumberOfDays(int year,int month) //���D�o�~���X��
  {
   int total = 0;
   
   for(int i=1800;i<year;i++)
    {
     if(isLeapYear(i))
      total = total+366;
     else
      total = total+365;
    }
   
   for(int i=1;i<month;i++)
    total = total + getNumberOfDaysInMonth(year,i);
  
   return total;
  }

 static int getNumberOfDaysInMonth(int year,int month) //���D���X��
  {
   if((month%2==1 && month<=7) || (month%2==0 && month>=8))
    return 31;

   if((month%2==0 && month<8 && month !=2) || (month%2==1 && month>=9))
    return 30;
   if(month==2)
    return isLeapYear(year) ? 29 : 28;

   return 0;
  }

 static boolean isLeapYear(int year) //���D�O�_�|�~
  {
   return year % 400 == 0 || (year%4==0 && year % 100 != 0);
  }
}