//Game:hitting balloons

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class EX15_25 extends JFrame
{
 double ang = Math.PI/2;//�g������

 public EX15_25()
  {
   HitBalloon p = new HitBalloon();//�ŧipanel
   p.setFocusable(true);//��������ƥ�
   add(p);//�[�J
  }

 public static void main(String args[])
  {
   EX15_25 frame = new EX15_25();//�ŧi����
   frame.setTitle("EX15_25");//���D
   frame.setSize(400,200);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }

 //�g��panel
 class HitBalloon extends JPanel
  {
   boolean newBall = true; //�s����y
   boolean hitBall = false;  //�O�_����
   boolean startBall = false; //�O�_�g�X

   int newBallX = 0;   //��y�y��
   int newBallY = 0;

   int startX = 0;
   int startY = 0;
   int count = 0;  //�p��
   int timeCount = 0; //�ɶ��p�ƾ�

   Timer timer = new Timer(100,new TimerListener());//�p�ɾ�

   public HitBalloon()
    {
     timer.start();//�}�l�ʧ@

     //�[�J��L�ƥ�
     addKeyListener(new KeyAdapter() {
      //�ץ�
      public void keyPressed(KeyEvent e) {

       //�P�_�y�O�_�g�X
       if(!startBall)
        {
         switch(e.getKeyCode())  //�H���k���ܨ��� �W�g�X
          {
           case KeyEvent.VK_LEFT: ang+=(Math.PI/180*5);break;
           case KeyEvent.VK_RIGHT: ang-=(Math.PI/180*5);break;
           case KeyEvent.VK_UP: startBall = true;break;//�g��
          }
         repaint(); //��ø
        }
      }
     });
    }
   
   //�p�ɨƥ�
   class TimerListener implements ActionListener
    {
     public void actionPerformed(ActionEvent e)
      {
       repaint();
      }
    }

   //ø��
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);
     
     int x = getWidth()/2;
     int y = getHeight();

     if(timeCount>=600) //��ɶ�
      {
       timer.stop();
       g.drawString("You get "+count +"grade",x,y/2);
      }
     else
      {
       if(newBall) //�H���@�X��y
        {
         newBallX = (int)(Math.random()*(getWidth()-20));
         newBallY = (int)(Math.random()*(getHeight()-20));
         newBall = false;
        }

       if(!startBall) //�g�X�y��l�y�� 
        {
         startX = (int)(x+3+50*Math.cos(ang));
         startY = (int)(y-3-50*Math.sin(ang));
        }

       if(startBall)//�g�X�y�ʧ@
        {
         g.fillOval(startX,startY,10,10);//ø�y
       
         if(inside(startX,startY,newBallX,newBallY))//�P�_�O�_����(�Q�]�t)
          {
           hitBall = true;
           startBall = false;
           count++;//�[��
          }
         //�p�G��F��t
         if(startX>getWidth() || startY > getHeight() || startX<0 || startY < 0)
          startBall = false;

         //�y��|��V
         startX+=10*Math.cos(ang);
         startY-=10*Math.sin(ang);
        }

       if(!hitBall)
        g.drawOval(newBallX,newBallY,20,20);
       else //����
        {
         //���X�p�y���S��
         g.drawOval(newBallX+10,newBallY-10,5,5);
         g.drawOval(newBallX-10,newBallY+10,5,5);
         g.drawOval(newBallX+10,newBallY+10,5,5);
  
         
         hitBall = false;
         startBall = false;
         newBall = true;
        }
       Polygon p = new Polygon(); //����
   
       //����
       p.addPoint(x-3,y);
       p.addPoint(x+3,y);
   
       //�קK���׶W�L0�M180  
       if(ang<0)
        ang = 0;
       if(ang >Math.PI)
        ang = Math.PI;
     
       //���f
       p.addPoint((int)(x+3+50*Math.cos(ang)),(int)(y-50*Math.sin(ang)));
       p.addPoint((int)(x-3+50*Math.cos(ang)),(int)(y-50*Math.sin(ang)));
       g.fillPolygon(p);
      }
     timeCount++;//�p��
    }

   public boolean inside(int x1,int y1,int x2,int y2) //�O�_����
    {
     x1+=5;
     y1+=5;
     x2+=10;
     y2+=10;
     return (Math.sqrt(Math.pow((x1-x2),2)+Math.pow((y1-y2),2))<15);
    }
  }
}