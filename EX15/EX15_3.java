//moving the round rectangle

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EX15_3 extends JFrame
{
 //物件座標
 private int x = 50;
 private int y = 50;

 public EX15_3()
  {
   JButton left = new JButton("Left");//左移按鈕
   JButton right = new JButton("Right");//右移按鈕
   JButton up = new JButton("Up");//上移按鈕
   JButton down = new JButton("Down");//下移按鈕

   //給各按鈕加入事件
   left.addActionListener(new LeftClass());
   right.addActionListener(new RightClass());
   up.addActionListener(new UpClass());
   down.addActionListener(new DownClass());

   JPanel p1 = new JPanel();//按鈕panel

   //加入按鈕
   p1.add(left);
   p1.add(right);
   p1.add(up);
   p1.add(down);
   
   setLayout(new BorderLayout());//設定layout
   add(p1,BorderLayout.NORTH);//p1加入在北部
   add(new RoundedRect(),BorderLayout.CENTER);//顯示方塊panel加入在中部
  }

 public static void main(String args[])
  {
   EX15_3 frame = new EX15_3();//宣告視窗
   frame.setTitle("EX15_3");//標題
   frame.setSize(500,300);//大小
   frame.setLocationRelativeTo(null);//相對位置
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//關閉動作
   frame.setVisible(true);//顯示
  }

 //方塊panel
 class RoundedRect extends JPanel
  {
   //繪圖
   protected void paintComponent(Graphics g)
    {
     super.paintComponent(g);
     
     //繪出方塊
     g.setColor(Color.red);//顏色
     g.fillRoundRect(x,y,40,40,10,10);
    }
  }

 //左移按鈕事件
 class LeftClass implements ActionListener
  {
   public void actionPerformed(ActionEvent e)
    {
     x-=10;
     repaint();
    }
  }

 //右移按鈕事件
 class RightClass implements ActionListener
  {
   public void actionPerformed(ActionEvent e)
    {
     x+=10;
     repaint();
    }
  }

 //上移按鈕事件
 class UpClass implements ActionListener
  {
   public void actionPerformed(ActionEvent e)
    {
     y-=10;
     repaint();
    }
  }

 //下移按鈕事件
 class DownClass implements ActionListener
  {
   public void actionPerformed(ActionEvent e)
    {
     y+=10;
     repaint();
    }
  }
}