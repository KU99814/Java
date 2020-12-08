//Displaying a message where clicked

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class EX15_10 extends JFrame
{
 public EX15_10()
  {
   add(new MouseAction());//宣告並加入panel
  }

 public static void main(String args[])
  {
   EX15_10 frame = new EX15_10();//宣告視窗
   frame.setTitle("EX15_10");//標題
   frame.setSize(400,200);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }

 class MouseAction extends JPanel
  {
   //文字顯示座標
   int x = 100;
   int y = 100;

   //建構子
   public MouseAction()
    {
     //加入滑鼠事件
     addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
       //取得滑鼠座標
       x = e.getX();
       y = e.getY();

       repaint();//重繪
      }
     });
    }

   //繪圖
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);
     
     //圓心座標
     int xCenter = getWidth()/2;
     int yCenter = getHeight()/2;
     
     //繪出圓
     g.setColor(Color.red);
     g.fillOval(xCenter-50,yCenter-50,100,100);
     
     //圓心與滑鼠座標的距離
     int distance = (int)(Math.sqrt(Math.pow(xCenter-x,2) + Math.pow(yCenter-y,2)));

     //繪出文字 顯示滑鼠點擊地是否在圓心
     g.setColor(Color.black);
     if(distance<=50)
      g.drawString("You have clicked inside the circle",x,y);
     else
      g.drawString("You don't have clicked inside the circle",x,y);    
    }
  }
}