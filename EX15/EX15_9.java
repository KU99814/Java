//Drawing lines using the keys

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class EX15_9 extends JFrame
{
 //現在所在座標
 int x = 100;
 int y = 100;

 public EX15_9()
  {
   KeyAction p1 = new KeyAction();//宣告事件panel
   p1.setFocusable(true);//設定接受鍵盤事件
   add(p1);//加入
  }

 public static void main(String args[])
  {
   EX15_9 frame = new EX15_9();//宣告視窗
   frame.setTitle("EX15_9");//標題
   frame.setSize(400,200);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }

 //事件panel
 class KeyAction extends JPanel
  {
   //繪圖用polygon
   Polygon p = new Polygon();

   //建構子
   public KeyAction()
    {
     //加入初始的點
     p.addPoint(x,y);

     //加入鍵盤事件
     addKeyListener(new KeyAdapter() {      
      public void keyPressed(KeyEvent e) {
        //根據按鍵決定加入的點座標
        switch(e.getKeyCode()) {
         case KeyEvent.VK_DOWN: y+=20;p.addPoint(x,y);break;//按下 座標下移
         case KeyEvent.VK_UP: y-=20;p.addPoint(x,y);break;//按上 座標上移
         case KeyEvent.VK_LEFT: x-=20;p.addPoint(x,y);break;//按左 座標左移
         case KeyEvent.VK_RIGHT: x+=20;p.addPoint(x,y);break;//按右 座標右移
        }

       repaint();//重繪
      }
     });
    }

   //繪圖
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);
     
     //根據polygon繪出線
     g.drawPolyline(p.xpoints,p.ypoints,p.npoints);
    }
  }
}