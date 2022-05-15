import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.util.*;
import java.text.*;

public class CalendarPanel extends JPanel
{
 private JLabel jlblHeader = new JLabel(" ",JLabel.CENTER);//���Y

 private JLabel[] jlblDay = new JLabel[49];//���

 //�ɶ��ܼ�
 private Calendar calendar;
 private int month;
 private int year;

 private JPanel jpDays = new JPanel(new GridLayout(0,7));//��ܬP��

 public CalendarPanel()
  {
   //����ƪ�
   for(int i=0;i<49;i++)
    {
     jlblDay[i] = new JLabel();
     jlblDay[i].setBorder(new LineBorder(Color.black,1));
     jlblDay[i].setHorizontalAlignment(JLabel.RIGHT);
     jlblDay[i].setVerticalAlignment(JLabel.TOP);
    }

   //�[�J������Y
   this.setLayout(new BorderLayout());
   this.add(jlblHeader,BorderLayout.NORTH);
   this.add(jpDays,BorderLayout.CENTER);

   //�]�w�ɶ�
   calendar = new GregorianCalendar();
   month = calendar.get(Calendar.MONTH);
   year = calendar.get(Calendar.YEAR);
   updateCalendar();

   showHeader();
   showDays();
  }

 //��ܲ{�b�榡�����
 private void showHeader()
  {
   SimpleDateFormat sdf = new SimpleDateFormat("MMMM yyyy",getLocale());
   String header = sdf.format(calendar.getTime());
   jlblHeader.setText(header);
  }

 //��ܲ{�b�榡���P��
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

 //��ܤ��
 public void showDays()
  {
   jpDays.removeAll();
   
   showDayNames();
   
   int startingDayOfMonth = calendar.get(Calendar.DAY_OF_WEEK);//�}�l���P��
   
   //���o�e��̫�X�Ѷ񺡤��
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

   //�[�J�����l����
   int daysInCurrentMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
   for(int i=1;i<=daysInCurrentMonth;i++)
    {
     jlblDay[i-2+startingDayOfMonth+7].setForeground(Color.black);
     jlblDay[i-2+startingDayOfMonth+7].setText(i+"");
     jpDays.add(jlblDay[i-2+startingDayOfMonth+7]);
    }
   
   //���o�U���l�񺡤��
   int j=1;
   for(int i=daysInCurrentMonth - 1+startingDayOfMonth+7;i%7 !=0;i++)
    {
     jlblDay[i].setForeground(Color.LIGHT_GRAY);
     jlblDay[i].setText(j++ + "");
     jpDays.add(jlblDay[i]);
    }

   jpDays.repaint();
  }

 //�]�w�s�ɶ�
 public void updateCalendar()
  {
   calendar.set(Calendar.YEAR,year);
   calendar.set(Calendar.MONTH,month);
   calendar.set(Calendar.DATE,1);
  }

 //���o���
 public int getMonth()
  {
   return month;
  }

 //�]�w���
 public void setMonth(int newMonth)
  {
   month = newMonth;
   updateCalendar();
   showHeader();
   showDays();
  }

 //���o�~��
 public int getYear()
  {
   return year;
  }

 //�]�w�~��
 public void setYear(int newYear)
  {
   year = newYear;
   updateCalendar();
   showHeader();
   showDays();
  }

 //���ܦa��
 public void changeLocale(Locale newLocale)
  {
   setLocale(newLocale);
   showHeader();
   showDays();
  }
}