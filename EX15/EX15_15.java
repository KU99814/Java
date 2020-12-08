//racing car

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EX15_15 extends JFrame
{
 public EX15_15()
  {
   add(new RaceCar());//宣告並加入panel
  }

 public static void main(String args[])
  {
   EX15_15 frame = new EX15_15();//宣告視窗
   frame.setTitle("EX15_15");//標題
   frame.setSize(400,200);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }

 //車子class
 class RaceCar extends JPanel
  {
   int x = 0;//初始X座標
   
   //建構子
   public RaceCar()
    {
     //宣告計時器
     Timer time = new Timer(1000,new TimerListener());
     time.start();//開始動作
    }

   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);
     
     int y = getHeight();//繪圖參考Y座標
     
     //車輪
     g.setColor(Color.red);
     g.fillOval(x+10,y-10,10,10);
     g.fillOval(x+30,y-10,10,10);

     //車身
     g.setColor(Color.blue);
     g.fillRect(x,y-20,50,10);
     
     //車頂
     Polygon p = new Polygon();
     
     //加入各頂點
     p.addPoint(x+20,y-30);
     p.addPoint(x+30,y-30);
     p.addPoint(x+40,y-20);
     p.addPoint(x+10,y-20);
     
     //繪圖
     g.setColor(Color.green);
     g.fillPolygon(p);
     
     x+=10;//移動
     if(x+50>getWidth())//到達畫面最右側時 回到左側
      x=0;
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
}   
