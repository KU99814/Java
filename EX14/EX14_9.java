//Creating four fans

import javax.swing.*;
import java.awt.*;

public class EX14_9 extends JFrame
{
 public EX14_9()
  {
   setLayout(new GridLayout(2,2));//設定layout
   
   for(int i=0;i<4;i++)//加入panel
    add(new Fans());
  }

 public static void main(String args[])
  {
   EX14_9 frame = new EX14_9();//宣告視窗
   frame.setTitle("EX14_9");//標題
   frame.setSize(400,400);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }
}

//風扇class
class Fans extends JPanel
{
 //繪圖
 protected void paintComponent(Graphics g)
  {
   super.paintComponent(g);

   //中心座標XY   
   int x = getWidth()/2;
   int y = getHeight()/2;

   //半徑
   int radius = (int)(Math.min(x*2,y*2)*0.4);

   //因為是從左上角往右下角開始繪圖 拉到左上角
   x-=radius;
   y-=radius;

   //會外圍圓
   g.drawOval(10,10,radius*2+20,radius*2+20);

   //繪製風扇
   g.fillArc(x,y,2*radius,2*radius,0,30);
   g.fillArc(x,y,2*radius,2*radius,90,30);
   g.fillArc(x,y,2*radius,2*radius,180,30);
   g.fillArc(x,y,2*radius,2*radius,270,30);
  }
}
   