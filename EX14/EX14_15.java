//Displaying a pie chart

import javax.swing.*;
import java.awt.*;

public class EX14_15 extends JFrame
{
 public EX14_15()
  {
   add(new PieChart());//加入panel
  }
 
 public static void main(String args[])
  {
   EX14_15 frame = new EX14_15();//宣告視窗
   frame.setTitle("EX14_15");//標題
   frame.setSize(300,200);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }
}

//圓餅圖
class PieChart extends JPanel
{
 //繪圖
 protected void paintComponent(Graphics g)
  {
   super.paintComponent(g);

   //中心座標   
   int x = getWidth()/2;
   int y = getHeight()/2;
   int radius = (int)(Math.min(x*2,y*2)*0.4);//半徑

   //往左上移以方便繪圖
   x-=radius;
   y-=radius;

   int d = 0;//移動的角度

   //按百分比繪製圓餅圖
   g.setColor(Color.red);
   g.fillArc(x,y,2*radius,2*radius,d,(int)(360*0.2));
   d += (int)(360*0.2);
   g.drawString("Project -- 20%",getWidth()/2+radius,getHeight()/2-(int)(radius*0.5));

   g.setColor(Color.blue);
   g.fillArc(x,y,2*radius,2*radius,d,(int)(360*0.1));
   d += (int)(360*0.1);
   g.drawString("Quizzes -- 10%",getWidth()/2,getHeight()/2-radius);

   g.setColor(Color.green);
   g.fillArc(x,y,2*radius,2*radius,d,(int)(360*0.3));
   d+=(int)(360*0.3);
   g.drawString("Midterms -- 30%",0,getHeight()/2);

   g.setColor(Color.orange);
   g.fillArc(x,y,2*radius,2*radius,d,(int)(360*0.4));
   g.drawString("Final -- 40%",getWidth()/2,getHeight());
  }
}