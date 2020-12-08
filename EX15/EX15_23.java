//Geometry:closest pair of points

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class EX15_23 extends JFrame
{
 public EX15_23()
  {
   add(new ClosestPoint());//�ŧi�å[�Jpanel
  }

 public static void main(String args[])
  {
   EX15_23 frame = new EX15_23();//�ŧi����
   frame.setTitle("EX15_23");//���D
   frame.setSize(500,300);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }

 class ClosestPoint extends JPanel
  {
   ArrayList list = new ArrayList();//�x�s�I�}�C

   public ClosestPoint()
    {
     //�[�J�ƹ��ƥ�
     addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
       MyPoint p = new MyPoint(e.getX(),e.getY()); //�s�W�I
       list.add(p);//�[�J�}�C
       repaint();//��ø
      }
     });
    }

   //ø��
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);

     //���w�]�̵u�Z��
     int minDis = (int)(Math.sqrt(Math.pow(getWidth(),2) + Math.pow(getHeight(),2))); 

     for(int i=0;i<list.size()-1;i++) //�v�Ӥ���U�I�Z��
      {
       MyPoint p1 = (MyPoint)(list.get(i));
       for(int j=i+1;j<list.size();j++)
        {
         MyPoint p2 = (MyPoint)(list.get(j));
         
         if(p1.distance(p2) <minDis) //�p�O�̤p�Z���N���
          {
           minDis = p1.distance(p2);
           for(int k=0;k<list.size()-1;k++)
            {
             MyPoint p = (MyPoint)(list.get(k));
             p.setFill(false);
            }
           p1.setFill(true);
           p2.setFill(true);
          }
        }
      }

     int count = 0;
     //ø�X�I
     for(int i=0;i<list.size();i++)
      {
       MyPoint p = (MyPoint)(list.get(i));

       if(p.getFill()&&count<2)
        {
         g.fillOval(p.getX(),p.getY(),5,5);
         count++;
        }
       else
        g.drawOval(p.getX(),p.getY(),5,5);
      }
    }
  }

 //�Iclass
 class MyPoint
  {
   //�y��
   private int x;
   private int y;

   //�O�_��
   private boolean fill;
   
   //�غc�l
   public MyPoint(int x,int y)
    {
     this.x = x;
     this.y = y;
     fill = false;
    }

   //���o�y��X Y
   public int getX()
    {
     return x;
    }

   public int getY()
    {
     return y;
    }

   //�]�w��
   public void setFill(boolean fill)
    {
     this.fill = fill;
    }

   //�^�ǬO�_��
   public boolean getFill()
    {
     return fill;
    }

   //�p��Z��
   public int distance(MyPoint p)
    {
     return (int)(Math.sqrt(Math.pow((p.getX() - x),2) + Math.pow((p.getY()-y),2)));
    }
  }
}