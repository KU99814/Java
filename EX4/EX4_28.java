//Diaplay the first days of each month

import java.util.Scanner;

public class EX4_28
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //宣告輸入

   String dayName = "";//星期
   int month = 1; //月份
   int day = 0; //星期 0 是星期天 6 是星期六
   int year = 0; //年分

   System.out.print("Enter the year: ");
   year = input.nextInt(); //輸入年分
   
   System.out.print("Enter the day: ");
   day = input.nextInt();   //輸入該年第一天星期  0是禮拜日
   
   while(month<=12)
    {
     switch(day)
      {
       case 0: dayName = "Sunday";
               break;
       case 1: dayName = "Monday";
               break;
       case 2: dayName = "Tuesday";
               break;
       case 3: dayName = "Wednesday";
               break;
       case 4: dayName = "Thursday";
               break;
       case 5: dayName = "Friday";
               break;
       case 6: dayName = "Saturday";
               break;
      }

     //依照月份決定這個月有幾天 並決定下一個月星期幾
     if((month % 2 != 0 && month<8) || (month%2 == 0 && month>=8))
      {
       if(month == 1)
        System.out.println("January 1, "+year+" is "+dayName);
       else if(month == 3)
        System.out.println("March 1, "+year+" is "+dayName);
       else if(month == 5)
        System.out.println("May 1, "+year+" is "+dayName);
       else if(month == 7)
        System.out.println("July 1, "+year+" is "+dayName);
       else if(month == 8)
        System.out.println("August 1, "+year+" is "+dayName);
       else if(month == 10)
        System.out.println("October 1, "+year+" is "+dayName);
       else if(month == 12)
        System.out.println("December 1, "+year+" is "+dayName);
       
       day+=31;
      }
     else if((month % 2 == 0 && month<8 && month !=2) || (month % 2 !=0 && month>8))
      {
       if(month == 4)
        System.out.println("April 1, "+year+" is "+dayName);
       else if(month == 6)
        System.out.println("June 1, "+year+" is "+dayName);
       else if(month == 9)
        System.out.println("September 1, "+year+" is "+dayName);
       else if(month == 11)
        System.out.println("November 1, "+year+" is "+dayName);

       day+=30;
      }
     else if(month == 2) //2月要考慮是否閏年
      {
       System.out.println("February 1, "+year+" is "+dayName);

       if((year % 4 == 0 && year % 100 !=0) || (year % 400 == 0)) 
        day+=29;
       else
        day+=28;
      }
     day%=7;
     month++;
    }
  }
}