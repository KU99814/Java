//Game:hitting balloons

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class EX15_25 extends JFrame
{
 double ang = Math.PI/2;//射擊角度

 public EX15_25()
  {
   HitBalloon p = new HitBalloon();//宣告panel
   p.setFocusable(true);//接受按鍵事件
   add(p);//加入
  }

 public static void main(String args[])
  {
   EX15_25 frame = new EX15_25();//宣告視窗
   frame.setTitle("EX15_25");//標題
   frame.setSize(400,200);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }

 //射擊panel
 class HitBalloon extends JPanel
  {
   boolean newBall = true; //新的氣球
   boolean hitBall = false;  //是否擊中
   boolean startBall = false; //是否射出

   int newBallX = 0;   //氣球座標
   int newBallY = 0;

   int startX = 0;
   int startY = 0;
   int count = 0;  //計分
   int timeCount = 0; //時間計數器

   Timer timer = new Timer(100,new TimerListener());//計時器

   public HitBalloon()
    {
     timer.start();//開始動作

     //加入鍵盤事件
     addKeyListener(new KeyAdapter() {
      //案件
      public void keyPressed(KeyEvent e) {

       //判斷球是否射出
       if(!startBall)
        {
         switch(e.getKeyCode())  //以左右改變角度 上射出
          {
           case KeyEvent.VK_LEFT: ang+=(Math.PI/180*5);break;
           case KeyEvent.VK_RIGHT: ang-=(Math.PI/180*5);break;
           case KeyEvent.VK_UP: startBall = true;break;//射擊
          }
         repaint(); //重繪
        }
      }
     });
    }
   
   //計時事件
   class TimerListener implements ActionListener
    {
     public void actionPerformed(ActionEvent e)
      {
       repaint();
      }
    }

   //繪圖
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);
     
     int x = getWidth()/2;
     int y = getHeight();

     if(timeCount>=600) //到時間
      {
       timer.stop();
       g.drawString("You get "+count +"grade",x,y/2);
      }
     else
      {
       if(newBall) //隨機作出氣球
        {
         newBallX = (int)(Math.random()*(getWidth()-20));
         newBallY = (int)(Math.random()*(getHeight()-20));
         newBall = false;
        }

       if(!startBall) //射出球初始座標 
        {
         startX = (int)(x+3+50*Math.cos(ang));
         startY = (int)(y-3-50*Math.sin(ang));
        }

       if(startBall)//射出球動作
        {
         g.fillOval(startX,startY,10,10);//繪球
       
         if(inside(startX,startY,newBallX,newBallY))//判斷是否擊中(被包含)
          {
           hitBall = true;
           startBall = false;
           count++;//加分
          }
         //如果到達邊緣
         if(startX>getWidth() || startY > getHeight() || startX<0 || startY < 0)
          startBall = false;

         //球行徑方向
         startX+=10*Math.cos(ang);
         startY-=10*Math.sin(ang);
        }

       if(!hitBall)
        g.drawOval(newBallX,newBallY,20,20);
       else //擊中
        {
         //分出小球做特效
         g.drawOval(newBallX+10,newBallY-10,5,5);
         g.drawOval(newBallX-10,newBallY+10,5,5);
         g.drawOval(newBallX+10,newBallY+10,5,5);
  
         
         hitBall = false;
         startBall = false;
         newBall = true;
        }
       Polygon p = new Polygon(); //砲管
   
       //底部
       p.addPoint(x-3,y);
       p.addPoint(x+3,y);
   
       //避免角度超過0和180  
       if(ang<0)
        ang = 0;
       if(ang >Math.PI)
        ang = Math.PI;
     
       //炮口
       p.addPoint((int)(x+3+50*Math.cos(ang)),(int)(y-50*Math.sin(ang)));
       p.addPoint((int)(x-3+50*Math.cos(ang)),(int)(y-50*Math.sin(ang)));
       g.fillPolygon(p);
      }
     timeCount++;//計時
    }

   public boolean inside(int x1,int y1,int x2,int y2) //是否擊中
    {
     x1+=5;
     y1+=5;
     x2+=10;
     y2+=10;
     return (Math.sqrt(Math.pow((x1-x2),2)+Math.pow((y1-y2),2))<15);
    }
  }
}