//Displaying a character

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class EX15_8 extends JFrame
{
 char message = ' ';//顯示的字串

 //顯示的座標
 int x = 20;
 int y = 20;

 public EX15_8()
  {
   KeyAction p1 = new KeyAction();//宣告事件panel
   p1.setFocusable(true);//設定接受鍵盤事件
   add(p1);//加入
  }

 public static void main(String args[])
  {
   EX15_8 frame = new EX15_8();//宣告視窗
   frame.setTitle("EX15_8");//標題
   frame.setSize(200,200);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }

 //事件panel
 class KeyAction extends JPanel
  {
   //建構子
   public KeyAction()
    {
     //加入鍵盤事件
     addKeyListener(new KeyAdapter() {      
      public void keyPressed(KeyEvent e) {
       //顯示按下的按鍵文字
       message = e.getKeyChar();
       repaint();//重繪
      }
     });

     //加入滑鼠動作事件
     addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseMoved(MouseEvent e) {
       //取得滑鼠座標 帶入文字顯示座標
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
     
     //顯示文字
     g.drawString(String.valueOf(message),x,y);
    }
  }
}