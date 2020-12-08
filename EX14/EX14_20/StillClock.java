import java.util.*;
import javax.swing.*;
import java.awt.*;

public class StillClock extends JPanel
{
 private int hour;//��
 private int minute;//��
 private int second;//��

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

 //ø��
 protected void paintComponent(Graphics g)
  {
   super.paintComponent(g);

   //���߮y�лP�b�|   
   int clockRadius = (int)(Math.min(getWidth(),getHeight())*0.8*0.5);
   int xCenter = getWidth() / 2;
   int yCenter = getHeight() / 2;
   
   //����
   g.setColor(Color.black);
   g.drawOval(xCenter - clockRadius,yCenter - clockRadius,2*clockRadius,2*clockRadius);

   //�ɻP�������
   for(int i=0;i<60;i++)
    {
     int x = (int)(xCenter + clockRadius*Math.sin(i*(2*Math.PI/60)));
     int y = (int)(yCenter - clockRadius*Math.cos(i*(2*Math.PI/60)));
     int length = 5;
     if(i%5==0)
      length = 10;
     int x2 = (int)(x - length*Math.sin(i*(2*Math.PI/60)));
     int y2 = (int)(y + length*Math.cos(i*(2*Math.PI/60)));

     g.drawLine(x,y,x2,y2);
    }
   
   //�p�ɤ�r
   for(int i=0;i<60;i+=5)
    {
     int x = (int)(xCenter + clockRadius*Math.sin(i*(2*Math.PI/60)));
     int y = (int)(yCenter - clockRadius*Math.cos(i*(2*Math.PI/60)));
     int x2 = (int)(x - 20*Math.sin(i*(2*Math.PI/60)));
     int y2 = (int)(y + 20*Math.cos(i*(2*Math.PI/60)));
     if(i==0)
      g.drawString("12",x2 ,y2);
     else
      g.drawString((i/5)+"",x2,y2);
    }      

  /* g.drawString("12",xCenter-5,yCenter-clockRadius + 20);
   
   g.drawString("9",xCenter-clockRadius+20,yCenter + 5);
   g.drawString("3",xCenter+clockRadius-15,yCenter+5);
   g.drawString("6",xCenter-3,yCenter+clockRadius-10);*/

   //��w
   int sLength = (int)(clockRadius * 0.8);
   int xSecond = (int)(xCenter + sLength*Math.sin(second*(2*Math.PI/60)));
   int ySecond = (int)(yCenter - sLength*Math.cos(second*(2*Math.PI/60)));
   g.setColor(Color.red);
   g.drawLine(xCenter,yCenter,xSecond,ySecond);
   
   //���w
   int mLength = (int)(clockRadius * 0.65);
   int xMinute = (int)(xCenter + mLength*Math.sin(minute*(2*Math.PI/60)));
   int yMinute = (int)(yCenter - mLength*Math.cos(minute*(2*Math.PI/60)));
   g.setColor(Color.blue);
   g.drawLine(xCenter,yCenter,xMinute,yMinute);

   //�ɰw
   int hLength = (int)(clockRadius * 0.5);
   int xHour = (int)(xCenter + hLength*Math.sin((hour%12+minute/60.0)*(2*Math.PI/12)));
   int yHour = (int)(yCenter - hLength*Math.cos((hour%12+minute/60.0)*(2*Math.PI/12)));
   g.setColor(Color.green);
   g.drawLine(xCenter,yCenter,xHour,yHour);
  }
 
 //�{�b�ɶ�
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