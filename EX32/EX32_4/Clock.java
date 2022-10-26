import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.GregorianCalendar;
import java.text.*;

public class Clock extends JPanel
{
 private int dateStyle = DateFormat.MEDIUM;		//����Φ�
 private Color digitalDateTimeColor = Color.black;	//�ɶ���r�C��
 private String header = "America";				//���Y ��ܰ�a
 private Color headColor = Color.black;			//���Y�C��
 private boolean running = true;				//�����O�_���b�B��
 private boolean showingHeader = true;			//���Y�O�_���
 private int timeStyle = DateFormat.LONG;			//�ɶ��Φ�
 private String timeZoneID = "EST";				//�ɰ�ID
 private TimeZone tz;						//�ɰ�
 public boolean usingTimeZoneID = true;			//�O�_�ϥήɰ�ID�]�w

 private StillClock clock = new StillClock();		//�������O
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

 //�p�ɾ�
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

 //�Ұ�
 public void start()
  {
   timer.start();
   running = true;
  }

 //����
 public void stop()
  {
   timer.stop();
   running = false;
  }

 //�^�Ǯɶ���r�Φ�
 public int getDateStyle()
  {
   return dateStyle;
  }
 
 //�]�w�ɶ���r�Φ�
 public void setDateStyle(int dateStyle)
  {
   this.dateStyle = dateStyle;
  }

 //�^�Ǯɶ���r�C��
 public Color getDigitalDateTimeColor()
  {
   return digitalDateTimeColor;
  }

 //�]�w�ɶ���r�C��
 public void setDigitalDateTimeColor(Color digitalDateTimeColor)
  {
   this.digitalDateTimeColor = digitalDateTimeColor;
   jlbDigitTime.setForeground(digitalDateTimeColor);
  }

 //�^�Ǽ��Y
 public String getHeader()
  {
   return header;
  }

 //�]�w���Y
 public void setHeader(String header)
  {
   this.header = header;
   jlbHeader.setText(header);
  }

 //�^�Ǽ��Y�C��
 public Color getHeadColor()
  {
   return headColor;
  }

 //�]�w���Y�C��
 public void setHeadColor(Color headColor)
  {
   this.headColor = headColor;
   jlbHeader.setForeground(headColor);
  }

 //���o�ɰw�C��
 public Color getHourHandColor()
  {
   return clock.getHourHandColor();
  }

 //�]�w�ɰw�C��
 public void setHourHandColor(Color hourHandColor)
  {
   clock.setHourHandColor(hourHandColor);
  }

 //���o���w�C��
 public Color getMinuteHandColor()
  {
   return clock.getMinuteHandColor();
  }

 //�]�w���w�C��
 public void setMinuteHandColor(Color minuteHandColor)
  {
   clock.setMinuteHandColor(minuteHandColor);
  }

 //���o��w�C��
 public Color getSecondHandColor()
  {
   return clock.getSecondHandColor();
  }

 //�]�w��w�C��
 public void setSecondHandColor(Color secondHandColor)
  {
   clock.setSecondHandColor(secondHandColor);
  }

 //�^�ǹB�檬�A
 public boolean getRunning()
  {
   return running;
  }

 //�^�ǬO�_��ܼ��Y
 public boolean getShowingHeader()
  {
   return showingHeader;
  }

 //�]�w�O�_��ܼ��Y
 public void setShowingHeader(boolean showingHeader)
  {
   this.showingHeader = showingHeader;
   jlbHeader.setVisible(showingHeader);
  }

 //�^�Ǯɶ���r�榡
 public int getTimeStyle()
  {
   return timeStyle;
  }

 ////�]�w�ɶ���r�榡
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

 //�^�Ǯɮt
 public int getTimeZoneOffset()
  {
   return tz.getRawOffset()/1000/60/60;
  }

 //�^�Ǯɰ�
 public TimeZone getTZ()
  {
   return tz;
  }

 //�]�w�ɰ�
 public void setTZ(TimeZone tz)
  {
   this.tz = tz;
   timeZoneID = tz.getID();
  }

 //�^�ǬO�_�ϥήɰ�ID
 public boolean getUsingTimeZoneID()
  {
   return usingTimeZoneID;
  }

 //�]�w�O�_�ϥήɰ�ID
 public void setUsingTimeZoneID(boolean usingTimeZoneID)
  {
   this.usingTimeZoneID = usingTimeZoneID;
  }
}