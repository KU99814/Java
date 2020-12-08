import javax.swing.*;
import java.awt.*;

public abstract class AbstractDrawFunction extends JPanel
{
 private Polygon p = new Polygon();//�h���

 //�غc�l ���ŧi
 protected AbstractDrawFunction()
  {
   drawFunction();
  }

 //��� ��������@
 abstract double f(double x);

 //ø�s���
 public void drawFunction()
  {
   for(int x = -100;x<=100;x++)
    p.addPoint(x+150,200-(int)(f(x)));
  }

 //ø��
 protected void paintComponent(Graphics g)
  {
   super.paintComponent(g);

   //x-ray
   g.drawLine(0,getHeight()/2,getWidth(),getHeight()/2);
   g.drawLine(getWidth(),getHeight()/2,getWidth()-6,getHeight()/2-8);
   g.drawLine(getWidth(),getHeight()/2,getWidth()-6,getHeight()/2+8);
   g.drawString("x",getWidth()-10,getHeight()/2-10);
   
   //y-ray
   g.drawLine(getWidth()/2,0,getWidth()/2,getHeight());
   g.drawLine(getWidth()/2,0,getWidth()/2-6,8);
   g.drawLine(getWidth()/2,0,getWidth()/2+6,8);
   g.drawString("y",getWidth()/2+20,10);
   
   //ø�s�ϫ�
   g.drawPolyline(p.xpoints,p.ypoints,p.npoints);
  }
}