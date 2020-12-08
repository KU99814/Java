//The MyDateTime class

public class EX9_1
{
 public static void main(String args[])
  {
   MyDateTime Ctime = new MyDateTime();  //宣告MyDateTime
   MyDateTime Stime = new MyDateTime(555550000); //從1970 1/1開始算的日期

   System.out.print("The current time is ");
   System.out.println(Ctime.getYear()+"Y "+Ctime.getMonth()+"M "+Ctime.getDay()+"D "+
                      Ctime.getHour()+"H "+Ctime.getMin()+"M "+Ctime.getSec()+"S"); //現在

   System.out.print("The specified time is ");
   System.out.println(Stime.getYear()+"Y "+Stime.getMonth()+"M "+Stime.getDay()+"D "+
                      Stime.getHour()+"H "+Stime.getMin()+"M "+Stime.getSec()+"S");

   Stime.setYear(1);//設定年
   Stime.setMonth(2);//設定月
   Stime.setDay(3);//設定日期
   Stime.setHour(4); //設定小時
   Stime.setMin(5); //設定分
   Stime.setSec(6); //設定秒

   System.out.print("The new set time is ");
   System.out.println(Stime.getYear()+"Y "+Stime.getMonth()+"M "+Stime.getDay()+"D "+
                      Stime.getHour()+"H "+Stime.getMin()+"M "+Stime.getSec()+"S");
  }
}

class MyDateTime
{
 private int day; //日
 private int month; //月
 private int year; //年
 private int hour; //小時
 private int minute; //分
 private int second; //秒
 private long millSecond;//毫秒 最初取得的時間
 private long total;//總秒數 將millSecond轉為秒

 //建構子
 //no-arg
 public MyDateTime()
  {
   millSecond = System.currentTimeMillis();
   setTime();
  }

 public MyDateTime(long millSecond)
  {
   this.millSecond = millSecond;
   setTime();
  }

 public MyDateTime(int year,int month,int day,int hour,int minute,int second)
  {
   this.year = year;
   this.month = month;
   this.day = day;
   this.hour = hour;
   this.minute = minute;
   this.second = second;
  } 
   
   
 public void setTime() //求出日期
  {
   total = millSecond/1000;

   //求出秒
   second = (int)(total%60);
   total /= 60;

   //求出分
   minute = (int)(total%60);
   total /= 60;

   //求出時
   hour = (int)(total%24);
   total /=24; //剩下的是日數

   int count = 2; 
   day = (int)(total);
   //求出日期
   while(day > 365)
    {
     if(count%4 == 0 && count != 400)
      day -= 366;
     else
      day -= 365;
     count++;
    }

   int i;//代表月份
   //減去每月天數
   for(i=1;day > 28;i++)
    {
     if(i<8)//8月前奇數是大月
      {
       if(i%2==1)
        day -= 31;
       else if(i%2==0 && i!=2)
        day -= 30;
       else
        {
         if(count%4 == 0 && count != 400)
          day -= 29;
         else
          day -= 28;
        }
      }
     else 
      {
       if(i%2==1)
        day -= 30;
       else if(i%2==0)
        day -= 31;
      }
    }
   total /= 365;
   month = i;
   year = 1970 + (int)(total); //年數
  }

 //以下為回傳變數

 public int getSec()//秒
  {
   return second;
  }

 public int getMin()//分
  {
   return minute;
  }

 public int getHour()//時
  {
   return hour;
  }

 public int getDay()//日期
  {
   return day;
  }

 public int getMonth()//月
  {
   return month;
  }

 public int getYear()//年
  {
   return year;
  }
 
 //以下為設定變數

 public void setSec(int second)//秒
  {
   this.second = second;
  }

 public void setMin(int minute)//分
  {
   this.minute = minute;
  }

 public void setHour(int hour)//時
  {
   this.hour = hour;
  }

 public void setDay(int day)//日
  {
   this.day = day;
  }

 public void setMonth(int month)//月
  {
   this.month = month;
  }

 public void setYear(int year)//年
  {
   this.year = year;
  }
}