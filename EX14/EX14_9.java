//Creating four fans

import javax.swing.*;
import java.awt.*;

public class EX14_9 extends JFrame
{
 public EX14_9()
  {
   setLayout(new GridLayout(2,2));//�]�wlayout
   
   for(int i=0;i<4;i++)//�[�Jpanel
    add(new Fans());
  }

 public static void main(String args[])
  {
   EX14_9 frame = new EX14_9();//�ŧi����
   frame.setTitle("EX14_9");//���D
   frame.setSize(400,400);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }
}

//����class
class Fans extends JPanel
{
 //ø��
 protected void paintComponent(Graphics g)
  {
   super.paintComponent(g);

   //���߮y��XY   
   int x = getWidth()/2;
   int y = getHeight()/2;

   //�b�|
   int radius = (int)(Math.min(x*2,y*2)*0.4);

   //�]���O�q���W�����k�U���}�lø�� �Ԩ쥪�W��
   x-=radius;
   y-=radius;

   //�|�~���
   g.drawOval(10,10,radius*2+20,radius*2+20);

   //ø�s����
   g.fillArc(x,y,2*radius,2*radius,0,30);
   g.fillArc(x,y,2*radius,2*radius,90,30);
   g.fillArc(x,y,2*radius,2*radius,180,30);
   g.fillArc(x,y,2*radius,2*radius,270,30);
  }
}
   