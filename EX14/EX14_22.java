//Displaying a Stop sign

import javax.swing.*;
import java.awt.*;

public class EX14_22 extends JFrame
{
 public EX14_22()
  {
   Stop stop = new Stop();//�ŧipanel
   stop.setFont(new Font("Californian FB",Font.BOLD,60));//�]�w�ۦ�
   add(stop);//�[�J
  }
 
 public static void main(String args[])
  {
   EX14_22 frame = new EX14_22();//�ŧi����
   frame.setTitle("EX14_22");//���D
   frame.setSize(400,400);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }
}

//STOP�лxclass
class Stop extends JPanel
{
 //ø��
 protected void paintComponent(Graphics g)
  {
   super.paintComponent(g);

   //���߮y�ЩM�b�|
   int x = getWidth()/2;
   int y = getHeight()/2;
   int radius = (int)(Math.min(x*2,y*2)*0.4);

   Polygon polygon = new Polygon();  //set polygon
   
   //add point
   polygon.addPoint(x+radius,y);
   polygon.addPoint((int)(x+radius * Math.cos(2*Math.PI/6)),
                    (int)(y-radius * Math.sin(2*Math.PI/6)));
   polygon.addPoint((int)(x+radius * Math.cos(2*2*Math.PI/6)),
                    (int)(y-radius * Math.sin(2*2*Math.PI/6)));
   polygon.addPoint((int)(x+radius * Math.cos(3*2*Math.PI/6)),
                    (int)(y-radius * Math.sin(3*2*Math.PI/6)));
   polygon.addPoint((int)(x+radius * Math.cos(4*2*Math.PI/6)),
                    (int)(y-radius * Math.sin(4*2*Math.PI/6)));
   polygon.addPoint((int)(x+radius * Math.cos(5*2*Math.PI/6)),
                    (int)(y-radius * Math.sin(5*2*Math.PI/6)));

   //�~��
   g.setColor(Color.red);
   g.fillPolygon(polygon);
 
   //��r   
   g.setColor(Color.white);
   g.drawString("STOP",(int)(x+radius * Math.cos(2*2*Math.PI/6)),(int)(y+radius * 0.1));
  } 
}