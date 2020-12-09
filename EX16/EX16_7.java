//調整時鐘

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class EX16_7 extends JFrame
{
 JTextField JHour = new JTextField(3);  //輸入時
 JTextField JMinute = new JTextField(3); //輸入分
 JTextField JSecond = new JTextField(3);  //輸入秒
 public StillClock p1 = new StillClock(); //時鐘版面

 public EX16_7()
  {
   JPanel p2 = new JPanel(new FlowLayout());//宣告輸入panel

   //加入component
   p2.add(new JLabel("Hour"));
   p2.add(JHour);
   p2.add(new JLabel("Minute"));
   p2.add(JMinute);
   p2.add(new JLabel("Second"));
   p2.add(JSecond);
   
   //宣告框線並加入panel中
   Border lineBorder = new LineBorder(Color.BLACK,2);   
   p1.setBorder(lineBorder);
   p2.setBorder(lineBorder);

   //調整時
   JHour.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e){
     int hour = Integer.parseInt(JHour.getText());
     p1.setHour(hour);
    }
   });
   
   //調整分
   JMinute.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e){
     int minute = Integer.parseInt(JMinute.getText());
     p1.setMinute(minute);
    }
   });


   //調整秒
   JSecond.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e){
     int second = Integer.parseInt(JSecond.getText());
     p1.setSecond(second);
    }
   });

   setLayout(new BorderLayout());//設定layout

   //加入panel
   add(p1,BorderLayout.CENTER);
   add(p2,BorderLayout.SOUTH);
  }
 public static void main(String args[])
  {
   EX16_7 frame = new EX16_7();//宣告視窗
   frame.setSize(400,200);//大小
   frame.setTitle("EX16_7");//標題
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }

class StillClock extends JPanel
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

   //刻度
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
   
   //鐘面文字
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
 
 //現在時刻
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
}