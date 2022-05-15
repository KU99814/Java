//時間顯示

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.GregorianCalendar;
import java.text.*;

public class WorldClock extends JPanel
{
 private TimeZone timeZone = TimeZone.getTimeZone("EST");//時區
 private Timer timer = new Timer(1000,new TimerListener());//計時器
 private StillClock clock = new StillClock();//時鐘
 private JLabel jlblDigitTime = new JLabel("",JLabel.CENTER);//顯示時間
 
 public WorldClock()
  {
   setLayout(new BorderLayout());
   add(clock,BorderLayout.CENTER);//加入時鐘
   add(jlblDigitTime,BorderLayout.SOUTH);//顯示時間文字
   timer.start();//開始動作
  }

 //設定時區
 public void setTimeZone(TimeZone timeZone)
  {
   this.timeZone = timeZone;
  }

 //計時繪圖動作
 private class TimerListener implements ActionListener
  {
   public void actionPerformed(ActionEvent e)
    {
     //取得日期與時間
     Calendar calendar = new GregorianCalendar(timeZone,getLocale());
     clock.setHour(calendar.get(Calendar.HOUR));
     clock.setMinute(calendar.get(Calendar.MINUTE));
     clock.setSecond(calendar.get(Calendar.SECOND));

     //按照時區與地區變更顯示格式
     DateFormat formatter = DateFormat.getDateTimeInstance(
      DateFormat.MEDIUM,DateFormat.LONG,getLocale());
     formatter.setTimeZone(timeZone);
     jlblDigitTime.setText(formatter.format(calendar.getTime()));
    }
  }
}