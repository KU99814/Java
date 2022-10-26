import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.GregorianCalendar;

public class ClockWithAlarm extends Clock
{
 private String alarmDate;	//����r�� �H,�j�}
 private String alarmTime;	//�ɶ��r�� �H,�j�}
 private Timer alarmTimer = new Timer(1000,new AlarmTimerListener());

 public ClockWithAlarm(String alarmDate,String alarmTime)
  {
   super();
   
   this.alarmDate = alarmDate;
   this.alarmTime = alarmTime;
   alarmTimer.start();
  }

 //�p�ɾ�
 private class AlarmTimerListener implements ActionListener
  {
   public void actionPerformed(ActionEvent e)
    {
     Calendar calendar = new GregorianCalendar();
     if(usingTimeZoneID)
      {
       calendar = new GregorianCalendar(getTZ());
      }

     //���o�ثe�ɶ��P��������
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
       JOptionPane.showMessageDialog(new JFrame(), "�ɶ���");
       alarmTimer.stop();
      }
    }
  }

 //�^�Ǥ���r��
 public String getAlarmDate()
  {
   return alarmDate;
  }

 //�]�w����r��
 public void setAlarmDate()
  {
   this.alarmDate = alarmDate;
  }

 //�^�Ǯɶ��r��
 public String getAlarmTime()
  {
   return alarmTime;
  }

 //�]�w�ɶ��r��
 public void setAlarmTime()
  {
   this.alarmTime = alarmTime;
  }
}