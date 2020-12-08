//Displaying a message where clicked

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class EX15_10 extends JFrame
{
 public EX15_10()
  {
   add(new MouseAction());//�ŧi�å[�Jpanel
  }

 public static void main(String args[])
  {
   EX15_10 frame = new EX15_10();//�ŧi����
   frame.setTitle("EX15_10");//���D
   frame.setSize(400,200);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }

 class MouseAction extends JPanel
  {
   //��r��ܮy��
   int x = 100;
   int y = 100;

   //�غc�l
   public MouseAction()
    {
     //�[�J�ƹ��ƥ�
     addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
       //���o�ƹ��y��
       x = e.getX();
       y = e.getY();

       repaint();//��ø
      }
     });
    }

   //ø��
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);
     
     //��߮y��
     int xCenter = getWidth()/2;
     int yCenter = getHeight()/2;
     
     //ø�X��
     g.setColor(Color.red);
     g.fillOval(xCenter-50,yCenter-50,100,100);
     
     //��߻P�ƹ��y�Ъ��Z��
     int distance = (int)(Math.sqrt(Math.pow(xCenter-x,2) + Math.pow(yCenter-y,2)));

     //ø�X��r ��ܷƹ��I���a�O�_�b���
     g.setColor(Color.black);
     if(distance<=50)
      g.drawString("You have clicked inside the circle",x,y);
     else
      g.drawString("You don't have clicked inside the circle",x,y);    
    }
  }
}