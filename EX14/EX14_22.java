//Displaying a Stop sign

import javax.swing.*;
import java.awt.*;

public class EX14_22 extends JFrame
{
 public EX14_22()
  {
   Stop stop = new Stop();//宣告panel
   stop.setFont(new Font("Californian FB",Font.BOLD,60));//設定自行
   add(stop);//加入
  }
 
 public static void main(String args[])
  {
   EX14_22 frame = new EX14_22();//宣告視窗
   frame.setTitle("EX14_22");//標題
   frame.setSize(400,400);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }
}

//STOP標誌class
class Stop extends JPanel
{
 //繪圖
 protected void paintComponent(Graphics g)
  {
   super.paintComponent(g);

   //中心座標和半徑
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

   //外型
   g.setColor(Color.red);
   g.fillPolygon(polygon);
 
   //文字   
   g.setColor(Color.white);
   g.drawString("STOP",(int)(x+radius * Math.cos(2*2*Math.PI/6)),(int)(y+radius * 0.1));
  } 
}