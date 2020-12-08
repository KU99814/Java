import java.util.*;

public class EX11_10
{
 public static void main(String args[])
  {
   //宣告日曆
   Calendar calendar = new GregorianCalendar();
 
   int year = calendar.get(Calendar.YEAR); //取得年
   int month = calendar.get(Calendar.MONTH); //取得月
   Calendar calendar2 = new GregorianCalendar(year,month,1); //宣告新日曆

   //顯示
   System.out.println("     MONTH "+(calendar.get(Calendar.MONTH)+1));
   System.out.println("-----------------------------------------");
   System.out.println("SUN   MON   TUS   WED   THU   FRI   SAT");

   int first = calendar2.get(Calendar.DAY_OF_WEEK);//月初第一天的星期
   int maxDay = calendar.getActualMaximum(Calendar.DATE); //這月有幾天
   int count = 0; //換行計數
   
   //第一行的空白
   for(int i= first;i>1;i--)
    {
     System.out.print("   ");
     System.out.print("   ");
     count++;
    }

   //顯示日期
   for(int i=1;i<=maxDay;i++)
    {
     if(count%7==0 && count!=0)//斷行
      System.out.println();
     System.out.print(" "+i);
     if(i<10)
      System.out.print("    ");
     else 
      System.out.print("   ");
     count++;
    }
  }
}