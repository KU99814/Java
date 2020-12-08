//Displaying a rectanguloid

import javax.swing.*;
import java.awt.*;

public class EX14_23 extends JFrame
{
 public EX14_23()
  {
   add(new Rectanguloid());//�[�J
  }

 public static void main(String args[])
  {
   EX14_23 frame = new EX14_23();//�ŧi����
   frame.setTitle("EX14_23");//���D
   frame.setSize(400,300);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }
}


//������class
class Rectanguloid extends JPanel
{
 //ø��
 protected void paintComponent(Graphics g)
  {
   super.paintComponent(g);
   
   //���P�e
   int w = (int)(getWidth()*0.6);
   int h = (int)(getHeight()*0.4);

   //����
   int x = getWidth()/2;
   int y = getHeight()/2;

   //�᭱����|���
   g.drawLine(x-(w/2),y-(h/2),x+(w/2),y-(h/2));
   g.drawLine(x-(w/2),y+(h/2),x+(w/2),y+(h/2));
   g.drawLine(x-(w/2),y-(h/2),x-(w/2),y+(h/2));
   g.drawLine(x+(w/2),y-(h/2),x+(w/2),y+(h/2));

   //�e������|���
   g.drawLine(x-(w/2)-(x/6),y-(h/2)+(y/4),x+(w/2)-(x/6),y-(h/2)+(y/4));
   g.drawLine(x-(w/2)-(x/6),y+(h/2)+(y/4),x+(w/2)-(x/6),y+(h/2)+(y/4));
   g.drawLine(x-(w/2)-(x/6),y-(h/2)+(y/4),x-(w/2)-(x/6),y+(h/2)+(y/4));
   g.drawLine(x+(w/2)-(x/6),y-(h/2)+(y/4),x+(w/2)-(x/6),y+(h/2)+(y/4));

   //�����|��
   g.drawLine(x-(w/2)-(x/6),y-(h/2)+(y/4),x-(w/2),y-(h/2));
   g.drawLine(x-(w/2)-(x/6),y+(h/2)+(y/4),x-(w/2),y+(h/2));
   g.drawLine(x+(w/2)-(x/6),y-(h/2)+(y/4),x+(w/2),y-(h/2));
   g.drawLine(x+(w/2)-(x/6),y+(h/2)+(y/4),x+(w/2),y+(h/2));
  }
}