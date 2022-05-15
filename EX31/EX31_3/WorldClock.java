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
 private Timer timer = new Timer(1000,new TimerListener()); //�p�ɾ�
 private StillClock clock = new StillClock(); //����panel
 private JLabel jlblDigitTime = new JLabel("",JLabel.CENTER);//�ɶ���r
 
 public WorldClock()
  {
   //�ƪ�
   setLayout(new BorderLayout());
   add(clock,BorderLayout.CENTER);
   add(jlblDigitTime,BorderLayout.SOUTH);
   timer.start();//�}�l�p�ɰʧ@
  }

 //���ܮɰ�
 public void setTimeZone(TimeZone timeZone)
  {
   this.timeZone = timeZone;
  }

 //�p�ɰʧ@
 private class TimerListener implements ActionListener
  {
   public void actionPerformed(ActionEvent e)
    {
     //���o�ɶ�
     Calendar calendar = new GregorianCalendar(timeZone,getLocale());

     //���ܮɶ�
     clock.setHour(calendar.get(Calendar.HOUR));
     clock.setMinute(calendar.get(Calendar.MINUTE));
     clock.setSecond(calendar.get(Calendar.SECOND));

     //�ɶ��榡
     DateFormat formatter = DateFormat.getDateTimeInstance(
      DateFormat.MEDIUM,DateFormat.LONG,getLocale());
     formatter.setTimeZone(timeZone);//�ܧ�ɰ�
     jlblDigitTime.setText(formatter.format(calendar.getTime()));//��ܥثe�榡���ɶ�
    }
  }
}