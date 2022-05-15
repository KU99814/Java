import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.util.*;
import java.text.*;

public class CalendarPanel extends JPanel
{
 private JLabel jlblHeader = new JLabel(" ",JLabel.CENTER);//標頭

 private JLabel[] jlblDay = new JLabel[49];//日期

 //時間變數
 private Calendar calendar;
 private int month;
 private int year;

 private JPanel jpDays = new JPanel(new GridLayout(0,7));//顯示星期

 public CalendarPanel()
  {
   //日期排版
   for(int i=0;i<49;i++)
    {
     jlblDay[i] = new JLabel();
     jlblDay[i].setBorder(new LineBorder(Color.black,1));
     jlblDay[i].setHorizontalAlignment(JLabel.RIGHT);
     jlblDay[i].setVerticalAlignment(JLabel.TOP);
    }

   //加入日歷標頭
   this.setLayout(new BorderLayout());
   this.add(jlblHeader,BorderLayout.NORTH);
   this.add(jpDays,BorderLayout.CENTER);

   //設定時間
   calendar = new GregorianCalendar();
   month = calendar.get(Calendar.MONTH);
   year = calendar.get(Calendar.YEAR);
   updateCalendar();

   showHeader();
   showDays();
  }

 //顯示現在格式的日期
 private void showHeader()
  {
   SimpleDateFormat sdf = new SimpleDateFormat("MMMM yyyy",getLocale());
   String header = sdf.format(calendar.getTime());
   jlblHeader.setText(header);
  }

 //顯示現在格式的星期
 private void showDayNames()
  {
   DateFormatSymbols dfs = new DateFormatSymbols(getLocale());
   String dayNames[] = dfs.getWeekdays();
   
   for(int i = 0;i<7;i++)
    {
     jlblDay[i].setText(dayNames[i+1]);
     jlblDay[i].setHorizontalAlignment(JLabel.CENTER);
     jpDays.add(jlblDay[i]);
    }
  }

 //顯示日期
 public void showDays()
  {
   jpDays.removeAll();
   
   showDayNames();
   
   int startingDayOfMonth = calendar.get(Calendar.DAY_OF_WEEK);//開始的星期
   
   //取得前月最後幾天填滿日歷
   Calendar cloneCalendar = (Calendar)calendar.clone();
   cloneCalendar.add(Calendar.DATE,-1);
   int daysInPrecedingMonth = cloneCalendar.getActualMaximum(
    Calendar.DAY_OF_MONTH);
   
   for(int i=0;i<startingDayOfMonth-1;i++)
    {
     jlblDay[i+7].setForeground(Color.LIGHT_GRAY);
     jlblDay[i+7].setText(daysInPrecedingMonth - startingDayOfMonth + 2 +i+"");
     jpDays.add(jlblDay[i+7]);
    }

   //加入本月日子到日歷
   int daysInCurrentMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
   for(int i=1;i<=daysInCurrentMonth;i++)
    {
     jlblDay[i-2+startingDayOfMonth+7].setForeground(Color.black);
     jlblDay[i-2+startingDayOfMonth+7].setText(i+"");
     jpDays.add(jlblDay[i-2+startingDayOfMonth+7]);
    }
   
   //取得下月日子填滿日歷
   int j=1;
   for(int i=daysInCurrentMonth - 1+startingDayOfMonth+7;i%7 !=0;i++)
    {
     jlblDay[i].setForeground(Color.LIGHT_GRAY);
     jlblDay[i].setText(j++ + "");
     jpDays.add(jlblDay[i]);
    }

   jpDays.repaint();
  }

 //設定新時間
 public void updateCalendar()
  {
   calendar.set(Calendar.YEAR,year);
   calendar.set(Calendar.MONTH,month);
   calendar.set(Calendar.DATE,1);
  }

 //取得月份
 public int getMonth()
  {
   return month;
  }

 //設定月份
 public void setMonth(int newMonth)
  {
   month = newMonth;
   updateCalendar();
   showHeader();
   showDays();
  }

 //取得年分
 public int getYear()
  {
   return year;
  }

 //設定年分
 public void setYear(int newYear)
  {
   year = newYear;
   updateCalendar();
   showHeader();
   showDays();
  }

 //改變地區
 public void changeLocale(Locale newLocale)
  {
   setLocale(newLocale);
   showHeader();
   showDays();
  }
}