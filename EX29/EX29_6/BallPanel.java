//繪出球的panel

import java.awt.*;
import javax.swing.Timer;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class BallPanel extends JPanel implements Runnable
{
 private ArrayList<Ball> list = new ArrayList<Ball>();//儲存ball物件的list
 private boolean stop = false;//判斷是否暫停

 private int delay = 0;//延遲時間 越大延遲越小
 
 private int now = 0;//目前運動球數

 //constructor
 public BallPanel()
  {
   Ball ball = new Ball();
   
   list.add(ball);
  }

 //執行重繪的task
 public void run()
  {
   try{
    while(true)
     {
      while(stop)
       Thread.sleep(5);
      
      repaint();
      Thread.sleep(110-delay);
     }
   }
   catch(InterruptedException ex){}
  }

 //暫停
 public void suspend()
  {
   stop=true;//暫停判斷變為true
  }

 //重新開始
 public void resume()
  {
   stop=false;//暫停判斷變為false
  }

 //讓球開始動作
 public void start()
  {
   if(list.size()>now)
    {
     Ball ball = (Ball)list.get(now);
     
     if(!ball.isStart())
      {
       ball.start();
       now++;
      }
    }
  }

 //設定延遲時間
 public void setDelay(int delay)
  {
   this.delay = delay;
  }

 //增加球數
 public void addNumber()
  {
   Ball ball = new Ball();
   
   list.add(ball);
  }

 //移除目前最舊的球
 public void subNumber()
  {
   list.remove(0);
   if(now>0)
    now--;
  }
 
 //繪圖
 protected void paintComponent(Graphics g)
  {
   super.paintComponent(g);

   for(int i=0;i<list.size();i++)
    {
     Ball ball = (Ball)list.get(i);
     
     //取出球的各項資料
     int x = ball.getX();
     int y = ball.getY();
     int dx = ball.getDx();
     int dy = ball.getDy();
     int radius = ball.getRadius();
     int c = ball.getColor();
  
     //決定球的顏色
     if(c == 1)
      g.setColor(Color.red);
     else if(c == 2)
      g.setColor(Color.blue);
     else if(c == 3)
      g.setColor(Color.green);
      
     //如果球開始動作 更新座標
     if(ball.isStart())
      {
       //判斷球是否碰壁
       if(x<radius)
        dx =Math.abs(dx);
       if(x>getWidth() - radius )
        dx = -Math.abs(dx);
       if(y<radius)
        dy = Math.abs(dy);
       if(y > getHeight() - radius)
        dy = -Math.abs(dy);

       //變更球內參數
       ball.setX(x+dx);
       ball.setDx(dx);
       ball.setY(y+dy);
       ball.setDy(dy);
      }
     g.fillOval(ball.getX() - radius, ball.getY()- radius,radius*2,radius*2);
    }  
  }
}