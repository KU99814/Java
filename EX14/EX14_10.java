//Filling a cylinder

import javax.swing.*;
import java.awt.*;

public class EX14_10 extends JFrame
{
 public EX14_10()
  {
   add(new cylinder());//�[�Jpanel
  }

 public static void main(String args[])
  {
   EX14_10 frame = new EX14_10();//�ŧi����
   frame.setTitle("EX14_10");//���D
   frame.setSize(400,400); //�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }
}

//��W��class
class cylinder extends JPanel
{
 //ø��
 protected void paintComponent(Graphics g)
  {
   super.paintComponent(g);
   
   //���߮y��XY
   int x = getWidth()/2;
   int y = getHeight()/2;

   //��ꪺ���P�e
   int w = (int)(getWidth()*0.4);
   int h = (int)(getHeight()*0.2);
   int rectY = y-w+h/2;//��
   x-=w/2;//�NX����

   //ø�s�������
   g.setColor(Color.blue);
   g.fillOval(x,y,w,h);
   //ø�s��t
   g.setColor(Color.black);
   g.drawOval(x,y,w,h); 

   //ø�s�W��
   g.setColor(Color.blue);
   g.fillRect(x,rectY,w,w);  
   
   y-=w;//�NY�W��
   //ø�s������
   g.fillOval(x,y,w,h);
   g.setColor(Color.black);
   g.drawOval(x,y,w,h);
  }
}