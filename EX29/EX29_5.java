//Creating a running fans with thread

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.*;

public class EX29_5 extends JFrame
{
 private JButton jbStart = new JButton("Start");//開始按鈕
 private JButton jbStop = new JButton("Stop");//停止按鈕
 private JButton jbReverse = new JButton("Reverse");//反轉按鈕
 private JScrollBar v = new JScrollBar(JScrollBar.HORIZONTAL,0,0,0,100);//速度條

 Fans fan = new Fans();//風扇物件

 int speed = 10;//轉動速度

 Thread thread;//風扇轉動執行緒 

 public EX29_5()
  {
   JPanel p1 = new JPanel(new GridLayout(1,3));//按鈕panel

   //p1加入按鈕
   p1.add(jbStart);
   p1.add(jbStop);
   p1.add(jbReverse);

   //將panel與速度條加入frame
   add(p1,BorderLayout.NORTH);
   add(fan,BorderLayout.CENTER);
   add(v,BorderLayout.SOUTH);

   //start按鈕事件
   jbStart.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     thread = new Thread(new FanAnimator());//創建執行緒
     thread.start();//執行
    }
   });

   //stop按鈕事件
   jbStop.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     //判斷執行續是否存在且存活
     if(thread!=null && thread.isAlive())
      thread.interrupt();//若是 中斷他
    }
   });

   //反轉按鈕事件
   jbReverse.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
     fan.Reverse();//讓旋轉轉向
    }
   });

   //速度條事件
   v.addAdjustmentListener(new AdjustmentListener(){
    public void adjustmentValueChanged(AdjustmentEvent e){
     int value = (int)(v.getValue());//取得目前數值
     speed=10 + value;//改變速度
    }
   });
  }

 //轉動風扇task
 class FanAnimator implements Runnable
  {
   //執行
   public void run()
    {
     try{
      while(true){
       fan.repaint();//重繪
       Thread.sleep(120-speed);//休眠時間 速度越大時間越短
      }    
     }
     catch(InterruptedException ex){}
    }
  }

 public static void main(String args[])
  {
   SwingUtilities.invokeLater(new Runnable(){
    public void run(){
     EX29_5 frame = new EX29_5();//創建frame
     frame.setTitle("EX29_5");//標題
     frame.setSize(400,400);//視窗大小
     frame.setLocationRelativeTo(null);//相對位置
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
     frame.setVisible(true);//顯示
    }
   });
  }
}

//風扇class
class Fans extends JPanel
{
 private int angle = 0;//繪圖用角度
 private int change = 10;//風扇角度位移

 //將轉動方向變相反
 public void Reverse()
  {
   change*=-1;
  }

 //繪圖
 protected void paintComponent(Graphics g)
  {
   super.paintComponent(g);
   
   //圓心座標x y
   int x = getWidth()/2;
   int y = getHeight()/2;

   //半徑
   int radius = (int)(Math.min(x*2,y*2)*0.4);

   //將x y 減去半徑就是繪圖起始點
   x-=radius;
   y-=radius;

   //繪出圓形外框
   g.drawOval(x-10,y-10,radius*2+20,radius*2+20);

   //繪出四片扇葉
   g.fillArc(x,y,2*radius,2*radius,angle,30);
   g.fillArc(x,y,2*radius,2*radius,angle+90,30);
   g.fillArc(x,y,2*radius,2*radius,angle+180,30);
   g.fillArc(x,y,2*radius,2*radius,angle+270,30);

   angle+=change;//角度加轉速 表現出轉動
  }
}
   