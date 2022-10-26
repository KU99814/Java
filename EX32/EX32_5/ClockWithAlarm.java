import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.GregorianCalendar;

public class ClockWithAlarm extends Clock
{
 private String alarmDate;	//日期字串 以,隔開
 private String alarmTime;	//時間字串 以,隔開
 private Timer alarmTimer = new Timer(1000,new AlarmTimerListener());

 public ClockWithAlarm(String alarmDate,String alarmTime)
  {
   super();
   
   this.alarmDate = alarmDate;
   this.alarmTime = alarmTime;
   alarmTimer.start();
  }

 //計時器
 private class AlarmTimerListener implements ActionListener
  {
   public void actionPerformed(ActionEvent e)
    {
     Calendar calendar = new GregorianCalendar();
     if(usingTimeZoneID)
      {
       calendar = new GregorianCalendar(getTZ());
      }

     //取得目前時間與日期做比較
     String year = String.valueOf(calendar.get(Calendar.YEAR));
     String month = String.valueOf(calendar.get(Calendar.MONTH)+1);
     String date = String.valueOf(calendar.get(Calendar.DATE));
     System.out.println("year:"+year+",month:"+month+",date:"+date);

     String hour = String.valueOf(calendar.get(Calendar.HOUR));
     String minute = String.valueOf(calendar.get(Calendar.MINUTE));
     String second = String.valueOf(calendar.get(Calendar.SECOND));
     System.out.println("hour:"+hour+",minute:"+minute+",second:"+second);
    
     String[] dates = alarmDate.split(",");
     String[] times = alarmTime.split(",");

     if(year.equals(dates[0]) && month.equals(dates[1]) &&date.equals(dates[2]) &&
        hour.equals(times[0]) && minute.equals(times[1]) &&second.equals(times[2]))
      {
       JOptionPane.showMessageDialog(new JFrame(), "時間到");
       alarmTimer.stop();
      }
    }
  }

 //回傳日期字串
 public String getAlarmDate()
  {
   return alarmDate;
  }

 //設定日期字串
 public void setAlarmDate()
  {
   this.alarmDate = alarmDate;
  }

 //回傳時間字串
 public String getAlarmTime()
  {
   return alarmTime;
  }

 //設定時間字串
 public void setAlarmTime()
  {
   this.alarmTime = alarmTime;
  }
}