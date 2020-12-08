//plotting the square function

import javax.swing.*;
import java.awt.*;

public class EX14_11 extends JFrame
{
 public EX14_11()
  {
   add(new SquareFunction());//�[�J����
  }

 public static void main(String args[])
  {
   EX14_11 frame = new EX14_11();//�ŧi����
   frame.setTitle("EX14_11");//���D
   frame.setSize(420,250);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }
}

//��ܨ��class
class SquareFunction extends JPanel
{
 //ø��
 protected void paintComponent(Graphics g)
  {
   super.paintComponent(g);

   //x-ray   
   g.drawLine(10,getHeight()-10,getWidth()-10,getHeight()-10);
   g.drawLine(getWidth()-10,getHeight()-10,getWidth()-18,getHeight()-16);
   g.drawLine(getWidth()-10,getHeight()-10,getWidth()-18,getHeight()-4);
   g.drawString("x",getWidth()-10,getHeight()-15);
   
   //y-ray
   g.drawLine(getWidth()/2-10,getHeight(),getWidth()/2-10,20);
   g.drawLine(getWidth()/2-10,20,getWidth()/2-16,28);
   g.drawLine(getWidth()/2-10,20,getWidth()/2-4,28);
   g.drawString("y",getWidth()/2-10,10);

   Polygon p = new Polygon();//ø�P���

   //f(x) = x*x
   double scaleFactor = 0.01;//�Y�p�ؤo
   for(int x=-100;x<=100;x++)
    p.addPoint(x+(getWidth()/2)-10,(getHeight()-10)-(int)(scaleFactor*x*x));
   g.drawPolyline(p.xpoints,p.ypoints,p.npoints);//ø��
  }
}