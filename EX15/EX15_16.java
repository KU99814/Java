//Moving a circle using the keys

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class EX15_16 extends JFrame
{
 //初始圓座標
 int x = 100;
 int y = 100;

 public EX15_16()
  {
   KeyAction p1 = new KeyAction();//宣告panel
   p1.setFocusable(true);//設定接受按鍵事件
   add(p1);//加入
  }

 public static void main(String args[])
  {
   EX15_16 frame = new EX15_16();//宣告視窗
   frame.setTitle("EX15_16");//標題
   frame.setSize(400,200);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }

 //按鍵事件panel
 class KeyAction extends JPanel
  {
   //建構子
   public KeyAction()
    {
     //加入鍵盤事件
     addKeyListener(new KeyAdapter() {      
      public void keyPressed(KeyEvent e) {
        //根據按鍵上下左右來移動
        switch(e.getKeyCode()) {
         case KeyEvent.VK_DOWN: y+=10;break;
         case KeyEvent.VK_UP: y-=10;break;
         case KeyEvent.VK_LEFT: x-=10;break;
         case KeyEvent.VK_RIGHT: x+=10;break;
         default:break;
        }
       repaint();//重繪
      }
     });
    }

   //繪圖
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);
     
     //繪出圓
     g.drawOval(x,y,10,10);
    }
  }
}