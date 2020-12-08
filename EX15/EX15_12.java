//Creating a running fans

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EX15_12 extends JFrame
{
 public EX15_12()
  {
   add(new Fans());//宣告並加入panel
  }

 public static void main(String args[])
  {
   EX15_12 frame = new EX15_12();//宣告視窗
   frame.setTitle("EX15_12");//標題
   frame.setSize(400,400);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }
}

//風扇panel
class Fans extends JPanel
{
 int angle = 0;//起始角度

 //建構子
 public Fans()
  {
   //加入計時器
   Timer time = new Timer(100,new TimerListener());
   time.start();//開始動作
  }

 //繪圖
 protected void paintComponent(Graphics g)
  {
   super.paintComponent(g);
   
   //中心座標與半徑
   int x = getWidth()/2;
   int y = getHeight()/2;
   int radius = (int)(Math.min(x*2,y*2)*0.4);

   //左移繪圖
   x-=radius;
   y-=radius;

   //繪出外圍與風扇
   g.drawOval(x-10,y-10,radius*2+20,radius*2+20);
   g.fillArc(x,y,2*radius,2*radius,angle,30);
   g.fillArc(x,y,2*radius,2*radius,angle+90,30);
   g.fillArc(x,y,2*radius,2*radius,angle+180,30);
   g.fillArc(x,y,2*radius,2*radius,angle+270,30);

   //每次起始角度加10 使風扇旋轉 
   angle+=10;
  }

 //計時動作
 class TimerListener implements ActionListener
  {
   public void actionPerformed(ActionEvent e)
    {
     repaint();//重繪
    }
  } 
}
   