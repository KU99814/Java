//ø�X�y��panel

import java.awt.*;
import javax.swing.Timer;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class BallPanel extends JPanel implements Runnable
{
 private ArrayList<Ball> list = new ArrayList<Ball>();//�x�sball����list
 private boolean stop = false;//�P�_�O�_�Ȱ�

 private int delay = 0;//����ɶ� �V�j����V�p
 
 private int now = 0;//�ثe�B�ʲy��

 //constructor
 public BallPanel()
  {
   Ball ball = new Ball();
   
   list.add(ball);
  }

 //���歫ø��task
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

 //�Ȱ�
 public void suspend()
  {
   stop=true;//�Ȱ��P�_�ܬ�true
  }

 //���s�}�l
 public void resume()
  {
   stop=false;//�Ȱ��P�_�ܬ�false
  }

 //���y�}�l�ʧ@
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

 //�]�w����ɶ�
 public void setDelay(int delay)
  {
   this.delay = delay;
  }

 //�W�[�y��
 public void addNumber()
  {
   Ball ball = new Ball();
   
   list.add(ball);
  }

 //�����ثe���ª��y
 public void subNumber()
  {
   list.remove(0);
   if(now>0)
    now--;
  }
 
 //ø��
 protected void paintComponent(Graphics g)
  {
   super.paintComponent(g);

   for(int i=0;i<list.size();i++)
    {
     Ball ball = (Ball)list.get(i);
     
     //���X�y���U�����
     int x = ball.getX();
     int y = ball.getY();
     int dx = ball.getDx();
     int dy = ball.getDy();
     int radius = ball.getRadius();
     int c = ball.getColor();
  
     //�M�w�y���C��
     if(c == 1)
      g.setColor(Color.red);
     else if(c == 2)
      g.setColor(Color.blue);
     else if(c == 3)
      g.setColor(Color.green);
      
     //�p�G�y�}�l�ʧ@ ��s�y��
     if(ball.isStart())
      {
       //�P�_�y�O�_�I��
       if(x<radius)
        dx =Math.abs(dx);
       if(x>getWidth() - radius )
        dx = -Math.abs(dx);
       if(y<radius)
        dy = Math.abs(dy);
       if(y > getHeight() - radius)
        dy = -Math.abs(dy);

       //�ܧ�y���Ѽ�
       ball.setX(x+dx);
       ball.setDx(dx);
       ball.setY(y+dy);
       ball.setDy(dy);
      }
     g.fillOval(ball.getX() - radius, ball.getY()- radius,radius*2,radius*2);
    }  
  }
}