public class MyDate
{
 private int year;//年
 private int month; //月
 private int day; //日

 //建構子
 public MyDate()
  {
   this(0,0,0);
  }

 public MyDate(int year,int month,int day)
  {
   this.year = year;
   this.month = month;
   this.day = day;
  }
}
