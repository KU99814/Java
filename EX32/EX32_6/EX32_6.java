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
   
   frame.setTitle("EX32_6");//���D
   frame.setSize(250,250);//�j�p
   frame.setLocationRelativeTo(null);//�۹��m
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ʧ@
   frame.setVisible(true);//���
  }

 //��ܲ��ʰT�����O
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

   //��ø�ƥ�
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