//Entering and displaying a string

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class EX15_7 extends JFrame
{
 String message = "";//顯示的字串

 public EX15_7()
  {
   KeyAction p1 = new KeyAction();//宣告panel
   p1.setFocusable(true);//設定接受鍵盤事件
   add(p1);//加入
  }

 public static void main(String args[])
  {
   EX15_7 frame = new EX15_7();//宣告視窗
   frame.setTitle("EX15_7");//標題
   frame.setSize(200,100);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }

 //鍵盤動作
 class KeyAction extends JPanel
  {
   public KeyAction()
    {
     //加入鍵盤事件
     addKeyListener(new KeyAdapter() {     

      //按鍵事件 
      public void keyPressed(KeyEvent e) {
       //如果按Enter 字串清空
       if(e.getKeyCode() == KeyEvent.VK_ENTER)
        message = "";
       else//其他按鍵顯示出文字
        message += String.valueOf(e.getKeyChar());

       repaint();//重繪
      }
     });
    }

   //繪圖
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);
 
     //顯示文字    
     g.drawString(message,getWidth()/2-50,getHeight()/2);
    }
  }
}