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
 private Timer timer = new Timer(1000,new TimerListener()); //計時器
 private StillClock clock = new StillClock(); //時鐘panel
 private JLabel jlblDigitTime = new JLabel("",JLabel.CENTER);//時間文字
 
 public WorldClock()
  {
   //排版
   setLayout(new BorderLayout());
   add(clock,BorderLayout.CENTER);
   add(jlblDigitTime,BorderLayout.SOUTH);
   timer.start();//開始計時動作
  }

 //改變時區
 public void setTimeZone(TimeZone timeZone)
  {
   this.timeZone = timeZone;
  }

 //計時動作
 private class TimerListener implements ActionListener
  {
   public void actionPerformed(ActionEvent e)
    {
     //取得時間
     Calendar calendar = new GregorianCalendar(timeZone,getLocale());

     //改變時間
     clock.setHour(calendar.get(Calendar.HOUR));
     clock.setMinute(calendar.get(Calendar.MINUTE));
     clock.setSecond(calendar.get(Calendar.SECOND));

     //時間格式
     DateFormat formatter = DateFormat.getDateTimeInstance(
      DateFormat.MEDIUM,DateFormat.LONG,getLocale());
     formatter.setTimeZone(timeZone);//變更時區
     jlblDigitTime.setText(formatter.format(calendar.getTime()));//顯示目前格式的時間
    }
  }
}