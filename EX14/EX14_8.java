//Displaying octagon

import javax.swing.*;
import java.awt.*;

public class EX14_8 extends JFrame
{
 public EX14_8()
  {
   add(new OctagonPanel());//�[�Jpanel
  }
 
 public static void main(String args[])
  {
   EX14_8 frame = new EX14_8();//�ŧi����
   frame.setTitle("EX14_8");//���D
   frame.setSize(400,400); //�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }
}

//Octagon Panel class
class OctagonPanel extends JPanel
{
 //ø��
 protected void paintComponent(Graphics g)
  {
   super.paintComponent(g);
   
   //����X Y�y��
   int x = getWidth()/2;
   int y = getHeight()/2;
  
   int radius = (int)(Math.min(x*2,y*2)*0.4);//�b�|

   Polygon polygon = new Polygon();  //set polygon//ø�X�h���
   
   //add point
   polygon.addPoint(x+radius,y);
   polygon.addPoint((int)(x+radius * Math.cos(2*Math.PI/8)),
                    (int)(y-radius * Math.sin(2*Math.PI/8)));
   polygon.addPoint((int)(x+radius * Math.cos(2*2*Math.PI/8)),
                    (int)(y-radius * Math.sin(2*2*Math.PI/8)));
   polygon.addPoint((int)(x+radius * Math.cos(3*2*Math.PI/8)),
                    (int)(y-radius * Math.sin(3*2*Math.PI/8)));
   polygon.addPoint((int)(x+radius * Math.cos(4*2*Math.PI/8)),
                    (int)(y-radius * Math.sin(4*2*Math.PI/8)));
   polygon.addPoint((int)(x+radius * Math.cos(5*2*Math.PI/8)),
                    (int)(y-radius * Math.sin(5*2*Math.PI/8)));
   polygon.addPoint((int)(x+radius * Math.cos(6*2*Math.PI/8)),
                    (int)(y-radius * Math.sin(6*2*Math.PI/8)));
   polygon.addPoint((int)(x+radius * Math.cos(7*2*Math.PI/8)),
                    (int)(y-radius * Math.sin(7*2*Math.PI/8)));
   g.drawPolygon(polygon); //ø��
  } 
}