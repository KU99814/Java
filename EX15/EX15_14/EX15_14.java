//raising flag

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EX15_14 extends JFrame
{
 public EX15_14()
  {
   add(new RaisingFlag());//宣告並加入
  }

 public  static void main(String args[])
  {
   EX15_14 frame = new EX15_14();//宣告視窗
   frame.setTitle("EX15_14");//標題
   frame.setSize(300,200);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }

 //升旗class
 class RaisingFlag extends JPanel
  {
   int y = 0;//初始y座標

   //取得圖片
   ImageIcon icon = new ImageIcon("flag6.gif");
   Image image = icon.getImage();

   //建構子
   public RaisingFlag()
    {
     //計時器
     Timer time = new Timer(100,new TimerListener());
     time.start();//開始動作
    }

   //繪圖
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);
     
     //升到頂時回到底部
     if(y<=0)
      y = getHeight()-50;

     //繪圖
     g.drawImage(image,0,y,100,50,this);
     y-=5;//上升
    }

   //計時動作
   class TimerListener implements ActionListener
    {
     public void actionPerformed(ActionEvent e)
      {
       repaint();//繪圖
      }
    }
  }
}