//The Tick source component

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class EX32_6 extends JFrame
{
 private MovingMessage movingMessage = new MovingMessage();

 public EX32_6()
  {
   add(movingMessage);
  }

 public static void main(String args[])
  {
   EX32_6 frame = new EX32_6();
   
   frame.setTitle("EX32_6");//標題
   frame.setSize(250,250);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }

 //顯示移動訊息面板
 class MovingMessage extends JPanel
  {
   private Tick tick = new Tick(10,500,1,10);
   private int x = 0;
   String message = "";

   public MovingMessage()
    {
     tick.addTickListener(new drawListener());
     tick.resume();
    }
   
   protected void paintComponent(Graphics g)
    {
      super.paintComponent(g);
     
     int y = getHeight()/2-20;

     g.drawString(message, x, y);
    }

   //重繪事件
   public class drawListener implements TickListener
    {
     public void handleTick(TickEvent e)
      {
       message = "Tick count:"+e.getTickCount()+
                 "\nTick Interval:"+e.getTickInterval();
       x++;
       repaint();
      }
    }
  }
}