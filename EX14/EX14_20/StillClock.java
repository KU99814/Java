import java.util.*;
import javax.swing.*;
import java.awt.*;

public class StillClock extends JPanel
{
 private int hour;//時
 private int minute;//分
 private int second;//秒

 //建構子
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

 //取得時
 public int getHour()
  {
   return hour;
  }

 //設定時
 public void setHour(int hour)
  {
   this.hour = hour;
   repaint();
  }

 //取得分
 public int getMinute()
  {
   return minute;
  }

 //設定分
 public void setMinute(int minute)
  {
   this.minute = minute;
   repaint();
  }

 //取得秒
 public int getSecond()
  {
   return second;
  }

 //設定秒
 public void setSecond(int second)
  {
   this.second = second;
   repaint();
  }

 //繪圖
 protected void paintComponent(Graphics g)
  {
   super.paintComponent(g);

   //中心座標與半徑   
   int clockRadius = (int)(Math.min(getWidth(),getHeight())*0.8*0.5);
   int xCenter = getWidth() / 2;
   int yCenter = getHeight() / 2;
   
   //鐘面
   g.setColor(Color.black);
   g.drawOval(xCenter - clockRadius,yCenter - clockRadius,2*clockRadius,2*clockRadius);

   //時與分的刻度
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
   
   //小時文字
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

   //秒針
   int sLength = (int)(clockRadius * 0.8);
   int xSecond = (int)(xCenter + sLength*Math.sin(second*(2*Math.PI/60)));
   int ySecond = (int)(yCenter - sLength*Math.cos(second*(2*Math.PI/60)));
   g.setColor(Color.red);
   g.drawLine(xCenter,yCenter,xSecond,ySecond);
   
   //分針
   int mLength = (int)(clockRadius * 0.65);
   int xMinute = (int)(xCenter + mLength*Math.sin(minute*(2*Math.PI/60)));
   int yMinute = (int)(yCenter - mLength*Math.cos(minute*(2*Math.PI/60)));
   g.setColor(Color.blue);
   g.drawLine(xCenter,yCenter,xMinute,yMinute);

   //時針
   int hLength = (int)(clockRadius * 0.5);
   int xHour = (int)(xCenter + hLength*Math.sin((hour%12+minute/60.0)*(2*Math.PI/12)));
   int yHour = (int)(yCenter - hLength*Math.cos((hour%12+minute/60.0)*(2*Math.PI/12)));
   g.setColor(Color.green);
   g.drawLine(xCenter,yCenter,xHour,yHour);
  }
 
 //現在時間
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