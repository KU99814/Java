//Controlling multiple moving labels

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EX15_11 extends JFrame
{
 public EX15_11()
  {
   add(new MoveLabel());//宣告並加入panel
  }

 public static void main(String args[])
  {
   EX15_11 frame = new EX15_11();//宣告視窗
   frame.setTitle("EX15_11");//標題
   frame.setSize(400,400);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }

 //事件panel
 class MoveLabel extends JPanel
  {
   int x = -30;//起始X座標

   public MoveLabel()
    {
     //加入計時器
     Timer time = new Timer(1000,new TimerListener());
     time.start();//開始動作
    }
   
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);
     
     int y = 50;
     if(x < -20)//x跑到最左時 回到最右
      x = getWidth();
     x-=10;//每次繪圖往左移動
    
     //顯示文字 每一行漸漸往右移
     for(int i=1;i<=10;i++)
      {
       g.drawString("Line Number "+i,x+i*10,y+20*i);
      }
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