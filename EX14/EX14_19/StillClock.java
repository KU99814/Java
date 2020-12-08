import java.util.*;
import javax.swing.*;
import java.awt.*;

public class StillClock extends JPanel
{
 private int hour;//��
 private int minute; //��
 private int second; //��

 private boolean hourHandVisible;//��ܮ�
 private boolean minuteHandVisible;//��ܤ�
 private boolean secondHandVisible; //��ܬ�

 //�غc�l
 public StillClock()
  {
   setCurrentTime();
  }

 public StillClock(int hour,int minute,int second)
  {
   this.hour = hour;
   this.minute = minute;
   this.second = second;
  }

 //���o��
 public int getHour()
  {
   return hour;
  }

 //�]�w��
 public void setHour(int hour)
  {
   this.hour = hour;
   repaint();
  }

 //���o��
 public int getMinute()
  {
   return minute;
  }

 //�]�w��
 public void setMinute(int minute)
  {
   this.minute = minute;
   repaint();
  }

 //���o��
 public int getSecond()
  {
   return second;
  }

 //�]�w��
 public void setSecond(int second)
  {
   this.second = second;
   repaint();
  }

 //���o�O�_��ܮ�
 public boolean getHourHandVisible()
  {
   return hourHandVisible;
  }
 //�]�w�O�_��ܮ�
 public void setHourHandVisible(boolean hourHandVisible)
  {
   this.hourHandVisible = hourHandVisible;
   repaint();
  }

 //���o�O�_��ܤ�
 public boolean getMinuteHandVisible()
  {
   return minuteHandVisible;
  }

 //�]�w�O�_��ܤ�
 public void setMinuteHandVisible(boolean minuteHandVisible)
  {
   this.minuteHandVisible = minuteHandVisible;
   repaint();
  }

 //���o�O�_��ܬ�
 public boolean getSecondHandVisible()
  {
   return secondHandVisible;
  }

 //�]�w�O�_��ܬ�
 public void setSecondHandVisible(boolean minuteHandVisible)
  {
   this.secondHandVisible = secondHandVisible;
   repaint();
  }

 //ø��
 protected void paintComponent(Graphics g)
  {
   super.paintComponent(g);
   
   //���߮y�лP�b�|
   int clockRadius = (int)(Math.min(getWidth(),getHeight())*0.8*0.5);
   int xCenter = getWidth() / 2;
   int yCenter = getHeight() / 2;
   
   //ø�s����
   g.setColor(Color.black);
   g.drawOval(xCenter - clockRadius,yCenter - clockRadius,2*clockRadius,2*clockRadius);
   g.drawString("12",xCenter-5,yCenter-clockRadius + 12);
   g.drawString("9",xCenter-clockRadius+3,yCenter + 5);
   g.drawString("3",xCenter+clockRadius-10,yCenter+12);
   g.drawString("6",xCenter-3,yCenter+clockRadius-3);

   //ø�s��w
   int sLength = (int)(clockRadius * 0.8);
   int xSecond = (int)(xCenter + sLength*Math.sin(second*(2*Math.PI/60)));
   int ySecond = (int)(yCenter - sLength*Math.cos(second*(2*Math.PI/60)));
   g.setColor(Color.red);

   if(secondHandVisible)//�P�_�O�_��ܬ�w
    g.drawLine(xCenter,yCenter,xSecond,ySecond);
   
   //ø�s���w
   int mLength = (int)(clockRadius * 0.65);
   int xMinute = (int)(xCenter + mLength*Math.sin(minute*(2*Math.PI/60)));
   int yMinute = (int)(yCenter - mLength*Math.cos(minute*(2*Math.PI/60)));
   g.setColor(Color.blue);

   //�P�_�O�_��ܤ��w
   if(minuteHandVisible)
    g.drawLine(xCenter,yCenter,xMinute,yMinute);

   //ø�s�ɰw
   int hLength = (int)(clockRadius * 0.5);
   int xHour = (int)(xCenter + hLength*Math.sin((hour%12+minute/60.0)*(2*Math.PI/12)));
   int yHour = (int)(yCenter - hLength*Math.cos((hour%12+minute/60.0)*(2*Math.PI/12)));
   g.setColor(Color.green);

   //�P�_�O�_��ܮɰw
   if(hourHandVisible)
    g.drawLine(xCenter,yCenter,xHour,yHour);
  }
 
 ///���o�{�b�ɶ�
 public void setCurrentTime()
  {
   Calendar calendar = new GregorianCalendar();
   
   this.hour = calendar.get(Calendar.HOUR_OF_DAY);
   this.minute = calendar.get(Calendar.MINUTE);
   this.second = calendar.get(Calendar.SECOND);
  }

 public Dimension getPreferredSize()
  {
   return new Dimension(200,200);
  }
}