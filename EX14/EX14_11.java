//plotting the square function

import javax.swing.*;
import java.awt.*;

public class EX14_11 extends JFrame
{
 public EX14_11()
  {
   add(new SquareFunction());//加入視窗
  }

 public static void main(String args[])
  {
   EX14_11 frame = new EX14_11();//宣告視窗
   frame.setTitle("EX14_11");//標題
   frame.setSize(420,250);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }
}

//顯示函數class
class SquareFunction extends JPanel
{
 //繪圖
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

   Polygon p = new Polygon();//繪致函數

   //f(x) = x*x
   double scaleFactor = 0.01;//縮小尺寸
   for(int x=-100;x<=100;x++)
    p.addPoint(x+(getWidth()/2)-10,(getHeight()-10)-(int)(scaleFactor*x*x));
   g.drawPolyline(p.xpoints,p.ypoints,p.npoints);//繪圖
  }
}