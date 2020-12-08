//顯示正確時間

public class EX5_24
{
 public static void main(String args[])
  {
   long totalMilliseconds = System.currentTimeMillis(); //求出從1970年1/1到現在毫秒數

   long totalSeconds = totalMilliseconds/1000;//轉成總秒數
   long seconds = totalSeconds%60;//求出現在秒數
   
   long totalMinutes = totalSeconds/60;
   long Minutes = totalMinutes%60;//求出現在分鐘

   long totalHours = totalMinutes/60;
   long hours = (totalHours+8)%24;//求出現在小時 +8是基於時差
   
   
   long totalDays = (totalHours+8)/24; //+8是基於時差
   int today = (int)(totalDays) +1;
   
   int totalYear = (int)(totalDays/365);
   int year = totalYear+1970; //求出現在年分

   int month = 1;//初始月份

   //總天數遂年減去 直到剩下今年已過天數
   for(int i = 1970;i<year;i++)
    {
     if(isLeapYear(i))
      today -= 366;
     else
      today -= 365;
    }

   while(true) //求出現在日期
    {
     //月份跟天數吻合即完成
     if((month == 1 || month == 3 || month == 5 || month == 7 ||
         month == 8 || month == 10 || month == 12) && today <= 31)
      break;
     else if((month == 4 || month == 6 || month == 9 || month == 11) && today <= 30)
      break;
     else if(month == 2 )
      {
       if(isLeapYear(year) && today <= 29)
        break;
       else if(!isLeapYear(year) && today <= 28)
        break;
      }

     today -= getNumberOfDaysInMonth(year,month);//今年已過天數 減去月份相應天數
     month++;//月份前進
     
     //防止溢出
     if(month>12)
      {
       month -= 12;
       year++;
      }
    }

   //顯示
   System.out.print("The current time is "+hours+":"+Minutes+":"+seconds+" "+year+"/"+month+"/"+today+" GMT");    
  }

 //檢查是否閏年
 static boolean isLeapYear(int year)
  {
   return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
  }

 //回傳該年份月份的天數
 static int getNumberOfDaysInMonth(int year,int month)
  {
   //大月
   if(month == 1 || month == 3 || month == 5 || month == 7 ||
      month == 8 || month == 10 || month == 12)
    return 31;
   //小月
   if(month == 4 || month == 6 || month == 9 || month == 11)
    return 30;
   //2月
   if(month == 2 )
    return isLeapYear(year) ? 29 : 28;
   return 0;
  }
}