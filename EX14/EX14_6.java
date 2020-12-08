//Improving FigurePanel

import javax.swing.*;
import java.awt.*;

public class EX14_6 extends JFrame
{
 public EX14_6()
  {
   setLayout(new GridLayout(2,2));//設定layout
   //加入繪製不同圖形型的panel
   add(new FigurePanel(FigurePanel.DARC));
   add(new FigurePanel(FigurePanel.DPOLYGON));
   add(new FigurePanel(FigurePanel.FARC));
   add(new FigurePanel(FigurePanel.FPOLYGON));
  }
 
 public static void main(String args[])
  {
   EX14_6 frame = new EX14_6();//宣告視窗
   frame.setTitle("EX14_6");//標題
   frame.setSize(400,400);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }
}

//繪圖的panel
class FigurePanel extends JPanel
{
 //擁有的繪製類型
 public static final int DARC = 1;  //drawArc
 public static final int FARC = 2;  //fill arc
 public static final int DPOLYGON = 3; //draw polygon
 public static final int FPOLYGON = 4; //fill polygon

 int type;//選擇的繪製類型

 //建構子
 public FigurePanel(int type)
  {
   this.type = type;
  }

 //繪圖
 protected void paintComponent(Graphics g)
  {
   super.paintComponent(g);
   
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

   x-=radius;
   y-=radius;

   //paint graphic by type
   switch(type)
    {
     case DARC:  g.drawArc(x,y,2*radius,2*radius,0,30);
                 g.drawArc(x,y,2*radius,2*radius,90,30);
                 g.drawArc(x,y,2*radius,2*radius,180,30);
                 g.drawArc(x,y,2*radius,2*radius,270,30); 
                 break;
     case FARC:  g.fillArc(x,y,2*radius,2*radius,0,30);
                 g.fillArc(x,y,2*radius,2*radius,90,30);
                 g.fillArc(x,y,2*radius,2*radius,180,30);
                 g.fillArc(x,y,2*radius,2*radius,270,30);
                 break;
     case DPOLYGON: g.drawPolygon(polygon);
                    break;
     case FPOLYGON: g.fillPolygon(polygon);
                    break;
    }
  } 
}