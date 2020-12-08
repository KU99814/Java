//Displaying octagon

import javax.swing.*;
import java.awt.*;

public class EX14_8 extends JFrame
{
 public EX14_8()
  {
   add(new OctagonPanel());//加入panel
  }
 
 public static void main(String args[])
  {
   EX14_8 frame = new EX14_8();//宣告視窗
   frame.setTitle("EX14_8");//標題
   frame.setSize(400,400); //大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }
}

//Octagon Panel class
class OctagonPanel extends JPanel
{
 //繪圖
 protected void paintComponent(Graphics g)
  {
   super.paintComponent(g);
   
   //中心X Y座標
   int x = getWidth()/2;
   int y = getHeight()/2;
  
   int radius = (int)(Math.min(x*2,y*2)*0.4);//半徑

   Polygon polygon = new Polygon();  //set polygon//繪出多邊形
   
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
   g.drawPolygon(polygon); //繪圖
  } 
}