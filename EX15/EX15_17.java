//Moving a circle using keys

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EX15_17 extends JFrame
{
 public EX15_17()
  {
   add(new MouseMoveCircle());//�ŧi�å[�Jpanel
  }

 public static void main(String args[])
  {
   EX15_17 frame = new EX15_17();//�ŧi����
   frame.setTitle("EX15_17");//���D
   frame.setSize(200,200);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }

 //�ƹ��ʧ@class
 class MouseMoveCircle extends JPanel
  {
   //�ƹ��y��
   int mouseX = 0;
   int mouseY = 0;

   boolean first = true;//�T�{�ƹ��O�_�I�� �קK�~�P

   //��y��
   int circleX = 50;
   int circleY = 50;
   
   //�غc�l
   public MouseMoveCircle()
    {
     //�ƹ��ƥ�

     //�H������s�ƹ��y��
     addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
       mouseX = e.getX();
       mouseY = e.getY();
      }
     });

     addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseDragged(MouseEvent e) {
       if(first)//�Ĥ@���I��
        {
         mouseX = e.getX();
         mouseY = e.getY();
         first = false;
        }
       else
        {
         //�P�_�ƹ��O�_�b�ꤺ
         if(inside(e.getX(),e.getY(),circleX,circleY))
          {
           //�ƹ����ʶZ��
           int distX = e.getX() - mouseX;
           int distY = e.getY() - mouseY;
           
           //�����۲���
           circleX += distX;
           circleY += distY;

           //��s�ƹ��y��
           mouseX = e.getX();
           mouseY = e.getY();
          }
        }
       repaint();//��ø
      }
     });
    }
   
   //�b�q�O�_�b�ꤺ
   public boolean inside(int x1,int y1,int x2,int y2)
    {
     //�P��߶Z��
     int distance = (int)(Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2)));
      
     //�P�_�O�_�p��b�|
     if(distance <=10)
      return true;
     else 
      return false;
    }

   //ø��
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);
     
     //ø��
     g.drawOval(circleX-5,circleY-5,10,10);
    }
  }
}