import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.GregorianCalendar;
import java.text.*;

public class Clock extends JPanel
{
 private int dateStyle = DateFormat.MEDIUM;		//日期形式
 private Color digitalDateTimeColor = Color.black;	//時間文字顏色
 private String header = "America";				//標頭 表示國家
 private Color headColor = Color.black;			//標頭顏色
 private boolean running = true;				//時鐘是否正在運行
 private boolean showingHeader = true;			//標頭是否顯示
 private int timeStyle = DateFormat.LONG;			//時間形式
 private String timeZoneID = "EST";				//時區ID
 private TimeZone tz;						//時區
 public boolean usingTimeZoneID = true;			//是否使用時區ID設定

 private StillClock clock = new StillClock();		//時鐘面板
 private Timer timer = new Timer(1000,new TimerListener());
 private JLabel jlbHeader = new JLabel(header,JLabel.CENTER);
 private JLabel jlbDigitTime = new JLabel("",JLabel.CENTER);
 

 public Clock()
  {
   tz = TimeZone.getTimeZone(timeZoneID);
   jlbHeader.setForeground(headColor);
   jlbDigitTime.setForeground(digitalDateTimeColor);
   setLayout(new BorderLayout(1,1));
   add(jlbHeader,BorderLayout.NORTH);
   add(clock,BorderLayout.CENTER);
   add(jlbDigitTime,BorderLayout.SOUTH);
   start();
  }

 public Clock(String timeZoneID)
  {
   this();
   this.timeZoneID = timeZoneID;
   tz = TimeZone.getTimeZone(timeZoneID);
  }

 //計時器
 private class TimerListener implements ActionListener
  {
   public void actionPerformed(ActionEvent e)
    {

     Calendar calendar = new GregorianCalendar();
     if(usingTimeZoneID)
      {
       calendar = new GregorianCalendar(tz);
      }
     
     clock.setHour(calendar.get(Calendar.HOUR));
     clock.setMinute(calendar.get(Calendar.MINUTE));
     clock.setSecond(calendar.get(Calendar.SECOND));

     DateFormat formatter = DateFormat.getDateTimeInstance(dateStyle,timeStyle);
     formatter.setTimeZone(tz);
     jlbDigitTime.setText(formatter.format(calendar.getTime()));
    }
  }

 //啟動
 public void start()
  {
   timer.start();
   running = true;
  }

 //停止
 public void stop()
  {
   timer.stop();
   running = false;
  }

 //回傳時間文字形式
 public int getDateStyle()
  {
   return dateStyle;
  }
 
 //設定時間文字形式
 public void setDateStyle(int dateStyle)
  {
   this.dateStyle = dateStyle;
  }

 //回傳時間文字顏色
 public Color getDigitalDateTimeColor()
  {
   return digitalDateTimeColor;
  }

 //設定時間文字顏色
 public void setDigitalDateTimeColor(Color digitalDateTimeColor)
  {
   this.digitalDateTimeColor = digitalDateTimeColor;
   jlbDigitTime.setForeground(digitalDateTimeColor);
  }

 //回傳標頭
 public String getHeader()
  {
   return header;
  }

 //設定標頭
 public void setHeader(String header)
  {
   this.header = header;
   jlbHeader.setText(header);
  }

 //回傳標頭顏色
 public Color getHeadColor()
  {
   return headColor;
  }

 //設定標頭顏色
 public void setHeadColor(Color headColor)
  {
   this.headColor = headColor;
   jlbHeader.setForeground(headColor);
  }

 //取得時針顏色
 public Color getHourHandColor()
  {
   return clock.getHourHandColor();
  }

 //設定時針顏色
 public void setHourHandColor(Color hourHandColor)
  {
   clock.setHourHandColor(hourHandColor);
  }

 //取得分針顏色
 public Color getMinuteHandColor()
  {
   return clock.getMinuteHandColor();
  }

 //設定分針顏色
 public void setMinuteHandColor(Color minuteHandColor)
  {
   clock.setMinuteHandColor(minuteHandColor);
  }

 //取得秒針顏色
 public Color getSecondHandColor()
  {
   return clock.getSecondHandColor();
  }

 //設定秒針顏色
 public void setSecondHandColor(Color secondHandColor)
  {
   clock.setSecondHandColor(secondHandColor);
  }

 //回傳運行狀態
 public boolean getRunning()
  {
   return running;
  }

 //回傳是否顯示標頭
 public boolean getShowingHeader()
  {
   return showingHeader;
  }

 //設定是否顯示標頭
 public void setShowingHeader(boolean showingHeader)
  {
   this.showingHeader = showingHeader;
   jlbHeader.setVisible(showingHeader);
  }

 //回傳時間文字格式
 public int getTimeStyle()
  {
   return timeStyle;
  }

 ////設定時間文字格式
 public void setTimeStyle(int timeStyle)
  {
   this.timeStyle = timeStyle;
  }

 public String getTimeZoneID()
  {
   return timeZoneID;
  }

 public void setTimeZoneID(String timeZoneID)
  {
   this.timeZoneID = timeZoneID;
   tz = TimeZone.getTimeZone(timeZoneID);
  }

 //回傳時差
 public int getTimeZoneOffset()
  {
   return tz.getRawOffset()/1000/60/60;
  }

 //回傳時區
 public TimeZone getTZ()
  {
   return tz;
  }

 //設定時區
 public void setTZ(TimeZone tz)
  {
   this.tz = tz;
   timeZoneID = tz.getID();
  }

 //回傳是否使用時區ID
 public boolean getUsingTimeZoneID()
  {
   return usingTimeZoneID;
  }

 //設定是否使用時區ID
 public void setUsingTimeZoneID(boolean usingTimeZoneID)
  {
   this.usingTimeZoneID = usingTimeZoneID;
  }
}