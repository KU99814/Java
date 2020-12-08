//Displaying calculars

import java.util.Scanner;

public class EX4_29
{
 public static void main(String args[])
  {
   Scanner input = new Scanner(System.in); //宣告輸入

   String monthName = ""; //星期
   int month = 1; //月份
   int day = 0; //日期
   int year = 0; //年分
   int count = 0; //計數換行變數
   int endDay = 31;//當月有幾天

   System.out.print("Enter the year: ");
   year = input.nextInt(); //輸入年分
     
   System.out.print("Enter the day: ");
   day = input.nextInt();   //第一天星期 輸入0~6代表星期天到星期六
   
   while(month <=12)
    {
     System.out.println();
     //輸出月分和年分 依照月份決定日期
     switch(month)
      {
       case 1: System.out.println("\t\tJanuary "+year);
               endDay = 31;
               break;
       case 2: System.out.println("\t\tFebruary "+year);
               if((year % 4 == 0 && year % 100 !=0) || (year % 400 == 0))
                endDay = 29;
               else
                endDay = 28;
               break;
       case 3: System.out.println("\t\tMarch "+year);
               endDay = 31;
               break;
       case 4: System.out.println("\t\tApril "+year);
               endDay = 30;
               break;
       case 5: System.out.println("\t\tMay "+year);
               endDay = 31;
               break;
       case 6: System.out.println("\t\tJune "+year);
               endDay = 30;
               break;
       case 7: System.out.println("\t\tJuly "+year);
               endDay = 31;
               break;
       case 8: System.out.println("\t\tAugust "+year);
               endDay = 31;
               break;
       case 9: System.out.println("\t\tSeptember "+year);
               endDay = 30;
               break;
       case 10: System.out.println("\t\tOctober "+year);
                endDay = 31;
                break;
       case 11: System.out.println("\t\tNovember "+year);
                endDay = 30;
                break;
       case 12 : System.out.println("\t\tDecember "+year);
                 endDay = 31;
                 break;
      }
     
       //輸出日曆
       System.out.println("-------------------------------------------");
       System.out.println("   Sun   Mon   Tue   Wed   Thu   Fri   Sat");

       System.out.print("     ");
       //按照上月換指定天數為止 輸出空格
       for(int i = 1;i<=day;i++)
        {
         System.out.print("      ");
         count++;
        }
       
       //輸出日期
       for(int i = 1;i<=endDay;i++)
        {
         if(i < 9)
          System.out.print(i+"     ");
         else
          System.out.print(i+"    ");

         count++;
         //到星期六後就換行
         if(count % 7==0)
          {
           System.out.println();
           if(i < 10)
            System.out.print("     ");
           else
            System.out.print("    ");
          }
         
         day++;
         if(day == 7)
          day = 0;
        }
     System.out.println();
     month++;
     count = 0;
    }
  }
}    