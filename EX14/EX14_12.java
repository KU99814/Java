//Plotting the sine function

import javax.swing.*;
import java.awt.*;

public class EX14_12 extends JFrame
{
 public EX14_12()
  {
   add(new SineFunction());//�[�J
  }

 public static void main(String args[])
  {
   EX14_12 frame = new EX14_12();//�ŧi����
   frame.setTitle("EX14_12");//���D
   frame.setSize(400,400);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }
}

//���sin�禡
class SineFunction extends JPanel
{
 //ø�s
 protected void paintComponent(Graphics g)
  {
   super.paintComponent(g);

   //x-ray
   g.drawLine(0,getHeight()/2,getWidth(),getHeight()/2);
   g.drawLine(getWidth(),getHeight()/2,getWidth()-6,getHeight()/2-8);
   g.drawLine(getWidth(),getHeight()/2,getWidth()-6,getHeight()/2+8);
   g.drawString("x",getWidth()-6,getHeight()/2-15);

   //y-ray
   g.drawLine(getWidth()/2,0,getWidth()/2,getHeight());
   g.drawLine(getWidth()/2,0,getWidth()/2-6,8);
   g.drawLine(getWidth()/2,0,getWidth()/2+6,8);
   g.drawString("y",getWidth()/2+16,10);

   g.drawString("0",getWidth()/2+10,getHeight()/2+10);//���I

   //sine function
   Polygon p = new Polygon();
   for(int x=-getWidth()/4;x<=getWidth()/4;x++)
    p.addPoint(x + getWidth()/2,getHeight()/2 - (int)(getWidth()/8*Math.sin((x/(double)(getWidth()/4))*2*Math.PI)));
   
   //PI
   g.drawString("-2\u03c0",-getWidth()/4+getWidth()/2-10,getHeight()/2+20);
   g.drawString("2\u03c0",getWidth()/4+getWidth()/2-10,getHeight()/2-20);
   g.drawPolyline(p.xpoints,p.ypoints,p.npoints);
  }
}