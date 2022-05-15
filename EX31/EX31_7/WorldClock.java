//�ɶ����

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.GregorianCalendar;
import java.text.*;

public class WorldClock extends JPanel
{
 private TimeZone timeZone = TimeZone.getTimeZone("EST");//�ɰ�
 private Timer timer = new Timer(1000,new TimerListener());//�p�ɾ�
 private StillClock clock = new StillClock();//����
 private JLabel jlblDigitTime = new JLabel("",JLabel.CENTER);//��ܮɶ�
 
 public WorldClock()
  {
   setLayout(new BorderLayout());
   add(clock,BorderLayout.CENTER);//�[�J����
   add(jlblDigitTime,BorderLayout.SOUTH);//��ܮɶ���r
   timer.start();//�}�l�ʧ@
  }

 //�]�w�ɰ�
 public void setTimeZone(TimeZone timeZone)
  {
   this.timeZone = timeZone;
  }

 //�p��ø�ϰʧ@
 private class TimerListener implements ActionListener
  {
   public void actionPerformed(ActionEvent e)
    {
     //���o����P�ɶ�
     Calendar calendar = new GregorianCalendar(timeZone,getLocale());
     clock.setHour(calendar.get(Calendar.HOUR));
     clock.setMinute(calendar.get(Calendar.MINUTE));
     clock.setSecond(calendar.get(Calendar.SECOND));

     //���ӮɰϻP�a���ܧ���ܮ榡
     DateFormat formatter = DateFormat.getDateTimeInstance(
      DateFormat.MEDIUM,DateFormat.LONG,getLocale());
     formatter.setTimeZone(timeZone);
     jlblDigitTime.setText(formatter.format(calendar.getTime()));
    }
  }
}